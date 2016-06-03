package asciisoup.phpstorm.phpspec.util;

import com.jetbrains.php.lang.psi.elements.PhpClass;
import org.jetbrains.annotations.Nullable;

public class PhpSpecUtil {

    @Nullable
    public static PhpClass getSubjectFromSpec(PhpClass specClass) {
        String specClassFQN = specClass.getFQN();
        if (specClassFQN == null) {
            return null;
        }

        // Remove the word "Spec" from the spec's class name
        String fullyQualifiedName = specClassFQN.substring(5, specClassFQN.length() - 4);
        return PhpPsiUtil.findClassByFQN(specClass.getProject(), fullyQualifiedName);
    }

    public static boolean classIsSpec(PhpClass phpClass) {
        return phpClass != null && phpClass.getName().endsWith("Spec");
    }
}
