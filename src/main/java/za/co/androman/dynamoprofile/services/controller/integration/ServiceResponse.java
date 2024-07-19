package za.co.androman.dynamoprofile.services.controller.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
public class ServiceResponse {
    private HttpStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
