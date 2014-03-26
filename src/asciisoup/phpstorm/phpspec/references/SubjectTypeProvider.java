package asciisoup.phpstorm.phpspec.references;

import asciisoup.phpstorm.phpspec.util.PhpPsiUtil;
import asciisoup.phpstorm.phpspec.util.PhpSpecUtil;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import com.jetbrains.php.lang.psi.elements.PhpNamedElement;
import com.jetbrains.php.lang.psi.elements.Variable;
import com.jetbrains.php.lang.psi.resolve.types.PhpTypeProvider2;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class SubjectTypeProvider implements PhpTypeProvider2 {
    @Override
    public char getKey() {
        return 0;
    }

    @Nullable
    @Override
    public String getType(PsiElement psiElement) {
        try {
            if (psiElement instanceof Variable && psiElement.getText().equals("$this")) {
                PhpClass specClass = PhpPsiUtil.getFirstPhpClassIn(psiElement.getContainingFile());
                if (PhpSpecUtil.classIsSpec(specClass)) {
                    PhpClass subjectClass = PhpSpecUtil.getSubjectFromSpec(specClass);
                    return subjectClass.getFQN();
                }
            }
        } catch (NullPointerException e) {
            return null;
        }

        return null;
    }

    @Override
    public Collection<? extends PhpNamedElement> getBySignature(String s, Project project) {
        Collection<PhpClass> phpClasses = new ArrayList<PhpClass>(PhpIndex.getInstance(project).getClassesByFQN(s));
        phpClasses.addAll(PhpIndex.getInstance(project).getClassesByFQN("spec" + s + "Spec"));
        return phpClasses;
    }
}
