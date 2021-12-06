package kr.co.zidol.basicsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin();


        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                SessionCreationPolicy. Always 		:  스프링 시큐리티가 항상 세션 생성
//                SessionCreationPolicy. If_Required 	:  스프링 시큐리티가 필요 시 생성(기본값)
//                SessionCreationPolicy. Never   		:  스프링 시큐리티가 생성하지 않지만 이미 존재하면 사용
//                SessionCreationPolicy. Stateless	 	:  스프링 시큐리티가 생성하지 않고 존재해도 사용하지 않음
                .sessionFixation().none();   //changeSessionId : 기본값 Servlet 3.1이상 기본값  .. none , migrateSession: 3.1미만 기봇값, newSession

    }
}
