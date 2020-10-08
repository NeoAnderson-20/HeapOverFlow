package Aspectj;
 
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class asTest {

    @Test
    public  void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SomeService proxy = (SomeService) applicationContext.getBean("someservice");
//        proxy.doSome("Taylor",20);
//        System.out.println();
//        System.out.println();
//        proxy.doOthers();
        System.out.println(proxy.doAround("Taylor"));

        //输出时首先执行了前置通知功能(增强功能)

    }
}
