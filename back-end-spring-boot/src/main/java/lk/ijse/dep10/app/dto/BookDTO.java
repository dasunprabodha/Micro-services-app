package lk.ijse.dep10.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO implements Serializable {
    @NotBlank(message = "ISBN can't be empty")
    private String isbn;
    @NotBlank(message = "Title can't be empty")
    private String title;
}
