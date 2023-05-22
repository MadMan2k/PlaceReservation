package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.entity.Rdv;
import place.reservation.reservations.repository.RdvRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RdvService {

    private final RdvRepository rdvRepository;

    public RdvService(RdvRepository rdvRepositoryInput) {
        this.rdvRepository = rdvRepositoryInput;
    }

    public List<Rdv> getAllRdvs() {
        Iterable<Rdv> rdvsIterable = rdvRepository.findAll();
        List<Rdv> rdvsList = new ArrayList<>();
        for (Rdv rdv : rdvsIterable) {
            if (rdv != null) {
                rdvsList.add(rdv);
            }
        }

        return rdvsList;
    }
}
