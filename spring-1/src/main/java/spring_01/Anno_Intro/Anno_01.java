package spring_01.Anno_Intro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Component用于创建对象,等同于bean标签
 * value参数表示对象的id,相当于bean的id,唯一
 * 该类只创建一次
 */

@Component("Anno_01")
/**
 *1.@Repository : 用来注解dao类(数据库连接)
 *2.@Service : 事务处理
 *3.@Controller : 注解控制器对象(Servlet)
 * 使用语法同Component
 */

public class Anno_01 {
    @Value("zyh")        //@Value注解放在声明数据上方,无需set方法
    String name;
    @Value("20")
    String age;
    @Autowired  //该注解用于对引用类型赋值,自动注入,默认使用byType注入.  无需set方法,在属性声明上方
//    @Autowired(required = false)   如果选false,则如果引用类型赋值失败,则赋值为null,程序不报错继续执行
    @Qualifier(value = "anno_02")   //使用byName注入
    //@Resource  先用byName 再用byType 来注入,指定使用哪一个类
    Anno_02 anno02;


    public Anno_01() {
        System.out.println("Created!");
    }

    @Override
    public String toString() {
        return "Anno_01{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", anno02=" + anno02 +
                '}';
    }
}
