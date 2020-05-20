public class numWays_10{

    public static void main(String[] args) {
        int n = 44;
        System.out.println("解法有：" + numWays(n));
    }

    /**
     * 我的解法，用递归解决，但是计算速度太慢
     * @param n
     * @return
     */
    public static int numWays(int n){
        return count(n);
    }
    public static int count(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return (count(n - 1) + count(n - 2)) % 1000000007;
    }

    /**
     * LeetCode的优质解法
     */
    public static int numWays_1(int n){
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
