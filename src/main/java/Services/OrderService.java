package Services;

import Repository.AcountRepository;
import Repository.OrderDetailsSaverepository;
import Repository.OrderSaverepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import MainClasses.*;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private Order order;
    @Autowired
    private OrderSaverepository orderSaverepository;
    @Autowired
    private OrderDetailsSaverepository orderDetailsSaverepository;
    @Autowired
    private Acount acount;
    @Autowired
    private AcountRepository acountRepository;

    //task1
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrder(Order order){
        orderSaverepository.save(order);
        saveorderDetails(order);

    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveorderDetails(Order order){
        throw new RuntimeException("Welcome to roolback");
    }

    //task2
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateAccountBalance(long accountId, double newBalance){
        Acount acount1= acountRepository.findById(accountId).orElseThrow();
        acount1.setBalance(newBalance);
        acountRepository.save(acount1);
        updateTransactionLog(accountId,"setted");

    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateTransactionLog(long accountId, String action) {
        throw new RuntimeException("Exception in updateTransactionLog");
    }

    //task3
    @Transactional(propagation =Propagation.SUPPORTS)
    public void aplyDiscount(long id,double discount){
        Acount acount1 = acountRepository.findById(id).orElseThrow();
        double newBalance = acount.getBalance()-discount;
        acount1.setBalance(newBalance);
        System.out.println("Your discount is: " + discount);
    }
    //task4
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void aplyDiscountNot(long id,double discount) {
        Acount acount1 = acountRepository.findById(id).orElseThrow();
        double newBalance = acount.getBalance()-discount;
        acount1.setBalance(newBalance);
        System.out.println("Your discount without transaction: " + discount);
    }
    //task5
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteInactiveUsers() {
        List<Acount> inactiveUsers = acountRepository.findByActive(false);
        for (Acount acount1 : inactiveUsers) {
            acountRepository.delete(acount1);
        }
        System.out.println("Deleted inactive users.");
    }

}
