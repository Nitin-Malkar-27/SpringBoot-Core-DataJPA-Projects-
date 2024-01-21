package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManager;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repo.promotions", entityManagerFactoryRef = "mysqlEMf", transactionManagerRef = "mysqlTxMgmr")
public class MySQLDBConfig {

	@Bean
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource createMYSQLDs() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlEMF")
	public LocalContainerEntityManagerFactoryBean createMySQLEntityManagerFactoryBean(
			EntityManagerFactoryBuilder builder) {

		// create Map object having hibernate properties
		Map<String, Object> props = new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");

		// create and return LocalContainerEntityManagerFactoryBean
		// class object which makes EntityMangerFactory as the spring bean

		return builder.dataSource(createMYSQLDs()).packages("com.nt.model.promotions").properties(props).build();

	}

	@Bean(name = "mysqlTxMgmr")
	public PlatformTransactionManager createMysqlTxMgmr(@Qualifier("mysqlEMF") EntityManager factory) {
		return new JpaTransactionManager();
	}

}
