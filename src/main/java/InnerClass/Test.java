package InnerClass;

/**
 * @author liwanping
 * @date 2018-07-31
 */
public class Test {
    public static void main (String[] args ){
        OutClass outClass1=new OutClass();
        OutClass outClass2=new OutClass();
        System.out.println(outClass1);
        System.out.println(outClass2);
        OutClass.InnerClass.testVariable=2;
        System.out.println( new  OutClass.InnerClass().testVariable);
        OutClass.InnerClass.testVariable=3;
        System.out.println( new  OutClass.InnerClass().testVariable);
    }
}
