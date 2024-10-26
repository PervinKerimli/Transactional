package Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcountService {
    //task6
    @Transactional(propagation = Propagation.NEVER)
    public void auditLog(String mess){
        System.out.println("Message: " + mess);
    }
}
