/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class missingNumber_53 {
    /**
     * 我的解法，依次遍历数组，当数组中的值与索引不相等时，索引的值即是缺省的值
     * @param nums
     * @return
     */
    public static int missingNumber_1(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;
    }

    /**
     * LeetCode上他人的解法，用二分法查找，时间复杂度 O(Logn)
     * @param nums
     * @return
     */
    public static int missingNumber_2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int m = (i + j) / 2;
            if (nums[m] == m)
                i = m + 1;
            else
                j = m - 1;
        }
        return i;
    }

}
