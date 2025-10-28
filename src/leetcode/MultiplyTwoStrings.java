package leetcode;

/**
 *
 * File is created by andreychernenko at 27.10.2025
 *
 *
 */


public class MultiplyTwoStrings {
    /*
    * Avoid separating multiplication into tasks:
    *   Computing sub-multiplications
    *   Adding sub-multiplication results
    *       like this: 123 * 12 = 246 + 123
    * Better option is to:
    *   Work with array and iteratively add sub-products
    *   Go through the list of ints with StringBuilder
    */
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length(), n2 = num2.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiply("123456789","987654321"));
        System.out.println(multiply("102938910283172812","18276481740128749012"));
        System.out.println(multiply("9", "99")); // 891
        System.out.println(multiply("99", "9")); // 891
        System.out.println(multiply("9", "9")); // 81
        System.out.println(multiply("123", "456")); // 56088
    }
}
