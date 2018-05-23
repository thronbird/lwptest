/**
 * @author liwanping
 * @date 2018-05-10
 */
public class BeanPropTest {

    static void setPersonName(Person x){
        x.name="xxx";
    }

    public static void main (String[] args ){
        Person a = new Person();
        setPersonName(a);
        System.out.println(a.name);
    }

    static class Person{
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
