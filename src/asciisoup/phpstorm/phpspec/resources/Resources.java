package asciisoup.phpstorm.phpspec.resources;

import com.intellij.openapi.util.IconLoader;

public class Resources {
    public static final javax.swing.Icon SMALL_ICON = load("/asciisoup/phpstorm/phpspec/resources/icons/phpspec-icon-16x16.png");
    public static final javax.swing.Icon FILE_ICON = load("/asciisoup/phpstorm/phpspec/resources/icons/phpspec-file-icon.png");

    public static javax.swing.Icon load(String iconPath) {
        return IconLoader.getIcon(iconPath, Resources.class);
    }
}
