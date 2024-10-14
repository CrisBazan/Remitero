package cristian.bazan.services;

import cristian.bazan.dtos.ClientDto;
import cristian.bazan.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    List<Client> getAllClientsByCondition(Boolean condition);
    Client getClientById(Long clientId);
    Client insertClient(Client client);
    Client updateClient(ClientDto clientDto);
    Client deleteClient(Long clientId);
    Client restoreClient(Long clientId);
}
