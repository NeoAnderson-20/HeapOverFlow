package handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SubMain {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        InvocationHandler subjectproxy = new SubjectProxy(subject);
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(subjectproxy.getClass().getClassLoader(),
                subjectproxy.getClass().getInterfaces(), subjectproxy);
        proxyInstance.hello("Invoke!!");


    }
}
