package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String VALID_PATTERN = "^[a-zA-Z0-9가-힣]+$";

    public void validate(List<String> carNameList) {
        length(carNameList);
        allowedCharacters(carNameList);
        duplicate(carNameList);
    }

    private void length(List<String> carNameList) {
        for (String name : carNameList) {
            if (MAX_NAME_LENGTH < name.length()) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다. (" + name + ")");
            }
        }
    }

    private void allowedCharacters(List<String> carNameList) {
        for (String name : carNameList) {
            if (!name.matches(VALID_PATTERN)) {
                throw new IllegalArgumentException("이름은 영어, 한글, 숫자만 가능합니다. (" + name + ")");
            }
        }
    }

    private void duplicate(List<String> carNameList) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNameList) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("중복된 이름이 존재합니다. (" + name + ")");
            }
        }
    }
}
