package asciisoup.phpstorm.phpspec.completion;

import asciisoup.phpstorm.phpspec.resources.Resources;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementDecorator;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.jetbrains.php.lang.psi.elements.Method;

public class MatcherLookupElementDecorator extends LookupElementDecorator {

    public MatcherLookupElementDecorator(LookupElement delegate) {
        super(delegate);
    }

    @Override
    public void renderElement(LookupElementPresentation presentation) {
        super.renderElement(presentation);
        presentation.setIcon(Resources.SMALL_ICON);
        presentation.setTypeText("matcher");
    }
}
