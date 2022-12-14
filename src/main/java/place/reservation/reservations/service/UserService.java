package place.reservation.reservations.service;

import org.springframework.stereotype.Service;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.entity.User;
import place.reservation.reservations.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

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
}
