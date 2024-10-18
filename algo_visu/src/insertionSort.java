public class insertionSort {
    private int[] arr;
    private int currentIndex;
    private int n;

    public insertionSort(int[] arr) {
        this.arr = arr;
        this.currentIndex = 1; 
        this.n = arr.length;   
    }


    public boolean step() {
        if (currentIndex >= n) {
            return false; 
        }
        int key = arr[currentIndex];
        int j = currentIndex - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;

        currentIndex++;
        return true; 
    }

    public int[] getArray() {
        return arr;
    }
}
