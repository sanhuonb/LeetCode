/**
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */

public class romanToInt_13 {
    public static void main(String[] args) {
        System.out.println("结果为: " + romanToInt_1("MCMXCIV"));
    }

    /**
     * 自己的解法，switch case 判断，可读性差
     * @param s
     * @return
     */
    public static int romanToInt_1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i + 1 == s.length()){
                        result += 1;
                        return result;
                    } else if (s.charAt(i + 1) == 'V') {
                        result += 4;
                        i++;
                        break;
                    } else if (s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                        break;
                    } else {
                        result += 1;
                    }
                    break;

                case 'V':
                    result += 5;
                    break;

                case 'X' :
                    if (i + 1 == s.length()){
                        result += 10;
                        return result;
                    } else if (s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                        break;
                    } else if (s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                        break;
                    } else {
                        result += 10;
                    }
                    break;

                case 'L' :
                    result += 50;
                    break;

                case 'C' :
                    if (i + 1 == s.length()){
                        result += 100;
                        return result;
                    } else if (s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                        break;
                    } else if (s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                        break;
                    } else {
                        result += 100;
                    }
                    break;

                case 'D' :
                    result += 500;
                    break;

                case 'M' :
                    result += 1000;
                    break;

                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
        return result;
    }

    /**
     * LeeCode上的优秀解法，作者是DoneSpeak
     * @param s
     * @return
     */
    public static int romanToInt_2(String s){
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            int num = getValue(s.charAt(i));
            if (preNum < num){
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private static int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
