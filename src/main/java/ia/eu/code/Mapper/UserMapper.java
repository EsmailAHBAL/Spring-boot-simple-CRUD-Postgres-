package ia.eu.code.Mapper;

import ia.eu.code.DTO.UserDto;
import ia.eu.code.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  @Mapping(source = "user.email",target = "emaildto")
  UserDto modelToDTO (User user);
  @Mapping(source = "emaildto",target = "email")
  User DTOTOmodel (UserDto user);
  List<UserDto> ListToDTO (List<User> users);
}
