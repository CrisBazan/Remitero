package cristian.bazan.services.impl;

import cristian.bazan.dtos.OwnerDto;
import cristian.bazan.entities.OwnerEntity;
import cristian.bazan.repositories.OwnerRepository;
import cristian.bazan.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public OwnerDto getOwner() {

        List<OwnerEntity> ownerEntityList = ownerRepository.findAllByOrderByIdDesc();
        if (ownerEntityList.isEmpty()){

            OwnerDto ownerDto = new OwnerDto();
            ownerDto.setName("");
            return ownerDto;
        }else {

            OwnerEntity ownerEntity = ownerEntityList.get(0);
            OwnerDto ownerDto = modelMapper.map(ownerEntity, OwnerDto.class);
            return ownerDto;
        }
    }

    @Override
    public OwnerDto updateOrCreateOwner(OwnerDto ownerDto) {

        Optional<OwnerEntity> ownerEntityFound = ownerRepository.findById(1L);
        OwnerEntity ownerEntity;

        if (!ownerEntityFound.isPresent()){

            ownerEntity = new OwnerEntity();
        }else {

            ownerEntity = ownerEntityFound.get();
        }

        ownerEntity.setName(ownerDto.getName());
        ownerEntity.setCuit(ownerDto.getCuit());
        ownerEntity.setAddress(ownerDto.getAddress());
        ownerEntity.setTelephone(ownerDto.getTelephone());
        ownerEntity.setEmail(ownerDto.getEmail());
        ownerEntity.setLastEdition(LocalDateTime.now());

        OwnerEntity ownerSaved = ownerRepository.save(ownerEntity);
        OwnerDto ownerAnswer = modelMapper.map(ownerSaved, OwnerDto.class);
        return ownerAnswer;
    }
}
