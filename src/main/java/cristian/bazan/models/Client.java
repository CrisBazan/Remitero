package cristian.bazan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Long id;
    private String name;
    private String cuit;
    private String address;
    private boolean active;
}
