package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CARS_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PLAY_ROUND_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String getCarsName() {
        System.out.println(CARS_NAME_INPUT_MESSAGE);
        return getUserInput();
    }

    public String getRoundNums() {
        System.out.println(PLAY_ROUND_INPUT_MESSAGE);
        return getUserInput();
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
