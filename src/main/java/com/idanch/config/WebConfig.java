package com.idanch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.idanch")
@PropertySource("classpath:jdbc.properties")
public class WebConfig implements WebMvcConfigurer {
    public static final Logger log = LoggerFactory.getLogger(WebConfig.class);

    // Jdbc Properties
    private final String jdbcDriverClassName;
    private final String jdbcConnectionUrl;
    private final String jdbcDbUsername;
    private final String jdbcDbPassword;


    public WebConfig(@Value("${jdbc.driver_class_name}") String jdbcDriverClassName,
                     @Value("${jdbc.connection_url}") String jdbcConnectionUrl,
                     @Value("${jdbc.db.browser_rpg.user}") String jdbcDbUsername,
                     @Value("${jdbc.db.browser_rpg.password}") String jdbcDbPassword) {
        this.jdbcDriverClassName = jdbcDriverClassName;
        this.jdbcConnectionUrl = jdbcConnectionUrl;
        this.jdbcDbUsername = jdbcDbUsername;
        this.jdbcDbPassword = jdbcDbPassword;
    }

    @Bean
    public DataSource mySqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcConnectionUrl);
        dataSource.setUsername(jdbcDbUsername);
        dataSource.setPassword(jdbcDbPassword);

        return dataSource;
    }

    @Bean
    public ViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}