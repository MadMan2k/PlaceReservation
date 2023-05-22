package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.repository.RdvRepository;

@Service
public class RdvService {

    private final RdvRepository rdvRepository;

    public RdvService(RdvRepository rdvRepositoryInput) {
        this.rdvRepository = rdvRepositoryInput;
    }
}
