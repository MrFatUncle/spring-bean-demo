/**
 * FileName: ScopeController
 * Author:   liaocm
 * Date:     2020/4/9 16:04
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.scope;

import cn.lcm.springbeandemo.scope.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * 用于测试作用域
 */
@RestController
@RequestMapping("/scope")
@Slf4j
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeController {

    /*@Autowired
    private ScopeApplicationBean scopeApplicationBean;
    @Autowired
    private ScopePrototypeBean scopePrototypeBean;
    @Autowired
    private ScopeRequestBean scopeRequestBean;
    @Autowired
    private ScopeSingletonBean scopeSingletonBean;
    @Autowired
    private ScopeSessionBean scopeSessionBean;*/

    public ScopeController() {
        log.info("类初始化：" + this.getClass().getName());
    }

    @RequestMapping("getResp")
    public String getResp(HttpServletRequest request) {
        ScopeSessionBean scopeSessionBean = SpringUtil.getBean(ScopeSessionBean.class);
        ScopeSingletonBean scopeSingletonBean = SpringUtil.getBean(ScopeSingletonBean.class);
        ScopeRequestBean scopeRequestBean = SpringUtil.getBean(ScopeRequestBean.class);
        ScopePrototypeBean scopePrototypeBean = SpringUtil.getBean(ScopePrototypeBean.class);
        ScopeApplicationBean scopeApplicationBean = SpringUtil.getBean(ScopeApplicationBean.class);

        return "响应了：" + getClass().getName();
    }

}
