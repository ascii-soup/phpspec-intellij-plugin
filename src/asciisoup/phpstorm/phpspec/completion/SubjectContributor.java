package asciisoup.phpstorm.phpspec.completion;

import asciisoup.phpstorm.phpspec.PhpSpecProject;
import asciisoup.phpstorm.phpspec.util.PhpPsiUtil;
import asciisoup.phpstorm.phpspec.util.PhpSpecUtil;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResult;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.util.Consumer;
import com.jetbrains.php.completion.PhpLookupElement;
import com.jetbrains.php.lang.psi.elements.Method;
import com.jetbrains.php.lang.psi.elements.PhpClass;

public class SubjectContributor extends CompletionContributor {

    @Override
    public void fillCompletionVariants(CompletionParameters parameters, final CompletionResultSet result) {
        final PhpClass specClass = PhpPsiUtil.getFirstPhpClassIn(parameters.getOriginalFile());
        if ( ! PhpSpecUtil.classIsSpec(specClass)) {
            super.fillCompletionVariants(parameters, result);
            return;
        }

        final PhpClass subjectClass = PhpSpecUtil.getSubjectFromSpec(specClass);
        final PhpClass matchersClass = parameters.getPosition().getProject().getComponent(PhpSpecProject.class).matchersClass;

        result.runRemainingContributors(parameters, new Consumer<CompletionResult>() {
            @Override
            public void consume(CompletionResult completionResult) {
                LookupElement element = completionResult.getLookupElement();
                try {
                    if (subjectClass.getMethods().contains(element.getPsiElement())) {
                        element = new SubjectLookupElementDecorator(element);
                    } else {
                        for (Method method : matchersClass.getMethods()) {
                            if (method.getName().equals(((PhpLookupElement) element).getNamedElement().getName())) {
                                element = new MatcherLookupElementDecorator(element);
                                break;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    // We've already set element, no need to do it again.
                }

                result.addElement(element);
            }
        });
    }
}
