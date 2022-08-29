package com.pandong.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.pandong.entity.User;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.imageio.IIOException;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.pandong")
@Repository
@MapperScan
public class MybatisConfig {

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IIOException{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		// 设置Mybatis配置文件的路径
		factoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
		// 设置SQL映射文件路径
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/*.xml"));
		factoryBean.setTypeAliases(User.class);
		return factoryBean;
	}

	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://192.168.5.141:3306/mybatis_example");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
}
