package asciisoup.phpstorm.phpspec.completion;

import asciisoup.phpstorm.phpspec.resources.Resources;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementDecorator;
import com.intellij.codeInsight.lookup.LookupElementPresentation;

/**
 * Created by nils on 28/03/14.
 */
public class MatcherLookupElementDecorator extends LookupElementDecorator {
    public MatcherLookupElementDecorator(LookupElement element) {
        super(element);
    }

    @Override
    public void renderElement(LookupElementPresentation presentation) {
        super.renderElement(presentation);
        presentation.setTypeText("Matcher", Resources.SMALL_ICON);
    }
}
