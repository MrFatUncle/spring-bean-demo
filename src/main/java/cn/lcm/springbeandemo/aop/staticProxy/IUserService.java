/**
 * FileName: IUserService
 * Author:   liaocm
 * Date:     2021/4/13 11:45
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.aop.staticProxy;

public interface IUserService {
    void save();
}

/**
 * 这是被代理的类
 */
class UserServiceImpl implements IUserService {
    @Override
    public void save() {
        System.out.println("执行逻辑");
    }
}

/**
 * 1.和被代理的类实现同一个接口
 * 2.将被代理的类作为成员变量依赖进来
 * 3.代理类执行代理逻辑，执行被代理的类的逻辑
 */
class UserServiceImplProxy implements IUserService {

    private IUserService userService;

    public UserServiceImplProxy(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void save() {
        System.out.println("执行前的代理逻辑");
        userService.save();
        System.out.println("执行后的代理逻辑");
    }
}