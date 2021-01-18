package sg.com.nets.test.billing.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import sg.com.nets.test.billing.app.model.StringConstant;


@Configuration
@EnableWebSecurity
public class BasicSecurity extends WebSecurityConfigurerAdapter {

	
	@Value("${security.enable-csrf}")
   	private boolean csrfEnabled;
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/api/billing/**")
        .hasRole("USER")
        .and()
        .authorizeRequests()
		.antMatchers("/swagger-ui/")
		.hasRole("USER")
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll();
        
        if(csrfEnabled){
        	http.csrf().disable();
		}
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser(StringConstant.BASIC_AUTH_USER_LOGIN)
				.password(StringConstant.BASIC_AUTH_USER_PASSWORD).authorities("ROLE_USER").and()
				.withUser(StringConstant.BASIC_AUTH_ADMIN_LOGIN).password(StringConstant.BASIC_AUTH_ADMIN_PASSWORD)
				.authorities("ROLE_USER");
    }

}
