public class getLeastNumbers_40 {

    public static void main(String[] args) {
        int[] test = {4, 5, 1, 6, 2, 7, 3, 8};
        for (int e : getLeastNumbers_1(test, 4)){
            System.out.print(e + " ");
        }
    }

    /**
     * 自己的解法，先用快排原地排序，再输出前 k 个数
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers_1(int[] arr, int k) {
        quickSortInternally(arr, 0, arr.length - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = arr[i];
        }
        return result;
    }

    private static void quickSortInternally(int[] a, int p, int r){
        if (p >= r) return;
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }
    private static int partition(int[] a, int p, int r){
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j){
            if (a[j] < pivot){
                if (i == j){
                    i++;
                } else {
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            }
        }
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        return i;
    }


}
