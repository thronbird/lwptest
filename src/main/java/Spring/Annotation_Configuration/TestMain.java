package Spring.Annotation_Configuration;

/**
 * Created by liwanping on 2018-02-19
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);

        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-context.xml");

        //获取bean
        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();

        DataSource ds = (DataSource) context.getBean("dataSource");
        System.out.println(ds);
    }
}
