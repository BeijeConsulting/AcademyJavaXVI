package it.beije.mockito;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataSourceConfig {
	
//	@Autowired
//    private Environment env;
	
	private final String JDBC_CONNECTION_STRING = "jdbc:mysql://localhost:3306/demo"; //env.getProperty("JDBC_CONNECTION_STRING")
	private final String JDBC_USERNAME = "root"; //env.getProperty("JDBC_USERNAME")
	private final String JDBC_PASSWORD = "Mary23BeijeSQL"; //env.getProperty("JDBC_PASSWORD")
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(JDBC_CONNECTION_STRING);
        dataSource.setUsername(JDBC_USERNAME);
        dataSource.setPassword(JDBC_PASSWORD);
        
        return dataSource;
    }
    
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("it.beije.mockito.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

}
