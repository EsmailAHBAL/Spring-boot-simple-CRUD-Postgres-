package ia.eu.code.ToRun;

import ia.eu.code.Entities.User;
import ia.eu.code.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class main implements CommandLineRunner {
//    @Autowired
//    NationalityRepository nationalityRepository;
//    @Autowired
//    IndividualRepository individualRepository;
    @Autowired
    UserRepository userRepository;
    @Override
 public void run(String... args) throws Exception {
        if(userRepository.count()==0)
        {
            List<User> users= new ArrayList<>();
            User user= new User();
            user.setUsername("Qhmed");
            user.setEmail("Qhmed@gmail.com");
            user.setPassword("Qhmed");
            users.add(user);
            User user2= new User();
            user2.setUsername("Reda");
            user2.setEmail("Reda@gmail.com");
            user2.setPassword("Reda");
            users.add(user2);

            User user1= new User();
            user1.setUsername("Mohammed");
            user1.setEmail("Mohammed@gmail.com");
            user1.setPassword("Mohammed");
            users.add(user1);

            userRepository.saveAll(users);
        }

     System.out.println("You Can Add Some Data If U need Go To ia.eu.code.ToRun.main " );

    }
}
