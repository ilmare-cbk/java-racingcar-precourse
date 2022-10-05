package racingcar.domain;

import racingcar.contant.ExceptionMessage;

public class Car {
    public static final int CAR_NAME_MIN_LENGTH = 1;
    public static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_MIN_FUEL = 0;
    private static final int CAR_MAX_FUEL = 9;
    private final String name;
    private int distance;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private static void validateCarName(String name) {
        if (name.length() < CAR_NAME_MIN_LENGTH || name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME);
        }
    }

    public String getName() {
        return this.name;
    }

    public void move(int input) {
        if (input < CAR_MIN_FUEL || input > CAR_MAX_FUEL) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_FUEL);
        }
        if (input >= 4) {
            this.distance += 1;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
