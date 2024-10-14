package cristian.bazan.repositories;

import cristian.bazan.entities.ClientEntity;
import cristian.bazan.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    List<ClientEntity> findAllByActiveIsTrueOrderByNameAsc();
    List<ClientEntity> findAllByActiveIsFalseOrderByNameAsc();
}
