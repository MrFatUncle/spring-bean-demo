/**
 * FileName: ScopeRequestBean
 * Author:   liaocm
 * Date:     2020/4/9 16:20
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.scope.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Slf4j
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeRequestBean {

    public ScopeRequestBean() {
        log.info("类初始化：" + this.getClass().getName());
    }
}
