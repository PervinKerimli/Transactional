package Repository;

import MainClasses.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsSaverepository  extends JpaRepository<OrderDetails,Long> {
}
