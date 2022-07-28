package ia.eu.code.Controller;

import ia.eu.code.DTO.UserDto;
import ia.eu.code.Entities.User;
import ia.eu.code.Mapper.UserMapper;
import ia.eu.code.Repository.UserRepository;
import ia.eu.code.ServiceImp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user/{id}")
    UserDto getUser (@PathVariable("id") Long id){
        return  this.userService.getUser(id);
    }
    @GetMapping("delete/{id}")
    void deleteUser (@PathVariable("id") Long id){
        this.userService.DeleteUser(id);
    }
    @GetMapping("users")
    List<UserDto> getUsers_ (){
        return  this.userService.getUsers();
    }
    @PostMapping("add")
    UserDto addNewUser(@RequestBody() UserDto userDto){
        return  this.userService.addUser(userDto);
    }

    @PostMapping("update")
    UserDto updateUser(@RequestBody() UserDto userDto){
        return  this.userService.ModifyUser(userDto);
    }
}
