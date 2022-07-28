package ia.eu.code.Service;

import ia.eu.code.DTO.UserDto;

import java.util.List;

public interface IUserSevice {
    UserDto getUser(Long id);
    List<UserDto> getUsers();
    UserDto addUser(UserDto user);
    UserDto FindUser(Long id);
    void DeleteUser(Long id);
    UserDto ModifyUser(UserDto userDto);

}
