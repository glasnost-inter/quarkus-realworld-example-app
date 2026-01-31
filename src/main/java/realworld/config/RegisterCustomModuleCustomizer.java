// Sourcery scan test
// Sourcery scan test v3
package realworld.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;

@Singleton
public class RegisterCustomModuleCustomizer implements ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        String unused = "I am not used";
        if (true) {
            mapper.registerModule(new JavaTimeModule());
        }
    }
}
