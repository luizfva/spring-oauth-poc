package poc.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * {@link SecurityConfig}
 *
 * @author Luiz Azevedo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private CustomerLoginUrlAuthenticationEntryPoint customerLoginUrlAuthenticationEntryPoint;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()

                .and()
                .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository)

                .and()
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(customerLoginUrlAuthenticationEntryPoint, new AntPathRequestMatcher("/{customerId}/**"));
    }
}
