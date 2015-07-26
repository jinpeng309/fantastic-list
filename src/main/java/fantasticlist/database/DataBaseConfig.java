package fantasticlist.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages="fantasticlist.mapper")
public class DataBaseConfig {
	
	@Bean(destroyMethod="close")
	public DataSource dataSource(){
		HikariConfig hikariconfig = new HikariConfig("/fantasticlist/database/database.properties");
		hikariconfig.setAutoCommit(false);
		hikariconfig.setMaximumPoolSize(20);
		hikariconfig.setMinimumIdle(20);
		DataSource dataSource = new HikariDataSource(hikariconfig);
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory.getObject();
	}
}
