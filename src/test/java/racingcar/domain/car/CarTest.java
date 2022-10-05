package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.contant.ExceptionMessage;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("자동차는 1 ~ 5자 이내의 이름을 갖는다.")
    void carNameTest(String input) {
        Car car = new Car(input);
        Assertions.assertThat(car.getName()).isEqualTo(Name.from(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("1 ~ 5자 이외의 이름으로 자동차 생성 시 예외 발생")
    void carNameExceptionTest(String input) {
        Assertions.assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("1 ~ 5자 이외의 이름으로 자동차 생성 시 [ERROR]로 시작하는 예외 발생 확인")
    void carNameExceptionStartingWithPrefixTest(String input) {
        Assertions.assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.INVALID_CAR_NAME);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "9:1", "3:0", "0:0"}, delimiter = ':')
    @DisplayName("4 이상이면 전진, 3 이하이면 멈춤")
    void carMoveTest(int input, int expected) {
        Car car = new Car("자동차1");
        car.move(input);
        Assertions.assertThat(car.getDistance()).isEqualTo(Distance.from(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("0 ~ 9 이외의 입력값에는 예외 발생")
    void carMoveExceptionTest(int input) {
        Car car = new Car("자동차1");
        Assertions.assertThatThrownBy(() -> car.move(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.INVALID_CAR_FUEL);
    }
}
