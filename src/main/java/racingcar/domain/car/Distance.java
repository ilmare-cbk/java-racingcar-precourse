package racingcar.domain.car;

import java.util.Objects;

public class Distance {
    private int value;

    private Distance(int value) {
        this.value = value;
    }

    public static Distance init() {
        return new Distance(0);
    }

    protected static Distance from(int value) {
        return new Distance(value);
    }

    protected void increase() {
        this.value += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean greaterThanOrEqual(Distance distance) {
        return this.value >= distance.value;
    }
}
