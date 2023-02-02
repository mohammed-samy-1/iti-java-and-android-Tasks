public class MinAndMaxIndex {
    public static void main(String[] args) {
        int[] arr = {2, 44, 1, 4, 2, 3, 5, 33, 56, 35, 32};
        int[] maxAndMin = maxAndMinIndex(arr);
        System.out.println("the index of the max value is : " + maxAndMin[0]);
        System.out.println("the index of the min value is : " + maxAndMin[1]);
    }

    /**
     *
     * @param arr pass the array to get the index of min value and max value
     * @return returns an array contains the min index in the array[0]
     *         and the max index in array[1]
     */
    public static int[] maxAndMinIndex(int[] arr) {

        int maxIndex = 0, minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        return new int[]{maxIndex, minIndex};
    }
}
