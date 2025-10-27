package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public void createCars(List<String> carNames) {
        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
