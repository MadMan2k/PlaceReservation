package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.dto.ProcedureDto;
import place.reservation.reservations.entity.Procedure;
import place.reservation.reservations.repository.ProcedureRepository;
import place.reservation.reservations.service.exception.ProcedureNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling procedures.
 */
@Service
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    /**
     * Constructor for ProcedureService.
     *
     * @param procedureRepositoryInput the procedure repository
     */
    public ProcedureService(ProcedureRepository procedureRepositoryInput) {
        this.procedureRepository = procedureRepositoryInput;
    }

    /**
     * Retrieves all procedures.
     *
     * @return the list of all procedures
     */
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

    /**
     * Saves a new procedure.
     *
     * @param procedureDto the procedure DTO to save
     */
    public void saveNewProcedure(ProcedureDto procedureDto) {
        final Procedure procedure = new Procedure();
//        procedure.setName(procedureDto.getName());
        procedure.setName(String.format("%s%s", procedureDto.getName().substring(0, 1).toUpperCase(), procedureDto.getName().substring(1).toLowerCase()));
        procedure.setDurationInMinutes(procedureDto.getDurationInMinutes());

        procedureRepository.save(procedure);
    }

    /**
     * Deletes a procedure by ID.
     *
     * @param id the ID of the procedure to delete
     * @throws ProcedureNotFoundException if the procedure is not found
     */
    public void deleteProcedure(long id) throws ProcedureNotFoundException {
        Optional<Procedure> procedure = procedureRepository.findById(id);
        if (procedure.isPresent()) {
            procedureRepository.deleteById(id);
        } else {
            throw new ProcedureNotFoundException("Procedure ID " + id + " not found");
        }
    }

    /**
     * Retrieves a procedure by ID.
     *
     * @param id the ID of the procedure to retrieve
     * @return the procedure DTO
     * @throws ProcedureNotFoundException if the procedure is not found
     */
    public ProcedureDto getProcedureById(long id) throws ProcedureNotFoundException {
        Optional<Procedure> procedure = procedureRepository.findById(id);
        ProcedureDto procedureDto = new ProcedureDto();
        if (procedure.isPresent()) {
            procedureDto.setName(procedure.get().getName());
            procedureDto.setDurationInMinutes(procedure.get().getDurationInMinutes());
            return procedureDto;
        } else {
            throw new ProcedureNotFoundException("Procedure ID " + id + " not found");
        }
    }

    /**
     * Checks if a procedure name is unique.
     *
     * @param id   the ID of the procedure
     * @param name the name of the procedure
     * @return true if the name is unique, false otherwise
     */
    public boolean isNameUnique(long id, String name) {
        Optional<Procedure> procedure = procedureRepository.findByName(String.format("%s%s", name.substring(0, 1).toUpperCase(), name.substring(1).toLowerCase()));
        if (procedure.isPresent()) {
            return procedure.get().getId().equals(id);
        }
        return true;
    }

    /**
     * Checks if a procedure name is unique.
     *
     * @param name the name of the procedure
     * @return true if the name is unique, false otherwise
     */
    public boolean isNameUnique(String name) {
        Optional<Procedure> procedure = procedureRepository.findByName(String.format("%s%s", name.substring(0, 1).toUpperCase(), name.substring(1).toLowerCase()));
        return procedure.isEmpty();
    }

    /**
     * Updates a procedure.
     *
     * @param procedureDto the updated procedure DTO
     * @param id           the ID of the procedure to update
     * @throws ProcedureNotFoundException if the procedure is not found
     */
    public void updateProcedure(ProcedureDto procedureDto, long id) throws ProcedureNotFoundException {
        Optional<Procedure> procedure = procedureRepository.findById(id);
        if (procedure.isPresent()) {
            Procedure updatedProcedure = procedure.get();
            updatedProcedure.setName(String.format("%s%s", procedureDto.getName().substring(0, 1).toUpperCase(), procedureDto.getName().substring(1).toLowerCase()));
            updatedProcedure.setPrice(procedureDto.getPrice());
            updatedProcedure.setDurationInMinutes(procedureDto.getDurationInMinutes());
            procedureRepository.save(updatedProcedure);
        } else {
            throw new ProcedureNotFoundException("Procedure ID " + id + " not found");
        }
    }
}
