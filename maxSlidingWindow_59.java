import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class maxSlidingWindow_59 {
    public static void main(String[] args) {
        int[] test = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow_2(test, 3);
        for(int e : res){
            System.out.println(e + "  ");
        }
    }
    /**
     * 自己的解法，暴力破解
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int resLength = nums.length - (k - 1); //返回数组的长度
        int[] result = new int[resLength];
        for (int i = 0; i < resLength; i++){
            int max = nums[i];
            int window = i + k;
            for (int j = i; j < window; j++){
                if (max < nums[j])
                    max = nums[j];
            }
            result[i] = max;
        }
        return result;
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow_2(int[] nums, int k){
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++){
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++){
            if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

}
