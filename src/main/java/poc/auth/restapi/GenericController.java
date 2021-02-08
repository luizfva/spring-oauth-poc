package poc.auth.restapi;

import org.springframework.web.bind.annotation.*;

/***
 * This controller is only here to respond with a 200s when auth succeeds
 * as per ext_authz protocol: https://www.getambassador.io/docs/latest/topics/running/services/ext_authz/
 */
@RestController
@RequestMapping("/**")
public class GenericController {

    @GetMapping
    public String getMapping() {
        return "Hello World";
    }

    @PutMapping
    public void putMapping() {
        // no-op
    }

    @PostMapping
    public void postMapping() {
        // no-op
    }

    @PatchMapping
    public void patchMapping() {
        // no-op
    }

    @DeleteMapping
    public void deleteMapping() {
        // no-op
    }
}