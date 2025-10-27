package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputSplitter {
    public List<String> splitComma(String text) {
        validateInput(text);

        List<String> result = Arrays.stream(text.split(",", -1))
                .map(String::trim)
                .collect(Collectors.toList());

        validateResult(result);

        return result;
    }

    private void validateInput(String text) {
        if (text == null) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
    }

    private void validateResult(List<String> result) {
        if (result.isEmpty() || result.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("입력에 빈 값이 존재합니다.");
        }
    }
}
