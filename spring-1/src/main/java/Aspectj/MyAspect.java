package Aspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 该注解用于表示当前类是 切面类 ,  用来给业务方法增加功能,存放切面功能代码
 */

@Aspect
public class MyAspect {

    /**
     * 定义方法,要求: 公共, 无返回值, 参数非自定义
     * 在value内方法执行前,先进行myBefore方法作为前置
     */


    //语法
//    execution * com.atguigu.spring.ArithmeticCalculator.*(..): 匹配 ArithmeticCalculator 中声明的所有方法,第一个 * 代表任意修饰符及任意返回值. 第二个 * 代表任意方法. .. 匹配任意数量的参数. 若目标类与接口与该切面在同一个包中, 可以省略包名.
//    execution public * ArithmeticCalculator.*(..): 匹配 ArithmeticCalculator 接口的所有公有方法.
//    execution public double ArithmeticCalculator.*(..): 匹配 ArithmeticCalculator 中返回 double 类型数值的方法
//    execution public double ArithmeticCalculator.*(double, ..): 匹配第一个参数为 double 类型的方法, .. 匹配任意数量任意类型的参数
//    execution public double ArithmeticCalculator.*(double, double): 匹配参数类型为 double, double 类型的方法.
    @Before(value = "execution(public void Aspectj.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore() {
        //前置通知注解,属性值是切入点表达式.   他在目标方法之前执行,不会影响方法执行和结果

        System.out.println("前置通知_1");
    }

    @Before(value = "execution(* doSome(..))")    //通配符*
    public void myBefore2(JoinPoint jp){          //joinpoint  用于获取在方法执行时输入的参数等信息
        System.out.println("前置通知_2");
        System.out.println("方法签名:"+jp.getSignature());
        System.out.println("方法名称"+jp.getSignature().getName());
        Object[] args = jp.getArgs();   //获取参数列表
        for(Object i : args){
            System.out.println("参数:"+i);
        }
    }

    @AfterReturning(value = "execution(* doOthers(..))",returning = "res")          //后置通知,有返回值returning = "",可以根据返回值来进行进一步操作
    public void myAfter(JoinPoint jp,Object res) {                               //res默认为注解中方法的返回值!!!
        //前置通知注解,属性值是切入点表达式.   他在目标方法之前执行,不会影响方法执行和结果
        System.out.println(jp.getSignature().getName());
        System.out.println("后置通知");
        System.out.println(res);
    }

    /**
     * 环绕方法!方法前后都能加功能;   能控制目标方法是否执行; 能修改目标方法执行结果
     * 必须有一个返回值类型不限,有固定的参数ProceedingJoinPoint
     */
    @Around(value = "execution(* doAround(..))")
    public  Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        System.out.println("环绕通知_前:"+new Date());
      

        System.out.println("环绕通知_后:"+new Date());

        System.out.println();
        Object[] args = pjp.getArgs();
        if(args!=null && args.length >1){
            String s = (String) args[0];
            if(s.equals("Taylor")){                      //读取被注解方法的返回值, 以此来进行进一步操作
                System.out.println("Right");
                result = pjp.proceed();         //相当于 resul = doAround()
            }

        }
        if(result == null){
            result = "swift";
        }
        return result;
    }
}
