package aop.tuling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aop.tuling")
public class MainConfig {

	@Bean
	public Calculate calculate()
	{
		return new TulingCalculate();
	}

	@Bean
	public TulingLogAspect tulingLogAspect()
	{
		return new TulingLogAspect();
	}

	@Bean
	public Calculate calculate2() {
		return new TulingCalculate();
	}
}
