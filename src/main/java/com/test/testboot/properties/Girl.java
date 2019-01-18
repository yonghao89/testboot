package com.test.testboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
@Configuration
@ConfigurationProperties(prefix = "girl")
public class Girl {

    private  String cupSize;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
//https://www.jianshu.com/p/df57fefe0ab7

//请注意@EnableConfigurationProperties注解。 这个注解告诉Spring Boot 使能支持@ConfigurationProperties。如果不指定会看到如下异常:
//        org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [demo.mail.MailProperties] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
//
//        注意: 还有其他办法 (Spring Boot 总是有其他办法!) 让@ConfigurationProperties beans 被添加 – 用@C
//
//作者：crocodile_b
//        链接：https://www.jianshu.com/p/df57fefe0ab7
//        來源：简书
//        简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。