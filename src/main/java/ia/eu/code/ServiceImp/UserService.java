package ia.eu.code.ServiceImp;

import ia.eu.code.DTO.UserDto;
import ia.eu.code.Entities.User;
import ia.eu.code.Mapper.UserMapper;
import ia.eu.code.Repository.UserRepository;
import ia.eu.code.Service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserSevice {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDto getUser(Long id) {

     try {
         UserDto userDto = this.FindUser(id);

         return  userDto;

     }catch (Exception ex){
         throw  new RuntimeException(ex.getMessage());
     }

    }

    @Override
    public List<UserDto> getUsers() {
        try {
            List<User> users = this.userRepository.findAll();
            return this.userMapper.ListToDTO(users);
        }
        catch (Exception exception){
            List<User> users = this.userRepository.findAll();
          throw  new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public UserDto addUser(UserDto user) {
      Optional<User> findOne= Optional.ofNullable(this.userRepository.findByEmail(user.getEmaildto()));
      if(findOne.isPresent()){

          throw new RuntimeException("Already Exixst");
      }
       User result = this.userMapper.DTOTOmodel(user);
        this.userRepository.save(result);
      return  user;
    }

    @Override
    public UserDto FindUser(Long id) {

        User user = this.userRepository.findById(id).orElseThrow(
                ()-> {
                    throw  new RuntimeException("User Not Found");
                }
        );

        return this.userMapper.modelToDTO(user);
    }

    @Override
    public void DeleteUser(Long id) {
      Optional<User> user = this.userRepository.findById(id);
              if (user.isPresent())
              {

                  this.userRepository.deleteById(id);
                  System.out.printf("Deleted");
              }
              else
              {
                  throw  new RuntimeException("User Not Found In Database");
              }


    }

    @Override
    public UserDto ModifyUser(UserDto userDto) {

        Optional<User> u = this.userRepository.findById(userDto.getId());

        if (u.isPresent()){
            User tuUser = this.userMapper.DTOTOmodel(userDto);
            this.userRepository.save(tuUser);
       return this.userMapper.modelToDTO(tuUser);

        }
        throw  new RuntimeException("User Not Exist in db For Modify");
    }
}
