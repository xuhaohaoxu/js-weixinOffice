package com.js.jsweixinoffice.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

/**
 * @author xuhaooo
 * @date Date : 2021年05月15日 13:40
 * @version V1.0
 */

@Configuration
public class DruidConfig {
    @Bean
    // 将所有前缀为spring.datasource下的配置项都加载DataSource中
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean<Servlet> druidServlet() {
        // 进行 druid 监控的配置处理
        ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/**");
        // 白名单
        srb.addInitParameter("allow", "127.0.0.1");
        // 黑名单
        srb.addInitParameter("deny", "192.168.1.1");
        // 是否可以重置数据源
        srb.addInitParameter("resetEnable", "false");
        return srb;
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new WebStatFilter());
        // 所有请求进行监控处理
        frb.addUrlPatterns("/*");
        // 排除名单
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return frb;
    }

}
