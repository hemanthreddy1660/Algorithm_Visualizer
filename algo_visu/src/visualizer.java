import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;

public class visualizer extends Application {

    private SelectionSort selectionSort;
    private Canvas canvas;
    private Timeline timeline;  // Declare timeline as an instance variable

    @Override
    public void start(Stage primaryStage) {
        // Sample array to sort
        int[] initialarray = {5, 3, 4, 6, 2, 1,5,23,12,2,33,35,45,23,35,56,10};
        selectionSort = new SelectionSort(Arrays.copyOf(initialarray,initialarray.length));

        // Create buttons
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        Button rerunButton = new Button("rerun");

        // Create canvas for visualization
        canvas = new Canvas(800, 400);
        drawArray(selectionSort.getArray());
        timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (!selectionSort.step()) {
                timeline.stop();
            }
            drawArray(selectionSort.getArray());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        startButton.setOnAction(e -> timeline.play());
        stopButton.setOnAction(e -> timeline.stop());
        rerunButton.setOnAction(e ->{
            timeline.stop();
            selectionSort  = new SelectionSort(Arrays.copyOf(initialarray,initialarray.length));
            drawArray(selectionSort.getArray());
            timeline.playFromStart();

        });

        // Layout setup
        HBox topControls = new HBox(10);
        topControls.getChildren().addAll(startButton, stopButton, rerunButton);

        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(canvas);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Selection Sort Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawArray(int[] array) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Calculate the width of each bar
        double barWidth = canvas.getWidth() / array.length;

        // Find the maximum value in the array for scaling the bar height
        int maxValue = Arrays.stream(array).max().orElse(1);

        for (int i = 0; i < array.length; i++) {
            // Scale the height of the bars based on the maximum value and canvas height
            double barHeight = (array[i] / (double) maxValue) * canvas.getHeight();

            // Draw each bar
            gc.fillRect(i * barWidth, canvas.getHeight() - barHeight, barWidth - 2, barHeight);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
