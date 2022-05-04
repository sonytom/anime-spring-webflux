package tom.company.animespringwebflux.domain;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table(name = "animes")
public class AnimeModel {

    @Id
    private Long id;
    @NotNull
    @NotEmpty(message = "The name of this anime cannot be empty")
    private String name;

}
