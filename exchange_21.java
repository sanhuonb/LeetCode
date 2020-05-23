/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

public class exchange_21 {

    public static int[] exchange(int[] nums){
        int[] result = new int[nums.length];
        int odd_index = 0, even_index = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0) { // 如果是偶数
                result[even_index--] = nums[i];
            } else {
                result[odd_index++] = nums[i];
            }
        }
    return result;
    }

    /**
     * 双指针方法
     * @param nums
     * @return
     */
    public static int[] exchange_2(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            if (nums[left] % 2 != 0){ //如果是奇数,继续往右寻找，直到是偶数
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) { // 如果不是奇数，继续往左移动
                right--;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
