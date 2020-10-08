package handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler  implements InvocationHandler {
    Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理对象执行方法时会调用该方法
        method.invoke(target, args);

        return null;
    }
}
