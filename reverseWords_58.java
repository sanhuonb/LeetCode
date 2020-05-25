/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "
 * ，则输出"student. a am I"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseWords_58 {
    /**LeetCode上别人的解法，用双指针的解法，从字符串尾到首定位单词的位置
     * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
     * @param s
     * @return
     */
    public static String reverseWords_1(String s){
        s = s.trim(); // 去掉字符串首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0){
            while (i >=0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1)).append(" "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }

    /**
     * 用split()函数分割字符串
     */
    public static String reverseWords_2(String s){
        String[] strs = s.trim().split(" "); // 先去掉首尾空格，再分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--){
            if (strs[i].equals("")) continue;
            res.append(strs[i]).append(" ");
        }
        return res.toString().trim();
    }

}
