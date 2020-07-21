/**
 * FileName: IOCTest
 * Author:   liaocm
 * Date:     2020/7/21 21:57
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean/bean.xml");

        Object userService = context.getBean("userService");

        System.out.println(userService);

    }
}
