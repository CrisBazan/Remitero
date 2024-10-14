package cristian.bazan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "remitoDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remito_id", nullable = false)
    @JsonIgnore
    private RemitoEntity remitoEntity;

    @Column
    private String date;

    @Column
    private String description;

    @Column
    private Long quantity;

    @Column
    private Float pTotal;

}
