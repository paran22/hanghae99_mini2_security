package com.example.hanghae99_mini2.config;

import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://ministudy.s3-website.ap-northeast-2.amazonaws.com",
                        "http://yjstudy.s3-website.ap-northeast-2.amazonaws.com/",
                        "http://3.38.178.109/h2-console/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowCredentials(true);
    }

//    @Bean
//    public TomcatContextCustomizer sameSiteCookiesConfig() {
//        return context -> {
//            final Rfc6265CookieProcessor cookieProcessor = new Rfc6265CookieProcessor();
//            cookieProcessor.setSameSiteCookies(SameSiteCookies.NONE.getValue());
//            context.setCookieProcessor(cookieProcessor);
//        };
//    }
}
