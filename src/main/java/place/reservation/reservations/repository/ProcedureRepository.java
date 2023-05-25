package place.reservation.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import place.reservation.reservations.entity.Procedure;

import java.util.Optional;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
    Optional<Procedure> findByName(String name);
}
