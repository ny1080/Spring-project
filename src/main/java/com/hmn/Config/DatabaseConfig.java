package com.hmn.Config;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

public abstract class DatabaseConfig {
    
    @Bean
    public abstract DataSource dataSource();
 
    protected void configureDataSource( DataSource dataSource, DataSourceProperties databaseProperties) {
        dataSource.setDriverClassName(databaseProperties.getDriverClassName());
        dataSource.setUrl(databaseProperties.getUrl());
        dataSource.setUsername(databaseProperties.getUsername());
        dataSource.setPassword(databaseProperties.getPassword());
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
    }
}

@Configuration
@Lazy
@MapperScan(basePackages = {"com.hmn.Dao"})
@EnableTransactionManagement
class hmnDataSourceConfig extends DatabaseConfig {

	@Autowired 
	private ApplicationContext applicationContext;
	
	@Bean(name="hmnDataSource", destroyMethod="close")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();  
		return dataSource;
	}	 
	 
	 // 트랜잭션
	 @Bean
	 public DataSourceTransactionManager transactionManager(@Qualifier("hmnDataSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
	 }

	@Bean
	@ConfigurationProperties(prefix = "mybatis")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("hmnDataSource") DataSource dataSource) throws Exception  {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();		
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.hmn.Domain");
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:static/mybatis/mybatis-config.xml"));
	    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:static/mybatis/mappers/mysql-*.xml"));
		return sqlSessionFactoryBean.getObject();
	}	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	} 
}
