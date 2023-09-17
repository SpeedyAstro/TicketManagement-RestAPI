package in.astro.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    private LocalDateTime localDateTime;
    private String msg;
    private String status;
}
