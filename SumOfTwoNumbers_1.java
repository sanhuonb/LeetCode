import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 第一个解法是暴力解法，第二个解法参考答案
 */

public class SumOfTwoNumbers_1 {

    /**
     * 暴力解法，时间复杂度为 o(n*n)
     * @param nums
     * @param target
     * @return
     */
    public static int[][] twoSum1(int[] nums, int target) {
        int[][] result = new int[10][2];
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[count][0] = i;
                    result[count++][1] = j;
                }
            }
        }
        for(int i = 0; i < count; i++){
            System.out.println(result[i][0] + "," + result[i][1]);
        }
        return result;
    }

    /**
     * 采用 map，时间复杂度为o(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] test = {2, 7, 11, 5};
        int[] r = twoSum2(test, 9);
        for (int i : r){
            System.out.println(i);
        }
    }
}
