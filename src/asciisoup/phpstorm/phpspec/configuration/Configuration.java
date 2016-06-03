package asciisoup.phpstorm.phpspec.configuration;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class Configuration implements Configurable {

    private final Project project;
    private final ConfigurationForm form;
    private static final String CONFIG_PHPSPEC_BIN_LOCATION = "asciisoup.phpstorm.phpspec.bin";

    public Configuration(Project project) {
        this.project = project;
        form = new ConfigurationForm();
    }

    public String binaryPath() {
        String value = PropertiesComponent.getInstance(project).getValue(CONFIG_PHPSPEC_BIN_LOCATION);
        if (value == null) {
            return "vendor/bin/phpspec";
        }

        return value;
    }

    private void setBinaryPath(String path) {
        PropertiesComponent.getInstance(project).setValue(CONFIG_PHPSPEC_BIN_LOCATION, path);
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "PhpSpec Settings";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return form.getJpanel();
    }

    @Override
    public boolean isModified() {
        return !binaryPath().equals(form.binField());
    }

    @Override
    public void apply() throws ConfigurationException {
        setBinaryPath(form.binField());
    }

    @Override
    public void reset() {
        form.setBinField(binaryPath());
    }

    @Override
    public void disposeUIResources() {

    }
}
