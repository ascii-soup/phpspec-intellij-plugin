package asciisoup.phpstorm.phpspec.completion;

import asciisoup.phpstorm.phpspec.util.PhpPsiUtil;
import asciisoup.phpstorm.phpspec.util.PhpSpecUtil;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResult;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.util.Consumer;
import com.jetbrains.php.lang.psi.elements.PhpClass;

public class MatcherContributor extends CompletionContributor {

    @Override
    public void fillCompletionVariants(CompletionParameters parameters, final CompletionResultSet result) {
        final PhpClass specClass = PhpPsiUtil.getFirstPhpClassIn(parameters.getOriginalFile());
        if ( ! PhpSpecUtil.classIsSpec(specClass)) {
            super.fillCompletionVariants(parameters, result);
            return;
        }

        final PhpClass stubClass = PhpPsiUtil.findClassByFQN(specClass.getProject(), "AsciiSoup\\PhpSpec\\Stubs\\Matchers");

        result.runRemainingContributors(parameters, new Consumer<CompletionResult>() {
            @Override
            public void consume(CompletionResult completionResult) {
                LookupElement element = completionResult.getLookupElement();
                try {
                    if (stubClass.getMethods().contains(element.getPsiElement())) {
                        element = new MatcherLookupElementDecorator(element);
                    }
                } catch (NullPointerException e) {
                    // We've already set element, no need to do it again.
                }

                result.addElement(element);
            }
        });
    }
}
