package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final RacingCarInput racingCarInput;
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarInput racingCarInput, RacingCarView racingCarView) {
        this.racingCarInput = racingCarInput;
        this.racingCarView = racingCarView;
    }

    public void play() {
        Cars cars = racingCarInput.getCars();
        int tryCount = racingCarInput.getTryCount();

        play(cars, tryCount);
        racingCarView.printWinners(cars);
    }

    private void play(Cars cars, int tryCount) {
        racingCarView.printStepResultGuide();

        for (int step = 1; step <= tryCount; step++) {
            cars.move();
            racingCarView.printStepResult(cars);
        }
    }
}
