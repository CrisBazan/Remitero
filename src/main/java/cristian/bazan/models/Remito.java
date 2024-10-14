package cristian.bazan.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import cristian.bazan.entities.DetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remito {

    private Long id;
    private Client client;
    private Float total;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    private String observations;
    private List<Detail> detail;
    private boolean active;
}
