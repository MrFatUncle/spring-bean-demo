package cn.lcm.springbeandemo.aop.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * FileName: TimingAspect
 * Author:   liaocm
 * Date:     2019/5/25 9:42
 * Description: 计算程序用时切面类
 * History:
 */
@Aspect
@Component
@Slf4j
public class TimingAspect {

    @Around("@annotation(cn.lcm.springbeandemo.aop.springaop.aspect.Timing)")
    public Object timing(ProceedingJoinPoint pjp ) throws Throwable {

        Long milliStart = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            Long milliEnd = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            log.info("Timing : {}", milliEnd - milliStart);
        }

        return result;
    }

}
