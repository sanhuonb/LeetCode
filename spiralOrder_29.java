/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class spiralOrder_29 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        for ( int a: spiralOrder_2(matrix)) {
            System.out.print(a);
        }
    }

    /**
     * 自己写的解法
     * @param matrix
     * @return
     */
    public static int[] spiralOrder_1(int[][] matrix){

        int index = 0;
        int right = matrix[0].length;
        int left = 0;
        int up = matrix.length;
        int down = 0;
        int[] result = new int[right * up];
        int i = 0, j = 0;
        while (true) {
            for (; j < right && index < result.length; ) {
                result[index++] = matrix[i][j++];
            }
            j--;
            right--;
            down++;
            i = i + 1;
            for (; i < up && index < result.length; ){
                result[index++] = matrix[i++][j];
            }
            up--;
            i--;
            j = j - 1;
            for (; j >= left && index < result.length;){
                result[index++] = matrix[i][j--];
            }
            j++;
            left++;
            i = i - 1;
            for (; i >= down && index < result.length; ){
                result[index++] = matrix[i--][j];
            }
            i++;
            up--;
            j = j + 1;
            if (index >= result.length){
                return result;
            }
        }
    }

    /**
     * 网站里他人优秀解法
     * 围绕矩阵的边进行遍历，当遍历上方行时，top边界 + 1； 当遍历右边列时，右边界 - 1，以此类推其他边界
     * 并且使用边界进行判定是否遍历完整个矩阵
     * @param matrix
     * @return
     */
    public static int[] spiralOrder_2(int[][] matrix){
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true){
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }
}
