package com.mwws.app.config;



import javax.servlet.MultipartConfigElement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class SpringConfig {

	 private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
	
	/*
	 * @Bean public MultipartResolver multipartResolver() { CommonsMultipartResolver
	 * commonsMultipartResolver = new CommonsMultipartResolver();
	 * commonsMultipartResolver.setMaxUploadSize(100000); return
	 * commonsMultipartResolver; }
	 */

    @Bean
    MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement(System.getProperty("java.io.tmpdir"),
                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
    }
 
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
