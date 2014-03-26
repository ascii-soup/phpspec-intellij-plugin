package asciisoup.phpstorm.phpspec;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class PhpSpecApplication implements ApplicationComponent {
    private static Application application = null;

    public PhpSpecApplication(Application application) {
        PhpSpecApplication.application = application;
    }

    public static Application getApplication() {
        return application;
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "PhpSpecApplication";
    }
}
