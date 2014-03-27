package asciisoup.phpstorm.phpspec.resources;

import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.io.FileUtil;

import java.io.IOException;
import java.io.InputStream;

public class Resources {
    public static final javax.swing.Icon SMALL_ICON = load("/asciisoup/phpstorm/phpspec/resources/icons/phpspec-icon-16x16.png");
    public static final javax.swing.Icon FILE_ICON = load("/asciisoup/phpstorm/phpspec/resources/icons/phpspec-file-icon.png");
    public static final String getMatchersStub() throws IOException { return getFile("/asciisoup/phpstorm/phpspec/resources/stubs/Matchers.php"); }

    public static javax.swing.Icon load(String iconPath) {
        return IconLoader.getIcon(iconPath, Resources.class);
    }

    public static String getFile(String filePath) throws IOException {
        InputStream resourceAsStream = Resources.class.getResource(filePath).openStream();
        return FileUtil.loadTextAndClose(resourceAsStream);
    }
}
