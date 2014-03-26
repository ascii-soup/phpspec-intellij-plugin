package asciisoup.phpstorm.phpspec.completion;

import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.jetbrains.php.completion.PhpLookupElement;
import com.jetbrains.php.lang.psi.elements.Method;

import static asciisoup.phpstorm.phpspec.resources.Resources.SMALL_ICON;

public class SubjectLookupElement extends PhpLookupElement {

    private final Method method;

    public SubjectLookupElement(Method method) {
        super(method);
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public void handleInsert(InsertionContext context) {
        new MethodParenthesesHandler().handleInsert(context, this);
    }

    @Override
    public void renderElement(LookupElementPresentation presentation) {
        super.renderElement(presentation);
        presentation.appendTailText(" from " + method.getContainingClass().getName(), true);
        presentation.setItemTextBold(true);
        presentation.setItemText(getLookupString());
        presentation.setTypeText("method under spec", SMALL_ICON);
    }
}
