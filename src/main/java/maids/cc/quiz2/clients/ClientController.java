package maids.cc.quiz2.clients;

import maids.cc.quiz2.errors.clients.ClientNotFoundException;
import maids.cc.quiz2.errors.clients.FailedToSaveClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) throws FailedToSaveClientException {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client , @PathVariable("id") long clientId) throws ClientNotFoundException {
        return clientService.updateClient(clientId , client);
    }
}
