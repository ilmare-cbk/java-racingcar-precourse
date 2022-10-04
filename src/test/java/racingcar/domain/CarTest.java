package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("자동차는 1 ~ 5자 이내의 이름을 갖는다.")
    void carNameTest(String input) {
        Car car = new Car(input);
        Assertions.assertThat(car.getName()).isEqualTo(input);
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
                .hasMessageStartingWith("[ERROR]");
    }
}
