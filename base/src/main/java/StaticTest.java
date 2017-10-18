public class StaticTest {

    public static int k = 0;
    public static StaticTest t1 = new StaticTest("t1");
    public static StaticTest t2 = new StaticTest("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    //构造代码块
    {
        System.out.println("构造块");
    }

    //静态代码块
    static {
        System.out.println("静态块");

    }

    public StaticTest(String str) {//构造函数
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++i;
        return ++n;
    }

    public static void main(String[] args) {
        StaticTest t = new StaticTest("init");
    }
}
