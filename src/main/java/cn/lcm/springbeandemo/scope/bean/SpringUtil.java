package cn.lcm.springbeandemo.scope.bean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
@Lazy(false)
@Slf4j
/**
 * 获取bean的工具类（通过注入applicationCotnext）
 * @author hyq
 *
 */
public class SpringUtil implements ApplicationContextAware, DisposableBean
{
    public static ApplicationContext applicationContext = null;

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName){
        isInjected();
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> requiredType){
        isInjected();
        return applicationContext.getBean(requiredType);
    }


    @Override
    public void destroy() throws Exception {    
        System.out.println("springUtils工具类清除注入的applicationContext");
        SpringUtil.applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("springUtils工具类注入的applicationContext");
        log.info("springUtils工具类注入的applicationContext: {}", applicationContext.toString());
        SpringUtil.applicationContext = applicationContext;
    }

    /**
     * 判断是否注入
     * @return
     */
    public static void isInjected(){
        if(SpringUtil.applicationContext == null){
            throw new RuntimeException("springUtils applicationContext is not injected!");
        }
    }

    public static void main(String[] args) {
        System.out.println(applicationContext);
    }


}
