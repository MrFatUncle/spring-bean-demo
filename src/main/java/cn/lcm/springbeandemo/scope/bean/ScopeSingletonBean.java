/**
 * FileName: ScopeSingletonBean
 * Author:   liaocm
 * Date:     2020/4/9 16:19
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.scope.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ScopeSingletonBean {

    public ScopeSingletonBean() {
        log.info("类初始化：" + this.getClass().getName());
    }
}
