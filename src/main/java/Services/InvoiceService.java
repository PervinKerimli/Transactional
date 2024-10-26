package Services;

import MainClasses.Invoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {
    //task7
    @Transactional(propagation = Propagation.REQUIRED)
    public void createInvoice(Invoice invoice){
        System.out.println("Creating invoice ");
        addInvoiceItems(invoice);
    }
    @Transactional(propagation = Propagation.NESTED)
    public void addInvoiceItems(Invoice invoice) {
        System.out.println("Adding invoice items ");
        throw new RuntimeException("Exception in addInvoiceItems");
    }
}
