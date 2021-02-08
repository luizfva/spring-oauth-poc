package poc.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * {@link AbstractIntegrationTest}
 *
 * @author Luiz Azevedo
 */
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = AuthApplication.class)
public abstract class AbstractIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;
}
