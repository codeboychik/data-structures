public class ReverseInteger {
    public static int reverse(int x) {
        int r = 0;
        boolean x_negative = x < 0;
        x = Math.abs(x);
        for(int i = 10; x > 0;) {
            if((x % i) * Math.pow(10, String.valueOf(x).length() - 1) > Integer.MAX_VALUE || (!x_negative && r < 0) || (x_negative && r > 0)) {
                return 0;
            }
            r += (int) ((x % i) * Math.pow(10, String.valueOf(x).length() - 1));
            x /= 10;
        }
        r = x_negative ? -r : r;
        return r;
    }
    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));
        // 8_798_798_798


    }
}
