package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.repository.ProcedureRepository;

@Service
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    public ProcedureService(ProcedureRepository procedureRepositoryInput) {
        this.procedureRepository = procedureRepositoryInput;
    }
}
