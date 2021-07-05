package tkstudy.starterproject.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tkstudy.starterproject.domain.user.dto.CreateUserDto;
import tkstudy.starterproject.domain.user.dto.UserDto;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody Iterable<UserDto> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody UserDto registerUser(@RequestBody CreateUserDto createUserDto){
        return userService.registerUser(createUserDto);
    }
}
