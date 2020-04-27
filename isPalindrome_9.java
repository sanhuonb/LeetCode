/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 */
public class isPalindrome_9 {
    /**
     * 自己的解法，将整数转为字符串判断
     * @param x
     * @return
     */
    public static boolean isPalindrome_1(int x){
        if (x < 0) return false;
        if (x < 10) return true; // 大于等于0且小于10是个位数，是回文串
        String value = String.valueOf(x);
        int index = value.length() - 1; // 数组下标比长度小 1,如果直接取长度 length 会造成越界
        for (int i = 0; i < index; i++){
            if (value.charAt(i) != value.charAt(index - i)){
                return false;
            }
        }
        return true;
    }

    /**
     * leetCode 官方的解法，反转一半数字，当反转的数大于未反转的数时，说明反转了一半
     * 然后将反转的与未反转的对比。输出还要考虑奇数的情况，将反转的数除以10可以去掉中间的奇数
     * @param x
     * @return
     */
    public static boolean isPalindrome_2(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)){ // x小于0，或者整数最后一位是0的情况
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
