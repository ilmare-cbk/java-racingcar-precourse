package racingcar.contant;

public class ExceptionMessage {
    private static final String MESSAGE_PREFIX = "[ERROR]";
    public static final String INVALID_CAR_NAME = String.format("%s 자동차 이름은 1 ~ 5자 이내여야 합니다.", MESSAGE_PREFIX);
    public static final String INVALID_CAR_FUEL = String.format("%s 자동차가 이동을 위한 입력값은 0 ~ 9 사이여야 합니다.", MESSAGE_PREFIX);
    public static final String INVALID_CAR_SIZE = String.format("%s 자동차는 최소 1대가 있어야 합니다.", MESSAGE_PREFIX);
}