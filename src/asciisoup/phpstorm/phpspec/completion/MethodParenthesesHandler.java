package asciisoup.phpstorm.phpspec.completion;

import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;

public class MethodParenthesesHandler extends ParenthesesInsertHandler<SubjectLookupElement> {
    @Override
    protected boolean placeCaretInsideParentheses(InsertionContext context, SubjectLookupElement item) {
        return item.getMethod().getParameters().length > 0;
    }
}
