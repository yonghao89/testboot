package com.test.testboot.servlet;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ Author     ：LYH.
 * @ Date       ：Created in 2:54 2019/1/18
 * @ Description：${description}
 * @Version: $version$
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
