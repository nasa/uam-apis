package gov.nasa.uamdc;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DataCollectorWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().permitAll();

        http
                .authorizeRequests()
                .antMatchers("/uss-exchange").permitAll()
                .antMatchers("/api").permitAll()
                .antMatchers("/api-docs").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated();
    }
}
