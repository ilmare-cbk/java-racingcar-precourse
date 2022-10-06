package racingcar.domain.car;

import racingcar.contant.ExceptionMessage;

public class Car {
    private static final int CAR_MIN_FUEL = 0;
    private static final int CAR_MAX_FUEL = 9;
    public static final int MOVABLE_FUEL = 4;
    private final Name name;
    private Distance distance;

    private Car(String name) {
        this.name = Name.from(name);
        this.distance = Distance.init();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public Name getName() {
        return this.name;
    }

    public void move(int fuel) {
        validateCarFuel(fuel);
        if (fuel >= MOVABLE_FUEL) {
            this.distance.increase();
        }
    }

    private void validateCarFuel(int input) {
        if (input < CAR_MIN_FUEL || input > CAR_MAX_FUEL) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_FUEL);
        }
    }

    public Distance getDistance() {
        return this.distance;
    }

    public Car findWinner(Car car) {
        if (this.distance.greaterThanOrEqual(car.getDistance())) {
            return this;
        }
        return car;
    }

    public boolean isSameDistance(Car car) {
        return this.distance.equals(car.distance);
    }
}
