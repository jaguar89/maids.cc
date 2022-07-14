package maids.cc.quiz2.clients;

import maids.cc.quiz2.errors.clients.ClientNotFoundException;
import maids.cc.quiz2.errors.clients.FailedToSaveClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) throws FailedToSaveClientException {
        try {
            return clientRepository.save(client);
        } catch (Exception ex) {
            throw new FailedToSaveClientException(ex.getMessage());
        }

    }

    public Client updateClient(long clientId, Client newClient) throws  ClientNotFoundException {

        var oldClientOptional = clientRepository.findById(clientId);
        if (!oldClientOptional.isPresent()) {
            throw new ClientNotFoundException("Client Not Found.");
        }
        var oldClient = oldClientOptional.get();
        var newName = newClient.getName();
        var newLastName = newClient.getLastName();
        if (newName != null && !newName.equalsIgnoreCase(""))
            oldClient.setName(newName);
        if (newLastName != null && !newLastName.equalsIgnoreCase(""))
            oldClient.setLastName(newClient.getLastName());
        oldClient.setMobile(newClient.getMobile());
        return clientRepository.save(oldClient);


    }
}
