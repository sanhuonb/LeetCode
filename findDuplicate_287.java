/**
 *给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 *可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 */
public class findDuplicate_287 {
    /**
     * LeetCode优秀解法，用二分法
     * 链接 https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums){
        int len = nums.length;
        int right = len - 1;
        int left = 1;
        while (left < right){
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums){
                if (num <= mid)
                    cnt++;
            }
            if (cnt > mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
