package cristian.bazan.services;

import cristian.bazan.dtos.RemitoDto;
import cristian.bazan.models.Remito;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RemitoService {

    List<Remito> getAllRemitosByCondition(Boolean condition);
    Remito getFullRemitoById(Long remitoId);
    Remito insertRemito(RemitoDto remitoDto);
    Boolean deleteRemito(Long remitoId);
}
