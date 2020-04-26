/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class reverse_7 {
    /**
     * 将整型数转化为字符串，交换位置之后再转回整型
     * @param x
     * @return
     */
    public static int reverse(int x){
        String value = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(value);
        int length = value.length();
        System.out.println("length=" + length);
        for (int i = 0; i < length / 2; i++){
            char temp = value.charAt(i);
            stringBuilder.setCharAt(i, value.charAt(length - 1 - i));
            stringBuilder.setCharAt(length - 1 - i, temp);
        }
        value = stringBuilder.toString();
        return Integer.parseInt(value);
    }
    /**
     * 官方解法
     * 用数学的方法计算
     * @param x
     * @return
     */
    public static int reverse_2(int x){
        int ans = 0;
        while (x != 0){
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            ans = ans * 10 + pop;
            x = x / 10;
        }
        return ans;
    }
}
