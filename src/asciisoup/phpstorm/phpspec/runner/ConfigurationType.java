package asciisoup.phpstorm.phpspec.runner;

import asciisoup.phpstorm.phpspec.resources.Resources;
import com.intellij.execution.configurations.ConfigurationTypeBase;

public class ConfigurationType extends ConfigurationTypeBase {

    protected ConfigurationType() {
        super("phpspec", "phpspec runner", "Allows you to run specs within the IDE", Resources.SMALL_ICON);
        addFactory(new ConfigurationFactory(this));
    }
}
