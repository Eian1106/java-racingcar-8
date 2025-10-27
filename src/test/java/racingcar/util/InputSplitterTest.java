package racingcar.util;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputSplitterTest {

    private final InputSplitter inputSplitter = new InputSplitter();

    @Test
    @DisplayName("정상적인 입력")
    void splitComma_validInput_success() {
        String input = "pobi,woni,jun";

        List<String> result = inputSplitter.splitComma(input);

        assertThat(result)
                .hasSize(3)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("공백을 포함한 입력은 trim 처리")
    void splitComma_trimSpaces() {
        String input = " pobi , woni , jun ";

        List<String> result = inputSplitter.splitComma(input);

        assertThat(result)
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest(name = "[{index}] 예외 발생 입력: \"{0}\"")
    @NullSource
    @ValueSource(strings = {",", " , , ", "pobi,,woni", ""})
    @DisplayName("null, 빈 값, 혹은 빈 항목이 포함된 입력은 예외 발생")
    void splitComma_invalidInput_throwsException(String input) {
        assertThatThrownBy(() -> inputSplitter.splitComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}