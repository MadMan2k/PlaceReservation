package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.dto.ProcedureDto;
import place.reservation.reservations.entity.Procedure;
import place.reservation.reservations.repository.ProcedureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    public ProcedureService(ProcedureRepository procedureRepositoryInput) {
        this.procedureRepository = procedureRepositoryInput;
    }

    public List<Procedure> getAllProcedures() {
        Iterable<Procedure> proceduresIterable = procedureRepository.findAll();
        List<Procedure> proceduresList = new ArrayList<>();

        for (Procedure procedure : proceduresIterable) {
            if (procedure != null) {
                proceduresList.add(procedure);
            }
        }

        return proceduresList;
    }

    public void saveNewProcedure(ProcedureDto procedureDto) {
        final Procedure procedure = new Procedure();
        procedure.setName(procedureDto.getName());
        procedure.setDurationMinutes(procedureDto.getDurationMinutes());

        procedureRepository.save(procedure);
    }

    public void deleteProcedure(long id) throws ProcedureNotFoundException {
        Optional<Procedure> procedure = procedureRepository.findById(id);
        if (procedure.isPresent()) {
            procedureRepository.deleteById(id);
        } else {
            throw new ProcedureNotFoundException("Procedure ID " + id + " not found");
        }
    }
}
