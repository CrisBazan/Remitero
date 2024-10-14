package cristian.bazan.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {

    private String name;
    private String cuit;
    private String address;
    private String telephone;
    private String email;
}