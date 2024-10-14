package cristian.bazan.repositories;

import cristian.bazan.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {

    List<OwnerEntity> findAllByOrderByIdDesc();
}
