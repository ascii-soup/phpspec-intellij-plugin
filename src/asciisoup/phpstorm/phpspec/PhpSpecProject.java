package asciisoup.phpstorm.phpspec;

import asciisoup.phpstorm.phpspec.resources.Resources;
import asciisoup.phpstorm.phpspec.util.PhpPsiUtil;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.jetbrains.php.lang.psi.PhpPsiElementFactory;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class PhpSpecProject implements ProjectComponent {
    public PhpClass matchersClass;
    private boolean methodLock = false;

    public PhpSpecProject(Project project) {
        try {
            PsiFile psiFile = PhpPsiElementFactory.createPsiFileFromText(project, Resources.getMatchersStub());
            matchersClass = PhpPsiUtil.getFirstPhpClassIn(psiFile);
        } catch (IOException e) {
            matchersClass = null;
        }
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
