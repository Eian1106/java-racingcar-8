package racingcar.validator;

public class RoundNumValidator {

    public void validate(String round) {
        notEmpty(round);
        isNumber(round);
        intRange(round);
        notNegative(round);
    }

    private void notEmpty(String round) {
        if (round == null || round.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
    }

    private void isNumber(String round) {
        if (!round.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다. (" + round + ")");
        }
    }

    private void intRange(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 int 범위를 초과했습니다. (" + round + ")");
        }
    }

    private void notNegative(String round) {
        int value = Integer.parseInt(round);
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다. (" + round + ")");
        }
    }
}
