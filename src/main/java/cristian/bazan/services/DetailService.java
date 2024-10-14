package cristian.bazan.services;

import cristian.bazan.dtos.DetailDto;
import cristian.bazan.entities.RemitoEntity;
import cristian.bazan.models.Detail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailService {

    void saveDetails(List<DetailDto> detailDtoList, RemitoEntity remitoEntity);
}
