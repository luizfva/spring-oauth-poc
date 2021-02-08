package poc.auth;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * {@link AuthenticationIntegrationTest}
 *
 * @author Luiz Azevedo
 */
public class AuthenticationIntegrationTest extends AbstractIntegrationTest {

    @Test
    @WithAnonymousUser
    public void unauthenticatedCustomerRequest() throws Exception {
        mockMvc.perform(get("/acme/foo"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrlPattern("**/oauth2/authorization/acme"))
                .andDo(print());
    }

    @Test
    @WithAnonymousUser
    public void unknonwCustomer() throws Exception {
        mockMvc.perform(get("/foo/bar"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrlPattern("**/?error=notFound"))
                .andDo(print());
    }

    @Test
    @WithMockUser
    public void authenticatedCustomerRequest() throws Exception {
        mockMvc.perform(get("/acme/foo"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
