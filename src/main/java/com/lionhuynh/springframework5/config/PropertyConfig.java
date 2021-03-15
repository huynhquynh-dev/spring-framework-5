package com.lionhuynh.springframework5.config;

import com.lionhuynh.springframework5.exxamplebeans.FakeDataSource;
import com.lionhuynh.springframework5.exxamplebeans.JmsDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Value("${lionhuynh.username}")
    String user;

    @Value("${lionhuynh.password}")
    String password;

    @Value("${lionhuynh.dburl}")
    String url;

    @Value("${lionhuynh.jms.username}")
    String jmsUser;

    @Value("${lionhuynh.jms.password}")
    String jmsPassword;

    @Value("${lionhuynh.jms.dburl}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public JmsDataSource jmsDataSource(){
        JmsDataSource jmsDataSource = new JmsDataSource();
        jmsDataSource.setUser(jmsUser);
        jmsDataSource.setPassword(jmsPassword);
        jmsDataSource.setUrl(jmsUrl);
        return jmsDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
