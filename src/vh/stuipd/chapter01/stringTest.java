package vh.stuipd.chapter01;

/**
 * Created by ane on 3/10/15.
 */
public class stringTest {


    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void main(String []args) {
        test1();
        println("=============");
        test2();
//        println("=============");
//        test3();
//        println("=============");
//        testForJDK17();
    }

    private static void test1() {
        String a = "a" + "b" + 1;
        String b = "ab1";
        println(a == b);
    }

    private final static String getA() {return "a";}
    public static void test2() {
        String a = "a";
        final String c = "a";

        String b = a + "b";
        String d = c + "b";
        String e = getA() + "b";

        String compare = "ab";
        println(b == compare);
        println(d == compare);
        println(e == compare);
    }

    public static void test3() {
        String a = "a";
        String b = a + "b";
        String c = "ab";
        String d = new String(b);
        println(b == c);
        println(c == d);
        println(c == d.intern());
        println(b.intern() == d.intern());
    }

    /**
     * ¸Ã´úÂë½ö½öÓÃÓÚ²âÊÔJDK1.7
     * ÕâÀïµ¥¶ÀÓÃe¡¢fÀ´×öµÄÔ­ÒòÊÇ²»ÏëºÍÇ°ÃæµÄ³ÌÐòÒÑ¾­Éú³ÉµÄ³£Á¿³ØÏà»¥Ó°Ïì
     */
    public static void testForJDK17() {
        String a = "e";
        String b = "f";
        String c = a + b;
        String d = a + b;
        System.out.println(c == c.intern());
        System.out.println(d == d.intern());
        System.out.println(c == d.intern());
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(c.intern()));
        System.out.println(System.identityHashCode(d.intern()));
        System.out.println(System.identityHashCode("ef"));
    }
}
