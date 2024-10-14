package cristian.bazan.services.impl;

import cristian.bazan.dtos.DetailDto;
import cristian.bazan.dtos.RemitoDto;
import cristian.bazan.entities.DetailEntity;
import cristian.bazan.entities.RemitoEntity;
import cristian.bazan.models.Client;
import cristian.bazan.models.Detail;
import cristian.bazan.models.Remito;
import cristian.bazan.repositories.RemitoRepository;
import cristian.bazan.services.ClientService;
import cristian.bazan.services.DetailService;
import cristian.bazan.services.RemitoService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemitoServiceImpl implements RemitoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RemitoRepository remitoRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DetailService detailService;

    @Override
    public List<Remito> getAllRemitosByCondition(Boolean condition) {

        List<RemitoEntity> remitoEntities;

        if (condition){

            remitoEntities = remitoRepository.findAllByActiveIsTrueOrderByDateDescClientNameAsc();
        }else {

            remitoEntities = remitoRepository.findAllByActiveIsFalseOrderByDateDescClientNameAsc();
        }

        List<Remito> remitoList = new ArrayList<>();
        remitoEntities.forEach(r -> remitoList.add(modelMapper.map(r, Remito.class)));
        return remitoList;
    }

    @Override
    public Remito getFullRemitoById(Long remitoId) {

        Optional<RemitoEntity> remitoEntityFound = remitoRepository.findById(remitoId);
        if (!remitoEntityFound.isPresent()){

            throw new EntityNotFoundException();
        }else {

            RemitoEntity remitoEntity = remitoEntityFound.get();
            return  modelMapper.map(remitoEntity, Remito.class);
        }
    }

    @Override
    @Transactional
    public Remito insertRemito(RemitoDto remitoDto) {

        Client client = clientService.getClientById(remitoDto.getClientId());

        //Creacion del Remito a guardar
        Remito remito = new Remito();
        remito.setClient(client);
        remito.setTotal(remitoDto.getTotal());
        remito.setDate(remitoDto.getDate());
        remito.setObservations(remitoDto.getObservations());

        //Creacion y guardado de la entidad remito
        RemitoEntity remitoEntity = modelMapper.map(remito, RemitoEntity.class);
        remitoEntity.setActive(true);
        remitoEntity.setLastEdition(LocalDateTime.now());
        RemitoEntity remitoSaved = remitoRepository.save(remitoEntity);

        detailService.saveDetails(remitoDto.getDetails(), remitoSaved);

        return modelMapper.map(remitoSaved, Remito.class);
    }

    @Override
    public Boolean deleteRemito(Long remitoId) {

        Optional<RemitoEntity> remitoEntityFound = remitoRepository.findById(remitoId);
        if (!remitoEntityFound.isPresent()){

            throw new EntityNotFoundException();
        }else {

            RemitoEntity remitoEntity = remitoEntityFound.get();
            remitoRepository.delete(remitoEntity);
            return true;
        }
    }
}
