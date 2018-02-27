package Spring.Annotation_Configuration;

/**
 * Created by liwanping on 2018-02-19
 */
public class TestBean {

    private String username;
    private String url;
    private String password;

    public void sayHello() {
        System.out.println("TestBean sayHello...");
    }

    public String toString() {
        return "username:" + this.username + ",url:" + this.url + ",password:" + this.password;
    }

    public void start() {
        System.out.println("TestBean start ");
    }

    public void cleanUp() {
        System.out.println("TestBean destroy ");
    }
}