public class SelectionSort {
    private int[] arr;
    private int currentIndex = 0;
    private int minIndex = 0;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }
    public boolean step() {
        if (currentIndex >= arr.length - 1) {
            return false;
        }
        minIndex = currentIndex;
        for (int j = currentIndex + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        int temp = arr[currentIndex];
        arr[currentIndex] = arr[minIndex];
        arr[minIndex] = temp;

        currentIndex++;
        return true;
    }

    public int[] getArray() {
        return arr;
    }
}
