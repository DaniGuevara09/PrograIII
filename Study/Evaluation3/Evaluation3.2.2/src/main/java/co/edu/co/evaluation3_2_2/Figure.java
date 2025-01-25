package co.edu.co.evaluation3_2_2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Figure implements Runnable{
    private ImageView imageView;
    private Timeline movementTimeline;
    private Timeline directionTimeline;
    private double initialX;
    private double initialY;
    private int op;

    public Figure(ImageView imageView, int op) {
        this.imageView = imageView;
        this.op = op;
        this.initialX = imageView.getLayoutX();
        this.initialY = imageView.getLayoutY();
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            Random random = new Random();
            directionTimeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> {
                        int num = random.nextInt(4) + 1;
                        if (movementTimeline != null) {
                            movementTimeline.stop();
                        }
                        switch (num) {
                            case 1 -> movementTimeline = getTimelineY(-20);
                            case 2 -> movementTimeline = getTimelineY(20);
                            case 3 -> movementTimeline = getTimelineX(-20);
                            case 4 -> movementTimeline = getTimelineX(20);
                        }
                        movementTimeline.play();
                    })
            );
            directionTimeline.setCycleCount(Timeline.INDEFINITE);
            directionTimeline.play();
        });
    }

    private Timeline getTimelineX(int speed) {
        return new Timeline(
                new KeyFrame(Duration.millis(16), e -> {
                    double currentX = imageView.getLayoutX();
                    if (speed > 0 && currentX > 600) {
                        imageView.setLayoutX(-imageView.getFitWidth());
                    } else if (speed < 0 && currentX < 0) {
                        imageView.setLayoutX(600);
                    } else {
                        imageView.setLayoutX(currentX + speed);
                    }
                })
        );
    }

    private Timeline getTimelineY(int speed) {
        return new Timeline(
                new KeyFrame(Duration.millis(16), e -> {
                    double currentY = imageView.getLayoutY();
                    if (speed > 0 && currentY > 600) {
                        imageView.setLayoutY(-imageView.getFitHeight());
                    } else if (speed < 0 && currentY < 0) {
                        imageView.setLayoutY(600);
                    } else {
                        imageView.setLayoutY(currentY + speed);
                    }
                })
        );
    }


    public void pause() {
        Platform.runLater(() -> {
            if (movementTimeline != null) {
                movementTimeline.pause();
            }
            if (directionTimeline != null) {
                directionTimeline.pause();
            }
        });
    }

    public void resume() {
        Platform.runLater(() -> {
            if (movementTimeline != null) {
                movementTimeline.play();
            }
            if (directionTimeline != null) {
                directionTimeline.play();
            }
        });
    }

    public void stop() {
        Platform.runLater(() -> {
            if (movementTimeline != null) {
                movementTimeline.stop();
            }
            if (directionTimeline != null) {
                directionTimeline.stop();
            }
            imageView.setLayoutX(initialX);
            imageView.setLayoutY(initialY);
        });
    }
}
