package aop.tuling.EalyAopDemo;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import aop.tuling.Calculate;
import aop.tuling.TulingCalculate;

public class EalyAopMainConfig {

	// 被代理的对象
	@Bean
	public Calculate tulingCalculate() {
		return new TulingCalculate();
	}

	// Advice方式
	@Bean
	public TulingLogAdvice tulingLogAdvice() {
		return new TulingLogAdvice();
	}

	// Interceptor方式 ， 可以理解为环绕通知
	@Bean
	public TulingLogInterceptor tulingLogInterceptor() {
		return new TulingLogInterceptor();
	}

	/**
	 * FactoryBean方式单个： ProxyFactoryBean
	 * <p>
	 * 此中方法有个致命的问题，如果我们只能指定单一的Bean的AOP，
	 * 如果多个Bean需要创建多个ProxyFactoryBean 。
	 * 而且，我们看到，我们的拦截器的粒度只控制到了类级别，类中所有的方法都进行了拦截。
	 * 接下来，我们看看怎么样只拦截特定的方法。
	 *
	 * @return
	 */
//	@Bean
//	public ProxyFactoryBean calculateProxy1() {
//		ProxyFactoryBean userService = new ProxyFactoryBean();
//		userService.setInterceptorNames("tulingLogAdvice", "tulingLogInterceptor");
//		userService.setTarget(tulingCalculate());
//		return userService;
//	}


	/**
	 * Advisor 种类很多：
	 * RegexpMethodPointcutAdvisor 按正则匹配类
	 * NameMatchMethodPointcutAdvisor 按方法名匹配
	 * DefaultBeanFactoryPointcutAdvisor xml解析的Advisor   <aop:before
	 * InstantiationModelAwarePointcutAdvisorImpl  注解解析的advisor(@Before @After....)
	 *
	 * @return*
	 */
	@Bean
	public NameMatchMethodPointcutAdvisor tulingLogAspectAdvisor() {
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		advisor.setAdvice(tulingLogAdvice());
		advisor.setMappedName("div");
		return advisor;
	}

	@Bean
	public ProxyFactoryBean calculateProxy() {
		ProxyFactoryBean userService = new ProxyFactoryBean();
		userService.setTarget(tulingCalculate());
		userService.setInterceptorNames("tulingLogAspectInterceptor");
		return userService;
	}

	/* // RegexpMethodPointcutAdvisor 按正则匹配类*/
	@Bean
	public RegexpMethodPointcutAdvisor tulingLogAspectInterceptor() {
		RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
		advisor.setAdvice(tulingLogInterceptor());
		advisor.setPattern("tuling.TulingCalculate.*");
		return advisor;
	}
}
