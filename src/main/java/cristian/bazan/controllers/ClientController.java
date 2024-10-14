package cristian.bazan.controllers;

import cristian.bazan.dtos.ClientDto;
import cristian.bazan.models.Client;
import cristian.bazan.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<Client>> getActiveClientList(){

        List<Client> client = clientService.getAllClientsByCondition(true);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<Client>> getInactiveClientList(){

        List<Client> client = clientService.getAllClientsByCondition(false);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClient(@PathVariable Long clientId){

        Client client = clientService.getClientById(clientId);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/create")
    public  ResponseEntity<Client> createClient(@RequestBody Client client){

        return ResponseEntity.ok(clientService.insertClient(client));
    }

    @PutMapping("/edit")
    public ResponseEntity<Client> editClient(@RequestBody ClientDto client){

        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long clientId){

        return ResponseEntity.ok(clientService.deleteClient(clientId));
    }

    @PutMapping("restore/{clientId}")
    public ResponseEntity<Client> restoreClient(@PathVariable Long clientId){

        return ResponseEntity.ok(clientService.restoreClient(clientId));
    }
}
