package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.entity.User;
import place.reservation.reservations.repository.UserRepository;
import place.reservation.reservations.service.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling users.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor for UserService.
     *
     * @param userRepositoryInput the user repository
     */
    public UserService(UserRepository userRepositoryInput) {
        this.userRepository = userRepositoryInput;
    }

    /**
     * Retrieves all users.
     *
     * @return the list of all users
     */
    public List<User> getAllUsers() {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();

        for (User user : usersIterable) {
            if (user != null) {
                userList.add(user);
            }
        }

        Collections.sort(userList);

        return userList;
    }

    /**
     * Creates a new user.
     *
     * @param userDto the user DTO to save
     */
    public void createNewUser(UserDto userDto) {
        final User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());

        userRepository.save(user);
    }

    /**
     * Deletes a user by ID.
     *
     * @param id the ID of the user to delete
     * @throws UserNotFoundException if the user is not found
     */
    public void deleteUser(long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User ID " + id + " not found");
        }
    }

    /**
     * Retrieves a user by ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user entity
     * @throws UserNotFoundException if the user is not found
     */
    public User getUserById(long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User ID " + id + " not found");
        }
    }

    /**
     * Retrieves a user DTO without password by ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user DTO without password
     * @throws UserNotFoundException if the user is not found
     */
    public UserDto getUserDtoWithoutPasswordById(long id) throws UserNotFoundException {
        User user = getUserById(id);
        UserDto userDtoWithoutPassword = new UserDto();
        userDtoWithoutPassword.setFirstName(user.getFirstName());
        userDtoWithoutPassword.setLastName(user.getLastName());
        userDtoWithoutPassword.setEmail(user.getEmail());
        userDtoWithoutPassword.setPhoneNumber(user.getPhoneNumber());
        userDtoWithoutPassword.setUserRole(user.getUserRole());
        return userDtoWithoutPassword;
    }

    /**
     * Updates a user.
     *
     * @param updatedUserDtoWithoutPassword the updated user DTO without password
     * @param id                            the ID of the user to update
     * @throws UserNotFoundException if the user is not found
     */
    public void updateUser(UserDto updatedUserDtoWithoutPassword, long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setFirstName(updatedUserDtoWithoutPassword.getFirstName());
            updatedUser.setLastName(updatedUserDtoWithoutPassword.getLastName());
            updatedUser.setEmail(updatedUserDtoWithoutPassword.getEmail());
            updatedUser.setPhoneNumber(updatedUserDtoWithoutPassword.getPhoneNumber());
            updatedUser.setUserRole(updatedUserDtoWithoutPassword.getUserRole());
            userRepository.save(updatedUser);
        } else {
            throw new UserNotFoundException("User ID " + id + " not found");
        }
    }

    /**
     * Checks if an email is unique.
     *
     * @param id    the ID of the user
     * @param email the email to check
     * @return true if the email is unique, false otherwise
     */
    public boolean isEmailUnique(long id, String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getId().equals(id);
        }
        return true;
    }

    /**
     * Checks if a phone number is unique.
     *
     * @param id          the ID of the user
     * @param phoneNumber the phone number to check
     * @return true if the phone number is unique, false otherwise
     */
    public boolean isPhoneNumberUnique(long id, String phoneNumber) {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
        if (user.isPresent()) {
            return user.get().getId().equals(id);
        }
        return true;
    }
}
