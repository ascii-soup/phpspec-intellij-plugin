package asciisoup.phpstorm.phpspec.runner;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.lang.psi.elements.PhpNamedElement;
import com.jetbrains.php.lang.psi.resolve.types.PhpTypeProvider2;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class MatcherTypeProvider implements PhpTypeProvider2 {
    @Override
    public char getKey() {
        return 0;
    }

    @Nullable
    @Override
    public String getType(PsiElement psiElement) {
        return null;
    }

    @Override
    public Collection<? extends PhpNamedElement> getBySignature(String s, Project project) {
        return null;
    }
}
