package kr.co.zidol.basicsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .authorizeRequests()
//                .anyRequest().authenticated();
//        http
//                .formLogin()
//                .and()
//                .sessionManagement()
//                .maximumSessions(1)//최대 허용 세션 수 : 1
//                .maxSessionsPreventsLogin(false) //세션 초과시 현재 로그인 시도 인증 실패
//        ;

//세션 정책
/*        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                SessionCreationPolicy. Always 		:  스프링 시큐리티가 항상 세션 생성
//                SessionCreationPolicy. If_Required 	:  스프링 시큐리티가 필요 시 생성(기본값)
//                SessionCreationPolicy. Never   		:  스프링 시큐리티가 생성하지 않지만 이미 존재하면 사용
//                SessionCreationPolicy. Stateless	 	:  스프링 시큐리티가 생성하지 않고 존재해도 사용하지 않음
                .sessionFixation().none();   //changeSessionId : 기본값 Servlet 3.1이상 기본값  .. none , migrateSession: 3.1미만 기봇값, newSession
                */

        http
                .formLogin()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
     

    }
}
