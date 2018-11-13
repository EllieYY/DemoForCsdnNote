package find;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/13
 */
public class find {
    public static double sqrt1(double value) {
        if (value <= 0)
            return 0;

        double eps = 1e-7;
        double left,right,mid;
        left = 0;
        right = value;
        while (Math.abs(left*left - value) > eps) {
            mid = (left + right) / 2;
            if (mid * mid < value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;

    }

    public static double sqrt2(double value) {
        if (value <= 0)
            return 0;

        double c = value;
        double old = 0.0;
        double eps = 1e-7;
        while (Math.abs(old - c) > eps) {
            old = c;
            c = (c + value/c) / 2;
        }
        return c;
    }

    public static void main(String[] args){
        System.out.println(sqrt2(36));
    }

}
