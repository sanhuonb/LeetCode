public class longestCommonPrefix_14 {
    public static void main(String[] args) {
        String[] test = {"aa","a"};
        System.out.println(longestCommonPrefix_1(test));
    }

    /**
     * 自己写的暴力解法。。。垃圾
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_1(String[] strs){
        StringBuilder result = new StringBuilder();
        if (strs.length == 0){
            result.append("");
            return result.toString();
        }
        boolean flag = true; // 判断字符串数组中某个索引处字符是否全部相等
        int i; //此处长度 i 是字符串数组第一个字符串的长度
        int j; // 此处长度是字符串数组中字符串的个数
        for (i = 0; i < strs[0].length(); i++){
            for (j = 1; j < strs.length; j++){
                if (strs[j - 1].length() - 1 < i || strs[j].length() - 1 < i){
                    return result.toString();
                }
                if (strs[j - 1].charAt(i) != strs[j].charAt(i)){
                    if (result.length() == 0){
                        result.append("");
                        return result.toString();
                    } else {
                        return result.toString();
                    }
                }
            }
            result.append(strs[j - 1].charAt(i));
        }
        result.append("");
        return result.toString();
    }
}
