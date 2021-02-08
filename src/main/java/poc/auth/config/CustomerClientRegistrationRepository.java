package poc.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link CustomerClientRegistrationRepository} allows the application to leverage multiple ClientRegistration, according
 * to which customer is accessing the application
 *
 * @author Luiz Azevedo
 */
@Component
public class CustomerClientRegistrationRepository implements ClientRegistrationRepository {

    // Dummy implementation that would be replaced by a proper secret store
    @Autowired
    private AuthProperties authProperties;

    private final Map<String, ClientRegistration> localCache = new HashMap<>();

    @Override
    public ClientRegistration findByRegistrationId(final String registrationId) {
        if (authProperties.getRegistrations().containsKey(registrationId)) {
            return localCache.computeIfAbsent(registrationId, this::createClientRegistration);
        }
        return null;
    }

    private synchronized ClientRegistration createClientRegistration(final String registrationId) {
        final AuthProperties.ApplicationCredentials credentials = authProperties.getRegistrations().get(registrationId);

        return ClientRegistration.withRegistrationId(registrationId)
                .clientName("Okta")
                .clientId(credentials.getClientId())
                .clientSecret(credentials.getClientSecret())
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
                .scope(authProperties.getScopes().toArray(new String[0]))
                .authorizationUri(authProperties.getAuthServerBaseUrl() + "/v1/authorize")
                .tokenUri(authProperties.getAuthServerBaseUrl() + "/v1/token")
                .jwkSetUri(authProperties.getAuthServerBaseUrl() + "/v1/keys")
                .providerConfigurationMetadata(Map.of("end_session_endpoint", authProperties.getAuthServerLogoutUrl()))
                .build();
    }
}