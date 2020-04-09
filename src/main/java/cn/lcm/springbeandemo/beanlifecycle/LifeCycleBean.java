/**
 * FileName: LifeCycleBean
 * Author:   liaocm
 * Date:     2020/4/9 20:22
 * Description:
 * History:
 */
package cn.lcm.springbeandemo.beanlifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
@Slf4j
public class LifeCycleBean implements BeanFactoryPostProcessor,
        InstantiationAwareBeanPostProcessor,
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {

    public LifeCycleBean() {
        log.info("对象实例化" + getClass().getName());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("1.启动容器后，BeanFactoryPostProcessor调用postProcessBeanFactory方法");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("2.任何Bean实例化前，InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("3.任何Bean实例化后，InstantiationAwareBeanPostProcessor调用postProcessAfterInstantiation方法");
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        log.info("4.当前Bean启动容器后，实例化后，InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        return null;
    }

    @Override
    public void setBeanName(String name) {
        log.info("5.当前Bean实例化后，BeanNameWare调用setBeanName方法:" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("6.当前Bean实例化后，BeanFactoryWare调用setBeanFactory方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("7.当前Bean实例化后，ApplicationContextAware调用setApplicationContext方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("8.任何Bean实例化后，BeanPostProcessor调用postProcessBeforeInitialization方法");
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("9.当前Bean实例化后，InitializingBean调用afterPropertiesSet方法");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("10.任何Bean实例化后，BeanPostProcessor调用postProcessAfterInitialization方法");
        return null;
    }

    @Override
    public void destroy() throws Exception {
        log.info("11.容器销毁前，当前bean，DisposableBean调用destroy方法");
    }
}
