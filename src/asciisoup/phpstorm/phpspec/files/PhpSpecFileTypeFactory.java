package asciisoup.phpstorm.phpspec.files;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileNameMatcher;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PhpSpecFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(new PhpSpecFileType(Language.findLanguageByID("PHP")), new FileNameMatcher() {
            @Override
            public boolean accept(@NonNls @NotNull String fileName) {
                return fileName.endsWith("Spec.php");
            }

            @NotNull
            @Override
            public String getPresentableString() {
                return "*Spec.php";
            }
        });
    }
}
