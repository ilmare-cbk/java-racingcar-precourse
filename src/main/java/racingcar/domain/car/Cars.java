package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.contant.ExceptionMessage;

public class Cars {

    private final List<Car> values;

    private Cars(List<Car> values) {
        this.values = values;
    }

    public static Cars from(List<Car> values) {
        validateCarSize(values);
        return new Cars(values);
    }

    private static void validateCarSize(List<Car> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_SIZE);
        }
    }

    public List<Car> findWinners() {
        Car winner = findAnyWinner();

        List<Car> winners = new ArrayList<>();
        for (Car car : this.values) {
            addSameDistanceWinner(winner, car, winners);
        }

        return Collections.unmodifiableList(winners);
    }

    private Car findAnyWinner() {
        Car winner = this.values.get(0);
        for (Car car : this.values) {
            winner = winner.findWinner(car);
        }
        return winner;
    }

    private void addSameDistanceWinner(Car winner, Car car, List<Car> winners) {
        if (winner.isSameDistance(car)) {
            winners.add(car);
        }
    }
}
