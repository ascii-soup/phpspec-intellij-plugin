package asciisoup.phpstorm.phpspec.runner;

import asciisoup.phpstorm.phpspec.PhpSpecApplication;
import asciisoup.phpstorm.phpspec.PhpSpecProject;
import asciisoup.phpstorm.phpspec.util.PhpPsiUtil;
import com.intellij.execution.*;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.filters.Filter;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.testframework.sm.SMTestRunnerConnectionUtil;
import com.intellij.execution.testframework.sm.runner.SMTRunnerConsoleProperties;
import com.intellij.execution.testframework.ui.BaseTestsOutputConsoleView;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.util.PsiNavigateUtil;
import com.jetbrains.php.lang.psi.PhpPsiElementFactory;
import com.jetbrains.php.lang.psi.elements.Method;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunProfileState extends CommandLineState {

    private final ExecutionEnvironment environment;
    private final PhpSpecProject phpSpecProject;
    private ProcessHandler processHandler;

    public RunProfileState(ExecutionEnvironment environment, PhpSpecProject phpSpecProject) {
        super(environment);
        this.environment = environment;
        this.phpSpecProject = phpSpecProject;
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        GeneralCommandLine commandLine = new GeneralCommandLine(phpSpecProject.getConfig().binaryPath());
        commandLine.addParameter("run");
//        commandLine.addParameter("--config=phpspec.yml");
        commandLine.addParameter("--format=teamcity");

        //GeneralCommandLine commandLine = new GeneralCommandLine("vendor/testing");
        commandLine.setWorkDirectory(environment.getProject().getBaseDir().getCanonicalPath());

        processHandler = new OSProcessHandler(
                commandLine
        );

        return processHandler;
    }

    @Override
    @NotNull
    public ExecutionResult execute(@NotNull final Executor executor, @NotNull final ProgramRunner runner) throws ExecutionException {
        final ProcessHandler processHandler = startProcess();
        final ConsoleView console = createConsole(executor);
        return new DefaultExecutionResult(console, processHandler, createActions(console, processHandler, executor));
    }

    @Nullable
    @Override
    protected ConsoleView createConsole(@NotNull final Executor executor) throws ExecutionException {
        return SMTestRunnerConnectionUtil.createAndAttachConsole(
                "phpspec",
                processHandler,
                new SMTRunnerConsoleProperties(
                        environment.getRunnerAndConfigurationSettings().getConfiguration(),
                        "phpspec",
                        environment.getExecutor()
                )
        );
    }

}
