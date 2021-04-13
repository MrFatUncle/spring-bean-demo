/**
 * FileName: TestServiceImpl
 * Author:   liaocm
 * Date:     2021/4/13 22:40
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TestServiceImpl implements ITestService {
    @Override
    public void test() {
        System.out.println("执行逻辑");
    }
}
