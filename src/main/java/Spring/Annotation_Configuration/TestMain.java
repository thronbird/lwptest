package Spring.Annotation_Configuration;

/**
 * Created by liwanping on 2018-02-19
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {

        // @Configurationע���spring�������ط�ʽ����AnnotationConfigApplicationContext�滻ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);

        // �������spring-context.xml�ļ���
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-context.xml");

        //��ȡbean
        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();

        DataSource ds = (DataSource) context.getBean("dataSource");
        System.out.println(ds);
    }
}
