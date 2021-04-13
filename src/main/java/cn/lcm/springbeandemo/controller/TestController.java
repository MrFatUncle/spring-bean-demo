/**
 * FileName: TestController
 * Author:   liaocm
 * Date:     2021/4/13 22:01
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    /**
     * SpringAOP
     * @return
     */
    @GetMapping("springAop")
    public String springAop() {
        testService.test();
        return "success";
    }
}
