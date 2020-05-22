/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 */
public class maxSubArray_42 {
    public static int maxSubArray_1(int[] nums){
        int preMax = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++){
            preMax = Math.max(preMax + nums[i], nums[i]);
            max = Math.max(preMax, max);
        }
        return max;
    }
}
