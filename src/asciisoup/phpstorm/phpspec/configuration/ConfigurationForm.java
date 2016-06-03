package asciisoup.phpstorm.phpspec.configuration;

import javax.swing.*;

public class ConfigurationForm {
    private JTextField binPhpspecTextField;
    private JPanel jpanel;

    public JPanel getJpanel() {
        return jpanel;
    }

    public String binField() {
        return binPhpspecTextField.getText();
    }

    public void setBinField(String path) {
        binPhpspecTextField.setText(path);
    }
}
