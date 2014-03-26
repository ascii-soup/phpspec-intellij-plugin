package asciisoup.phpstorm.phpspec.runner;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ConfigurationFactory extends com.intellij.execution.configurations.ConfigurationFactory {

    protected ConfigurationFactory(@NotNull com.intellij.execution.configurations.ConfigurationType type) {
        super(type);
    }

    @Override
    public RunConfiguration createTemplateConfiguration(Project project) {
        return new RunConfiguration(project, this, "phpspec runner");
    }


}
