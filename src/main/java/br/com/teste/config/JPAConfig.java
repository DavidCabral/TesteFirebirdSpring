package br.com.teste.config;

import java.net.URL;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import br.com.teste.repositorio.AlmoxarifadoDAO;

@Configuration
@ComponentScan(basePackageClasses = AlmoxarifadoDAO.class)
@EnableJpaRepositories(basePackageClasses = AlmoxarifadoDAO.class, enableDefaultTransactions = false)
@EnableTransactionManagement
public class JPAConfig {

	
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("org.firebirdsql.jdbc.FBDriver");
	    //hikariConfig.setJdbcUrl("jdbc:firebirdsql:localhost/3050:C:/banco/ALMOXARIFADO.GDB?encoding=ISO8859_1"); 
	    
	    hikariConfig.setJdbcUrl(getUrlBanco());
	    hikariConfig.setUsername("SYSDBA");
	    hikariConfig.setPassword("masterkey");
	    hikariConfig.setMaximumPoolSize(5);


	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
	}
	
	private String getUrlBanco(){
        URL url  = JPAConfig.class.getClassLoader().getResource("/db/ALMOXARIFADO.GDB");        
        String banco = url.getPath();
        banco = banco.substring(1, banco.length());
	    return "jdbc:firebirdsql:localhost/3050:"+ banco+"?encoding=ISO8859_1";
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.FirebirdDialect");
		return adapter;
	}
	
	 @Bean
	  public EntityManagerFactory entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(jpaVendorAdapter());
	    factory.setPackagesToScan("br.com.teste");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();
	    return factory.getObject();
	  }
	
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
}
