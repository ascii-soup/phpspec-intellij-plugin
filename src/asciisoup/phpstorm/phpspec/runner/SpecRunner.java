package asciisoup.phpstorm.phpspec.runner;

import com.intellij.execution.runners.BasicProgramRunner;
import org.jetbrains.annotations.NotNull;

public class SpecRunner extends BasicProgramRunner {
    @NotNull
    @Override
    public String getRunnerId() {
        return "phpspecrunner";
    }
}
