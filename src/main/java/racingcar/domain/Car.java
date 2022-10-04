package racingcar.domain;

import racingcar.contant.ExceptionMessage;

public class Car {
    public static final int CAR_NAME_MIN_LENGTH = 1;
    public static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

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
}
