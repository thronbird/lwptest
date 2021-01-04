public class Test2 {
    private static class A{
        int x;
    }
    public static void main(String[] args) {
        A a = new A();
        test(a);
        System.out.println(a.x);
        {
            System.out.println("dsadsad");
            throw new RuntimeException("");
        }
    }

    private static void test(A a) {
        a.x = 10;
    }
}


