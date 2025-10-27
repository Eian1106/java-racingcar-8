package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.RacingGame;
import racingcar.util.InputSplitter;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.RoundNumValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputSplitter inputSplitter = new InputSplitter();
    private final CarNamesValidator carNamesValidator = new CarNamesValidator();
    private final RoundNumValidator roundNumValidator = new RoundNumValidator();

    public void run() {
        String carNames = inputView.getCarNames();
        List<String> carNameList = inputSplitter.splitComma(carNames);
        carNamesValidator.validate(carNameList);

        String roundNums = inputView.getRoundNums();
        roundNumValidator.validate(roundNums);
        int round = Integer.parseInt(roundNums);

        Cars cars = new Cars();
        cars.createCars(carNameList);
        List<Car> playCarList = cars.getCarList();

        RacingGame racingGame = new RacingGame(playCarList);

        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            Map<String, Integer> roundResult = racingGame.getRoundResult();
            outputView.printRoundResult(roundResult);
        }

        List<String> winners = racingGame.getWinnersName();
        outputView.printWinners(winners);
    }
}
