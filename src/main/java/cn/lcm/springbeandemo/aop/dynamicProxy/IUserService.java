/**
 * FileName: IUserService
 * Author:   liaocm
 * Date:     2021/4/13 11:45
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.aop.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface IUserService {
    void save();
}

/**
 * 这是被代理的类，实现JDK提供的接口 InvocationHandler
 */
class UserServiceImpl implements IUserService,InvocationHandler {
    @Override
    public void save() {
        System.out.println("执行逻辑");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前的代理逻辑");
        Object retVal = method.invoke(this, args);
        System.out.println("执行后的代理逻辑");

        return retVal;
    }
}

class Test {
    public static void main(String[] args) {
        //通过反射的方式构建代理对象
        IUserService proxyInstance = (IUserService)Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new UserServiceImpl());
        System.out.println(proxyInstance);
        proxyInstance.save();
    }
}