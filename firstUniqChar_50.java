import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class firstUniqChar_50 {

    public static void main(String[] args) {
        String test = "aaccdebff";
        System.out.println(firstUniqChar_2(test));
    }

    /**
     * 自己写的，用map暴力破解
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        HashMap map = new HashMap();
        boolean flag = true;
        if (s.length() == 0) return ' ';
        for (int i = 0; i < s.length(); i++){
            flag = true;
            if (map.containsKey(s.charAt(i)))
                continue;
            for (int j = s.length() - 1; j > i; j--){
                if (s.charAt(j) == s.charAt(i)){
                    map.put(s.charAt(i), null);
                    flag = false; // 有相同的
                    break;
                }
            }
            if (flag) return s.charAt(i);
        }
        return ' ';
    }

    /**
     * 别人的优秀解法
     * @param s
     * @return
     */
    public static char firstUniqChar_2(String s){
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc){
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : sc){
            if (dic.get(c)) return c;
        }
        return ' ';
    }
}

