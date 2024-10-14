package cristian.bazan.services.impl;

import cristian.bazan.dtos.ClientDto;
import cristian.bazan.entities.ClientEntity;
import cristian.bazan.models.Client;
import cristian.bazan.repositories.ClientRepository;
import cristian.bazan.services.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Client> getAllClientsByCondition(Boolean condition) {

        List<ClientEntity> clientEntity;

        if (condition){

            clientEntity = clientRepository.findAllByActiveIsTrueOrderByNameAsc();
        }else {

            clientEntity = clientRepository.findAllByActiveIsFalseOrderByNameAsc();
        }

        List<Client> clientList = new ArrayList<>();
        clientEntity.forEach(c -> clientList.add(modelMapper.map(c, Client.class)));
        return clientList;
    }

    @Override
    public Client getClientById(Long clientId) {

        Optional<ClientEntity> clientEntityFound = clientRepository.findById(clientId);
        if (!clientEntityFound.isPresent()){

            throw new EntityNotFoundException();
        }else {

            ClientEntity clientEntity = clientEntityFound.get();
            return modelMapper.map(clientEntity, Client.class);
        }
    }

    @Override
    public Client insertClient(Client client) {

        ClientEntity  clientEntity = modelMapper.map(client, ClientEntity.class);
        clientEntity.setActive(true);
        clientEntity.setLastEdition(LocalDateTime.now());
        ClientEntity clientSaved = clientRepository.save(clientEntity);
        return modelMapper.map(clientSaved, Client.class);
    }

    @Override
    public Client updateClient(ClientDto clientDto) {

        Optional<ClientEntity> clientEntityFound = clientRepository.findById(clientDto.getId());

        if (!clientEntityFound.isPresent()){

            throw new EntityNotFoundException();
        }else {

            Client clientSaved = modelMapper.map(clientEntityFound.get(), Client.class);
            clientSaved.setName(clientDto.getName());
            clientSaved.setCuit(clientDto.getCuit());
            clientSaved.setAddress(clientDto.getAddress());
            ClientEntity clientEntity = modelMapper.map(clientSaved, ClientEntity.class);
            clientEntity.setLastEdition(LocalDateTime.now());
            ClientEntity clientUpdated = clientRepository.save(clientEntity);
            return modelMapper.map(clientUpdated, Client.class);
        }
    }

    @Override
    public Client deleteClient(Long clientId) {

        Optional<ClientEntity> clientEntityFound = clientRepository.findById(clientId);
        if (!clientEntityFound.isPresent()){

            throw new EntityNotFoundException();
        }else {

            ClientEntity clientEntity = clientEntityFound.get();
            clientEntity.setActive(false);
            clientEntity.setLastEdition(LocalDateTime.now());
            ClientEntity clientSaved = clientRepository.save(clientEntity);
            return modelMapper.map(clientSaved, Client.class);
        }
    }

    @Override
    public Client restoreClient(Long clientId) {

        Optional<ClientEntity> clientEntityFound = clientRepository.findById(clientId);
        if (!clientEntityFound.isPresent()){

            throw new EntityNotFoundException();
        }else {

            ClientEntity clientEntity = clientEntityFound.get();
            clientEntity.setActive(true);
            clientEntity.setLastEdition(LocalDateTime.now());
            ClientEntity clientEntitySaved = clientRepository.save(clientEntity);
            return modelMapper.map(clientEntitySaved, Client.class);
        }
    }
}
