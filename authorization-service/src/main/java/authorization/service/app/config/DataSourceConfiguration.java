package authorization.service.app.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "authJdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public UserDetailsService users(@Qualifier("mainDataSource") DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean(name = "mainDataSource")
    public DataSource dataSource() {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("");
        dataSource.setPassword("");
        dataSource.setUsername("");
        dataSource.setUrl("");
        return dataSource;
    }
}
