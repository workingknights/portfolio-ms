package com.aknights.ticker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@EnableResourceServer
@EnableDiscoveryClient
//@EnableOAuth2Client
@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties
@Configuration
public class TickerApplication { //extends ResourceServerConfigurerAdapter {

//    @Autowired
//    private ResourceServerProperties sso;

    public static void main(String[] args) {
        SpringApplication.run(TickerApplication.class, args);
    }

//    @Bean
//    @ConfigurationProperties(prefix = "security.oauth2.client")
//    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
//        return new ClientCredentialsResourceDetails();
//    }
//
//    @Bean
//    public RequestInterceptor oauth2FeignRequestInterceptor(){
//        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
//    }
//
//    @Bean
//    public OAuth2RestTemplate clientCredentialsRestTemplate() {
//        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
//    }
//
//    @Bean
//    public ResourceServerTokenServices tokenServices() {
//        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/" , "/AAPL").permitAll()
//                .anyRequest().authenticated();
//    }
}
