package com.test.testboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestbootApplication {
//https://www.cnblogs.com/zedosu/p/6663911.html

	public static void main(String[] args) {

		SpringApplication.run(TestbootApplication.class, args);
	}
}
//mvn dependency:purge-local-repository

//在POM 4中，<dependency>中还引入了<scope>，它主要管理依赖的部署。目前<scope>可以使用5个值：
//		    * compile，缺省值，适用于所有阶段，会随着项目一起发布。 
//		    * provided，类似compile，期望JDK、容器或使用者会提供这个依赖。如servlet.jar。 
//		    * runtime，只在运行时使用，如JDBC驱动，适用运行和测试阶段。 
//		    * test，只在测试时使用，用于编译和运行测试代码。不会随项目发布。 
//		    * system，类似provided，需要显式提供包含依赖的jar，Maven不会在Repository中查找它。
//		---------------------
//		作者：w893932747
//		来源：CSDN
//		原文：https://blog.csdn.net/w893932747/article/details/81297319
//		版权声明：本文为博主原创文章，转载请附上博文链接！
