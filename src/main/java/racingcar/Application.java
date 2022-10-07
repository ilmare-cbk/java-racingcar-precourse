package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RacingCarInput(), new RacingCarView());
        racingCarController.play();
    }
}
