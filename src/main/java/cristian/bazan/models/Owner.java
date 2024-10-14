package cristian.bazan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    private Long id;
    private String name;
    private String cuit;
    private String address;
    private String telephone;
    private String email;
}
