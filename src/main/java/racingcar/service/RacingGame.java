package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;

public class RacingGame {
    private static final int MOVE_THRESHOLD = 4;
    private final List<Car> cars;

    public RacingGame(List<Car> carList) {
        this.cars = carList;
    }


    public void playRound() {
        for (Car car : cars) {
            int pickNumber = Randoms.pickNumberInRange(0, 9);
            if (MOVE_THRESHOLD <= pickNumber) {
                car.move();
            }
        }
    }

    public Map<String, Integer> getRoundResult() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.getPosition());
        }
        return result;
    }

    public List<String> getWinnersName() {
        int highPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == highPosition)
                .map(Car::getName)
                .toList();
    }
}
