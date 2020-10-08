package spring_01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_01.Intro.App;
import spring_01.Intro.App02;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        assertTrue(true);
    }

    @Test      //Spring使用对象的方式
    public void test01() {
        //ApplicationContext是Spring对象容器,ClassPathXmlApplicationContext表示从类路径中获取xml
        //在创建容器时,就会自动创建配置文件中的所有对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        //获取对象
        App app = (App) ac.getBean("helloword");
        app.hello();
    }

    @Test
    public void test02() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        String[] names = ac.getBeanDefinitionNames();
        for(String i : names){
            System.out.println(i);
        }

    }

    @Test
    public  void  test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Date dt = (Date) ac.getBean("mydate");
        System.out.println(dt.toString());

    }

    @Test
    public  void  test04(){
        String config = "ApplicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        App02 app02 = (App02) ac.getBean("app02");
        System.out.println(app02.toString());
    }
}
