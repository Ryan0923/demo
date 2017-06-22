/**
 * Created by mojunbin on 2017/6/22.
 */
public class PrintDigit {
    public static void main(String[] args) {
        printOut(15844);
        System.out.println("=======================");
        printReverseOut(15844);
    }

    /**
     * 15844
     * 1584
     * 158
     * 15
     * 1
     * @param n
     */
    public static void printOut(int n) {
        if (n >= 10) {
            printOut(n / 10);
        }
        System.out.println(n % 10);
    }

    /**
     * 15844
     * 1584
     * 158
     * 15
     * 1
     *
     * @param n
     */
    public static void printReverseOut(int n) {
        System.out.println(n % 10);
        if (n / 10 > 0) {
            printReverseOut(n / 10);
        }
    }
}
