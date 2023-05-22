package place.reservation.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import place.reservation.reservations.entity.Rdv;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Long> {
}
