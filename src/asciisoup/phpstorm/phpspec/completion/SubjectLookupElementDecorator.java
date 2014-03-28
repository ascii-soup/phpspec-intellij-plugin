package asciisoup.phpstorm.phpspec.completion;

import asciisoup.phpstorm.phpspec.resources.Resources;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementDecorator;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.jetbrains.php.lang.psi.elements.Method;

public class SubjectLookupElementDecorator extends LookupElementDecorator {

    public SubjectLookupElementDecorator(LookupElement delegate) {
        super(delegate);
    }

    @Override
    public void renderElement(LookupElementPresentation presentation) {
        super.renderElement(presentation);
        presentation.appendTailText(" from " + ((Method)getDelegate().getPsiElement()).getContainingClass().getPresentableFQN(), true);
        presentation.setTypeText(presentation.getTypeText(), Resources.SMALL_ICON);
    }
}
