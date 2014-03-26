package asciisoup.phpstorm.phpspec;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class PhpSpecProject implements ProjectComponent {
    private boolean methodLock = false;

    public PhpSpecProject(Project project) {

    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "PhpSpecProject";
    }

    public void projectOpened() {
        // called when project is opened
    }

    public void projectClosed() {
        // called when project is being closed
    }

    public void lockCreatingSubjectMethods() {
        methodLock = true;
    }

    public void unlockCreatingSubjectMethods() {
        methodLock = false;
    }

    public boolean canAddSubjectMethod() {
        return !methodLock;
    }
}
