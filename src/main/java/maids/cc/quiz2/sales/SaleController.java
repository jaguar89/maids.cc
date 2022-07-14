package maids.cc.quiz2.sales;

import maids.cc.quiz2.errors.clients.ClientNotFoundException;
import maids.cc.quiz2.errors.sales.SaleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/clients/{id}/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getSales(@PathVariable("id") long clientId) throws ClientNotFoundException {
        return saleService.getSales(clientId);
    }

    @PostMapping
    public Sale addSale(@RequestBody Sale sale, @PathVariable("id") long clientId) throws ClientNotFoundException {
        return saleService.addSale(clientId, sale);
    }

    @PutMapping("/{saleId}")
    public Sale updateSale(@RequestBody Sale sale , @PathVariable("saleId") long saleId ,  @PathVariable("id") long clientId) throws ClientNotFoundException, SaleNotFoundException {
        return saleService.updateSale(clientId, saleId , sale);
    }
}
