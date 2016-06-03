package asciisoup.phpstorm.phpspec.runner;

import asciisoup.phpstorm.phpspec.PhpSpecProject;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunConfigurationBase;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class RunConfiguration extends RunConfigurationBase {

    private final Project project;

    public RunConfiguration(Project project, com.intellij.execution.configurations.ConfigurationFactory factory, String name) {
        super(project, factory, name);
        this.project = project;
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment env) throws ExecutionException {
        return new RunProfileState(env, project.getComponent(PhpSpecProject.class));
    }

    @NotNull
    @Override
    public SettingsEditor<? extends com.intellij.execution.configurations.RunConfiguration> getConfigurationEditor() {
        return new SettingsEditor<com.intellij.execution.configurations.RunConfiguration>() {
            @Override
            protected void resetEditorFrom(com.intellij.execution.configurations.RunConfiguration s) {

            }

            @Override
            protected void applyEditorTo(com.intellij.execution.configurations.RunConfiguration s) throws ConfigurationException {

            }

            @NotNull
            @Override
            protected JComponent createEditor() {
                JLabel jLabel = new JLabel("There are no configuration settings for phpspec.");
                FlowLayout flowLayout = new FlowLayout();
                flowLayout.addLayoutComponent("label", jLabel);
                return new JPanel(flowLayout);
            }
        };
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {

    }
}
