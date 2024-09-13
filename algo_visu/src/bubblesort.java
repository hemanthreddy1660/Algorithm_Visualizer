public class bubblesort {
    private int[] arr;
    private int n;
    private boolean swapped;
    private int currentStep;
    public bubblesort(int[] arr){
        this.arr = arr;
        this.n = arr.length;
        this.currentStep = 0;
    }


    public boolean step(){
        if(currentStep >= n - 1){
            return false;
        }
        swapped = false;
            // Last i elements are already in place
        for (int j = 0; j < n - currentStep - 1; j++) {
                // Swap if the element found is greater than the next element
            if (arr[j] > arr[j + 1]) {
                    // Swap elements
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        currentStep++;
        return swapped;
    }
    public int[] getArray(){
        return arr;
    }

}
