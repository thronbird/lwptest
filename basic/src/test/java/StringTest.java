import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author liwanping
 * @date 2018-05-23
 */
public class StringTest {
    //不可变的String
    public static String appendStr(String s){
        s+="bbb";
        return s;
    }

    //可变的StringBuilder
    public static StringBuilder appendSb(StringBuilder sb){
        return sb.append("bbb");
    }

    public static void main(String[] args){
        String s = new String("aaa");
        String ns = StringTest.appendStr(s);
        System.out.println("String aaa>>>"+s.toString());

        //StringBuilder做参数
        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder nsb = StringTest.appendSb(sb);
        System.out.println("StringBuilder aaa >>>"+sb.toString());
    }

    @Test
    public void test2(){
        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}
        StringBuilder sb3 = sb1;
        sb3.append("bbb");//这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println(hs);
    }

    @Test
    public void test3(){
        System.out.println("xxxx"+"".replace("8","")
        );
    }
    @Test
    public void test4(){
        System.out.println((String)null);

        if(8==8){
            System.out.println(555);
        }else if(5==5){
            System.out.println(5565);
        }
    }

    @Test
    public void test5(){
    //    System.out.println(StringUtils null);
        if(8==8){
            System.out.println(555);
        }else if(5==5){
            System.out.println(5565);
        }
    }

    @Test
    public void test6(){
        System.out.println((String)null==null);
    }
}
