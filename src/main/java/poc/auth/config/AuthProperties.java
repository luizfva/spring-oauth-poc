package poc.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.Set;

/**
 * {@link AuthProperties}
 *
 * @author Luiz Azevedo
 */
@Data
@ConfigurationProperties("app.auth")
public class AuthProperties {
    private String authServerBaseUrl;
    private String authServerLogoutUrl;
    private Set<String> scopes;
    private Map<String, ApplicationCredentials> registrations;

    @Data
    public static class ApplicationCredentials {
        private String clientId;
        private String clientSecret;
    }
}
