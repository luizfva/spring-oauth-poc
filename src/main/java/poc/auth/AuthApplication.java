package poc.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import poc.auth.config.AuthProperties;

@SpringBootApplication
@EnableConfigurationProperties(AuthProperties.class)
public class AuthApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AuthApplication.class);
    }
}
