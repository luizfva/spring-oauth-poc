package poc.auth.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import poc.auth.AbstractIntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * {@link GenericControllerTest}
 *
 * @author Luiz Azevedo
 */
public class GenericControllerTest extends AbstractIntegrationTest {

    @Test
    @WithMockUser
    public void testGetMapping() throws Exception {
        mockMvc.perform(get("/api/foo"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void testPostMapping() throws Exception {
        mockMvc.perform(post("/api/foo"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void testPutMapping() throws Exception {
        mockMvc.perform(put("/api/foo"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void testPatchMapping() throws Exception {
        mockMvc.perform(patch("/api/foo"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void testDeleteMapping() throws Exception {
        mockMvc.perform(delete("/api/foo"))
                .andExpect(status().isOk());
    }
}
