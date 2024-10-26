package Repository;

import MainClasses.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSaverepository extends JpaRepository<Order,Long> {
}
