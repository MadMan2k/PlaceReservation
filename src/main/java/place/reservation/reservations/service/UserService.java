package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.entity.User;
import place.reservation.reservations.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepositoryInput) {
        this.userRepository = userRepositoryInput;
    }

    /**
     * @return list of all users from DB
     */
    public List<User> getAllUsers() {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();

        for (User user : usersIterable) {
            if (user != null) {
                userList.add(user);
            }
        }

        return userList;
    }

    /**
     * @param userDto
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
     * @param id
     * @throws UserNotFoundException
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
     * @param id
     * @return user
     * @throws UserNotFoundException
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
     * @param id
     * @return userDTO without password
     * @throws UserNotFoundException
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
     * @param updatedUserDtoWithoutPassword
     * @param id
     * @throws UserNotFoundException
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

    public boolean isEmailUnique(long id, String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getId().equals(id);
        }
        return true;
    }
}
