package cristian.bazan.services.impl;

import cristian.bazan.dtos.DetailDto;
import cristian.bazan.entities.DetailEntity;
import cristian.bazan.entities.RemitoEntity;
import cristian.bazan.models.Detail;
import cristian.bazan.repositories.DetailRepository;
import cristian.bazan.services.DetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DetailRepository detailRepository;

    public void saveDetails(List<DetailDto> detailDtoList, RemitoEntity remitoEntity){

        for(DetailDto detail : detailDtoList){

            DetailEntity detailEntity = modelMapper.map(detail, DetailEntity.class);
            detailEntity.setRemitoEntity(remitoEntity);
            detailRepository.save(detailEntity);
        }
    }
}
