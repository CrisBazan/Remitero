package cristian.bazan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cristian.bazan.entities.RemitoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    private Long id;

    @JsonIgnore
    private Remito remito;

    private String date;
    private String description;
    private Integer quantity;
    private Float pTotal;
}
