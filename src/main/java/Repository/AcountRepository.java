package Repository;

import MainClasses.Acount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcountRepository extends JpaRepository<Acount,Long>{
    List<Acount> findByActive(boolean b);
}
