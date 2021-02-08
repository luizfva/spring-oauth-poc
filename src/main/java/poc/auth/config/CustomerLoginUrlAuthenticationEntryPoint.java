package poc.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

/**
 * {@link CustomerLoginUrlAuthenticationEntryPoint}
 *
 * @author Luiz Azevedo
 */
@Component
public class CustomerLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    @Autowired
    private UriCustomerExtractor customerExtractor;

    public CustomerLoginUrlAuthenticationEntryPoint() {
        super(DEFAULT_AUTHORIZATION_REQUEST_BASE_URI + "/" + "internal");
    }

    @Override
    protected String determineUrlToUseForThisRequest(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception) {
        final Optional<String> customer = customerExtractor.extract(request);

        return customer.map(customerRegistrationName -> DEFAULT_AUTHORIZATION_REQUEST_BASE_URI + "/" + customerRegistrationName)
                .orElse("/?error=notFound");
    }
}
