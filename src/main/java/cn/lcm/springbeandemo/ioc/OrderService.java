/**
 * FileName: OrderService
 * Author:   liaocm
 * Date:     2020/7/21 22:24
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.ioc;

public class OrderService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
