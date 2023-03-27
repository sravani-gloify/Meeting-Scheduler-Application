package com.jcg.mapstruct.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfiguration {
   
	public class Emailconfiguration {
		
		@Value("${spring.mail.host}")
	    private String host;
 
	    @Value("${spring.mail.port}")
	    private int port;
 
	    @Value("${spring.mail.username}")
	    private String username;
	 
      @Value("${spring.mail.password}")
	    private String password;
 
	    @Value("${spring.mail.properties.mail.smtp.auth}")
	    private String smtpAuth;
	 
	    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	    private String starttlsEnable;
	 
	    @Value("${spring.mail.from}")
	    private String from;
	 
	    @Bean
	    public JavaMailSenderImpl javaMailSender() {
	        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	
	        javaMailSender.setHost(this.host);
	        javaMailSender.setPort(this.port);
	 
	        javaMailSender.setUsername(this.username);
	        javaMailSender.setPassword(this.password);
	
	        Properties props = javaMailSender.getJavaMailProperties();
	        props.put("mail.smtp.auth", smtpAuth);
	       // props.put(mailSender, props)
	        props.put("mail.smtp.starttls.enable", starttlsEnable);
	
	        return javaMailSender;
	    }
	    
	} 
}
