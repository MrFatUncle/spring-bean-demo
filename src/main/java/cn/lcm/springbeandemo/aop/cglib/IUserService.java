/**
 * FileName: IUserService
 * Author:   liaocm
 * Date:     2021/4/13 11:45
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public interface IUserService {
    void save();
}

/**
 * 普通的实现类
 */
class UserServiceImpl implements IUserService {
    @Override
    public void save() {
        System.out.println("执行逻辑");
    }
}

/**
 * 回调的类
 */
class Callback implements MethodInterceptor {
    public Callback() {}

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前的代理逻辑");
        Object retVal = methodProxy.invokeSuper(obj, args);
        System.out.println("执行后的代理逻辑");
        return retVal;
    }
}

class Test  {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new Callback());
        IUserService userService = (IUserService) enhancer.create();

        userService.save();
    }
}
