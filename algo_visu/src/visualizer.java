import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Arrays;


public class visualizer extends Application {
    private SelectionSort selectionSort;
    private bubblesort bubblesort;
    private insertionSort insertionsort;
    private Canvas canvas;
    private Timeline timeline;
    private final int[] initialarray = {
        35, 89, 47, 65, 28, 92, 54, 12, 76, 40, 
        83, 21, 9, 56, 78, 65, 43, 92, 30, 19, 
        71, 84, 67, 58, 72, 43, 90, 24, 53, 81, 
        64, 20, 37, 59, 85, 16, 48, 62, 11, 93, 
        33, 77, 29, 51, 70, 88, 41, 96, 80, 34, 
        27, 95, 82, 68, 49, 73, 57, 94, 18, 66, 
        31, 87, 15, 60, 22, 32, 50, 86, 26, 74, 
        61, 52, 39, 46, 45, 25, 23, 91, 17, 97, 
        13, 6, 98, 7, 99, 5, 4, 3, 2, 1
    };
    
    @Override
    public void start(Stage primaryStage) {
        
        loadHome(primaryStage);
        
    }

    private void loadHome(Stage primaryStage){
        Button SelectionSortbut = new Button("Selection Sort");
        Button BubbleSortbut = new Button("Bubble Sort");
        Button InsertionSortBut = new Button("Insertion Sort");

        SelectionSortbut.setOnAction(e -> loadSelectionSort(primaryStage));
        BubbleSortbut.setOnAction(e -> loadBubbleSort(primaryStage));
        InsertionSortBut.setOnAction(e -> loadInsertionSort(primaryStage));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(SelectionSortbut,BubbleSortbut,InsertionSortBut);
        Scene initialscene = new Scene(layout,400,300);
        primaryStage.setTitle("Algorithm Visualiser Home");
        primaryStage.setScene(initialscene);
        primaryStage.show();
    }



    //

    private void loadSelectionSort(Stage primaryStage){
        selectionSort = new SelectionSort(Arrays.copyOf(initialarray,initialarray.length));
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        Button rerunButton = new Button("Re-Run");
        Button backButton = new Button("Go Home");

        canvas = new Canvas(800, 400);
        drawArray(selectionSort.getArray());
        timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (!selectionSort.step()) {
                timeline.stop();
            }
            drawArray(selectionSort.getArray());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        backButton.setOnAction(e -> loadHome(primaryStage));
        startButton.setOnAction(e -> timeline.play());
        stopButton.setOnAction(e -> timeline.stop());
        rerunButton.setOnAction(e ->{
            timeline.stop();
            selectionSort = new SelectionSort(Arrays.copyOf(initialarray, initialarray.length));
            drawArray(selectionSort.getArray());
            timeline.playFromStart();
        });
        // Layout setup
        HBox topControls = new HBox(10);
        topControls.getChildren().addAll(startButton, stopButton, rerunButton, backButton);

        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(canvas);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Sorting Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void loadInsertionSort(Stage primaryStage){
        insertionsort = new insertionSort(Arrays.copyOf(initialarray,initialarray.length));
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        Button rerunButton = new Button("Re-Run");
        Button backButton = new Button("Go Home");

        canvas = new Canvas(800, 400);
        drawArray(insertionsort.getArray());
        timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (!insertionsort.step()) {
                timeline.stop();
            }
            drawArray(insertionsort.getArray());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        backButton.setOnAction(e -> loadHome(primaryStage));
        startButton.setOnAction(e -> timeline.play());
        stopButton.setOnAction(e -> timeline.stop());
        rerunButton.setOnAction(e ->{
            timeline.stop();
            insertionsort = new insertionSort(Arrays.copyOf(initialarray, initialarray.length));
            drawArray(insertionsort.getArray());
            timeline.playFromStart();
        });
        // Layout setup
        HBox topControls = new HBox(10);
        topControls.getChildren().addAll(startButton, stopButton, rerunButton, backButton);

        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(canvas);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Sorting Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void loadBubbleSort(Stage primaryStage){
        bubblesort = new bubblesort(Arrays.copyOf(initialarray,initialarray.length));
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        Button rerunButton = new Button("rerun");
        Button backButton = new Button("Go Home");

        canvas = new Canvas(800, 400);
        drawArray(bubblesort.getArray());
        timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (!bubblesort.step()) {
                timeline.stop();
            }
            drawArray(bubblesort.getArray());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        backButton.setOnAction(e -> loadHome(primaryStage));
        startButton.setOnAction(e -> timeline.play());
        stopButton.setOnAction(e -> timeline.stop());
        rerunButton.setOnAction(e ->{
            timeline.stop();
            bubblesort = new bubblesort(Arrays.copyOf(initialarray, initialarray.length));
            drawArray(bubblesort.getArray());
            timeline.playFromStart();
        });
        // Layout setup
        HBox topControls = new HBox(10);
        topControls.getChildren().addAll(startButton, stopButton, rerunButton,backButton);

        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(canvas);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Sorting Visualizer");
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
