/**
 * FileName: UserService
 * Author:   liaocm
 * Date:     2020/7/21 22:20
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.ioc;

public class UserService {

    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
