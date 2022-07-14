package maids.cc.quiz2.sales;

import maids.cc.quiz2.clients.ClientRepository;
import maids.cc.quiz2.errors.clients.ClientNotFoundException;
import maids.cc.quiz2.errors.sales.SaleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClientRepository clientRepository;

    private Logger LOGGER = LoggerFactory.getLogger(Sale.class);

    public List<Sale> getSales(long clientId) throws ClientNotFoundException {
        var clientOptional = clientRepository.findById(clientId);
        if(!clientOptional.isPresent()){
            throw new ClientNotFoundException("Client Not Found.");
        }
        var client = clientOptional.get();
        return client.getSale();
    }

    public Sale addSale(long clientId, Sale sale) throws ClientNotFoundException {
        var clientOptional = clientRepository.findById(clientId);
        if(!clientOptional.isPresent()){
            throw new ClientNotFoundException("Client Not Found.");
        }
        var client = clientOptional.get();
        sale.setClient(client);
        return saleRepository.save(sale);

    }

    public Sale updateSale(long clientId , long saleId, Sale sale) throws ClientNotFoundException, SaleNotFoundException {
        var clientOptional = clientRepository.findById(clientId);
        if(!clientOptional.isPresent()){
            throw new ClientNotFoundException("Client Not Found.");
        }
        var oldSaleOptional = saleRepository.findById(saleId);
        if(!oldSaleOptional.isPresent()){
            throw new SaleNotFoundException("Sale Not Found.");
        }
        var oldSale = oldSaleOptional.get();
        if(!clientOptional.get().getSale().contains(oldSale)){
            throw new SaleNotFoundException("Sale Not Found.");
        }
        if (sale.getPrice() > 0)
            oldSale.setPrice(sale.getPrice());
        if (sale.getQuantity() > 0)
            oldSale.setQuantity(sale.getQuantity());
        if (sale.getTotal() > 0)
            oldSale.setTotal(sale.getTotal());

        oldSale.setSeller(sale.getSeller());
        LOGGER.info("Update Sale\'s Quantity: " + sale.getQuantity());
        LOGGER.info("Update Sale\'s Price: " + sale.getPrice());

        return saleRepository.save(oldSale);
    }
}
