package cristian.bazan.repositories;

import cristian.bazan.entities.RemitoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemitoRepository extends JpaRepository<RemitoEntity, Long> {

    List<RemitoEntity> findAllByActiveIsTrueOrderByDateDescClientNameAsc();
    List<RemitoEntity> findAllByActiveIsFalseOrderByDateDescClientNameAsc();
}
