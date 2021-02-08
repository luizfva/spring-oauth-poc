package poc.auth.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@link UriCustomerExtractor}
 *
 * @author Luiz Azevedo
 */
@Component
public class UriCustomerExtractor {

    private static final Pattern CUSTOMER_PATTERN = Pattern.compile("^/([A-Za-z0-9\\-]+).*$");

    public Optional<String> extract(final HttpServletRequest request) {
        return extract(request.getRequestURI());
    }

    public Optional<String> extract(final String requestURI) {
        final Matcher matcher = CUSTOMER_PATTERN.matcher(requestURI);
        if (matcher.find()) {
            return Optional.of(matcher.group(1));
        }
        return Optional.empty();
    }
}
