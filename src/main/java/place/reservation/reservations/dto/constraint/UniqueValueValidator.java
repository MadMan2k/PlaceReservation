package place.reservation.reservations.dto.constraint;

import place.reservation.reservations.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    private UserRepository userRepository;

    private DataType dataType;

    public UniqueValueValidator(UserRepository inputUserRepository) {
        this.userRepository = inputUserRepository;
    }

    /**
     * @param constraintAnnotation
     */
    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.dataType = constraintAnnotation.dataType();
    }

    /**
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        System.out.println("THIS IS VALUE FROM VALIDATOR : " + value);
        System.out.println("DATATYPE IS : " + dataType.toString());
        //TODO

        return false;
    }
}
