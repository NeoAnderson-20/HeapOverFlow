package spring_01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_01.Anno_Intro.Anno_01;

public class AnnoTest {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext_annotations_01.xml");
        Anno_01 anno_01 = (Anno_01) ac.getBean("Anno_01");
        System.out.println(anno_01.toString());
    }
}
