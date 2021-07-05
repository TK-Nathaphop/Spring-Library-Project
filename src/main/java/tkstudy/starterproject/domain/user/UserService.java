package tkstudy.starterproject.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tkstudy.starterproject.base.error.user.PasswordIsNotSameException;
import tkstudy.starterproject.base.error.user.RoleIsNotExistsException;
import tkstudy.starterproject.base.error.user.UsernameAlreadyExistsException;
import tkstudy.starterproject.domain.user.domain.User;
import tkstudy.starterproject.domain.user.domain.UserRepository;
import tkstudy.starterproject.domain.user.dto.CreateUserDto;
import tkstudy.starterproject.domain.user.dto.UserDto;

import java.util.ArrayList;


@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    UserDto registerUser(CreateUserDto createUserDto){
        if(userRepository.existsByUsername(createUserDto.getUsername()))
            throw new UsernameAlreadyExistsException();
        else if(!createUserDto.getPassword().equals(createUserDto.getPasswordConfirmation()))
            throw new PasswordIsNotSameException();
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        user.setName(createUserDto.getName());

        try {
            user.setRole(createUserDto.getRole());
        } catch(IllegalArgumentException e){
            throw new RoleIsNotExistsException();
        }

        user = userRepository.save(user);
        return new UserDto(user.getUsername(), user.getName(), user.getRole());
    }

    public Iterable<UserDto> getAllUser() {
        ArrayList<UserDto> users = new ArrayList<UserDto>();
        for(User user: userRepository.findAll()){
            users.add(new UserDto(user.getUsername(), user.getName(), user.getRole()));
        }
        return users;
    }
}
