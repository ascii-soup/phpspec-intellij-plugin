package asciisoup.phpstorm.phpspec.files;

import asciisoup.phpstorm.phpspec.resources.Resources;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PhpSpecFileType extends LanguageFileType {

    protected PhpSpecFileType(@NotNull Language language) {
        super(language);
    }

    @NotNull
    @Override
    public String getName() {
        return "phpspec files";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "spec file for php code";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "php";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Resources.FILE_ICON;
    }
}
