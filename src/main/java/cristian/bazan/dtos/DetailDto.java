package cristian.bazan.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDto {

    private String date;
    private String description;
    private Integer quantity;
    private Float pTotal;
}
