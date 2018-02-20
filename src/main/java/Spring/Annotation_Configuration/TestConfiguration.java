package Spring.Annotation_Configuration;

/**
 * Created by liwanping on 2018-02-19
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "Spring.Annotation_Configuration")
public class TestConfiguration {
    public TestConfiguration() {
        System.out.println("TestConfiguration容器启动初始化。。。");
    }


    // @Bean注解注册bean,同时可以指定初始化和销毁方法
    // @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
    @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
    @Scope("prototype")
    public TestBean testBean() {
        return new TestBean();
    }

    @Configuration
    static class DatabaseConfig {
        @Bean
        DataSource dataSource() {
            return new DataSource();
        }
    }
}