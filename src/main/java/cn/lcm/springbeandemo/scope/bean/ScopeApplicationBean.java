/**
 * FileName: ScopeApplicationBean
 * Author:   liaocm
 * Date:     2020/4/9 16:21
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.scope.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Slf4j
@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class ScopeApplicationBean {

    public ScopeApplicationBean() {
        log.info("类初始化：" + this.getClass().getName());
    }
}
