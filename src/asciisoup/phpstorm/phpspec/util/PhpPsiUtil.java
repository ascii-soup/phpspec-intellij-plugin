package asciisoup.phpstorm.phpspec.util;

import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.lang.psi.elements.PhpClass;

public class PhpPsiUtil {
    public static PhpClass getFirstPhpClassIn(PsiElement psiElement) {

        if (psiElement == null) {
            return null;
        } else if (psiElement instanceof PhpClass) {
            return ((PhpClass)psiElement);
        } else {
            if (psiElement.getChildren().length > 0) {
                for (PsiElement child : psiElement.getChildren()) {
                    PhpClass phpClass = getFirstPhpClassIn(child);
                    if (phpClass != null) {
                        return phpClass;
                    }
                }
            }
        }

        return null;
    }

    public static PhpClass findClassByFQN(Project project, String fullyQualifiedName) {
        if (DumbService.getInstance(project).isDumb()) {
            return null;
        }

        return doFindClassByFQN(project, fullyQualifiedName);
    }

    private static PhpClass doFindClassByFQN(Project project, String fullyQualifiedName) {
        return ((PhpClass) PhpIndex.getInstance(project).getClassesByFQN(fullyQualifiedName).toArray()[0]);
    }
}
