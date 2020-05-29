/**
 * 974. 和可被 K 整除的子数组
 * 来源：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class subarraysDivByK_974 {

    public static void main(String[] args) {
        int[] test = {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK_2(test, 5));
    }

    /**
     * 暴力破解
     * @param A
     * @param K
     * @return
     */
    public static int subarraysDivByK_1(int[] A, int K){
        int res = 0, sum = 0;
        for (int i = 0; i < A.length; i++){
            sum = A[i];
            if (Math.abs(sum % K) == 0)
                res++;
            for (int j = i + 1; j < A.length; j++){
                sum = sum + A[j];
                if (Math.abs(sum % K) == 0)
                    res++;
            }
        }
        return res;
    }

    /**
     * 用哈希表，时间复杂度 O(N), 空间复杂度 O(K)
     * @param A
     * @param K
     * @return
     */
    public static int subarraysDivByK_2(int[] A, int K){
        int N = A.length, sum = 0, ans = 0;
        int[] map = new int[K];
        map[0] = 1;
        for (int i = 1; i <= N; i++){
            sum = sum + A[i - 1];
            int key = (sum % K + K) % K;
            ans = ans + map[key];
            map[key]++;
        }
        return ans;
    }

}
