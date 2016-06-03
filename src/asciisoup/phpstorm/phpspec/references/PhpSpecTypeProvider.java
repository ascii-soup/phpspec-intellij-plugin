package asciisoup.phpstorm.phpspec.references;

import asciisoup.phpstorm.phpspec.util.PhpPsiUtil;
import asciisoup.phpstorm.phpspec.util.PhpSpecUtil;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.lang.psi.elements.MethodReference;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import com.jetbrains.php.lang.psi.elements.PhpNamedElement;
import com.jetbrains.php.lang.psi.elements.Variable;
import com.jetbrains.php.lang.psi.elements.impl.MethodImpl;
import com.jetbrains.php.lang.psi.resolve.types.PhpTypeProvider2;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class PhpSpecTypeProvider implements PhpTypeProvider2 {
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
                    return "SPECS|" + subjectClass.getFQN();
                }
            }
            if (psiElement instanceof MethodReference) {
                MethodReference element = (MethodReference)psiElement;
                PhpClass specClass = PhpPsiUtil.getFirstPhpClassIn(psiElement.getContainingFile());
                if (PhpSpecUtil.classIsSpec(specClass)) {
                    PhpClass subjectClass = PhpSpecUtil.getSubjectFromSpec(specClass);
                    PhpClass stubClass = PhpPsiUtil.findClassByFQN(specClass.getProject(), "AsciiSoup\\PhpSpec\\Stubs\\Matchers");
                    PsiElement resolved = element.resolve();
                    if (resolved instanceof MethodImpl) {
                        if (!stubClass.getMethods().contains(resolved)) {
                            // Get all the return types of the method we're completing for
                            Set<String> types = ((MethodImpl) resolved).getLocalType(false).getTypes();
                            String returnTypes = StringUtils.join(types, "|");
                            return stubClass.getFQN() + "|" + returnTypes;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            return null;
        }

        return null;
    }

    @Override
    public Collection<? extends PhpNamedElement> getBySignature(String s, Project project) {
        Boolean includeSpecs = false;
        Collection<PhpClass> phpClasses = new ArrayList<PhpClass>();
        String[] split = s.split("\\|");
        for (String type : split) {
            if (type.equals("SPECS")) {
                includeSpecs = true;
            }

            phpClasses.addAll(PhpIndex.getInstance(project).getClassesByFQN(type));
            if (includeSpecs) {
                phpClasses.addAll(PhpIndex.getInstance(project).getClassesByFQN("spec" + type + "Spec"));
            }
        }
        return phpClasses;
    }
}
