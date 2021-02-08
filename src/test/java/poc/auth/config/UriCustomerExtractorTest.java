package poc.auth.config;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link UriCustomerExtractorTest}
 *
 * @author Luiz Azevedo
 */
public class UriCustomerExtractorTest {

    private final UriCustomerExtractor extractor = new UriCustomerExtractor();


    @Test
    public void extract() {
        assertEquals(Optional.of("acme"), extractor.extract("/acme/foo/bar"));
        assertEquals(Optional.of("acme"), extractor.extract("/acme/foo"));
        assertEquals(Optional.of("acme"), extractor.extract("/acme"));
        assertEquals(Optional.empty(), extractor.extract("/"));

    }
}
