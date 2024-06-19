package dev.vorstu.service;

import dev.vorstu.dto.UserDTO;
import dev.vorstu.entities.Password;
import dev.vorstu.entities.Role;
import dev.vorstu.entities.Theme;
import dev.vorstu.entities.User;
import dev.vorstu.mappers.UserDataMapper;
import dev.vorstu.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Slf4j // log.info
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDataMapper userDataMapper;

    public Theme getTheme() {
        UserDTO auth = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getDetails();
        Theme theme = userRepository.findById(auth.getId()).get().getTheme();
        return theme;
    }

    public Object getUserDetails(String username) {

//        if(userRepository.userExist(username)){
//            log.info("exist");
//        }
        return userDataMapper.UserToUserDTO(userRepository.getUser(username));
    }

    public boolean Register(User user) {
        userRepository.save(new User(
                1L,
                "123",
                Role.USER,
                new Password("123"),
                null,
                true,
                Theme.LIGHT));
        return true;
    }


    public Theme changeTheme() {
        UserDTO auth = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getDetails();
        User user = userRepository.findById(auth.getId()).get();
        Theme theme = user.getTheme();
            if(theme == Theme.DARK) {
                user.setTheme(Theme.LIGHT);
            }
            else {
                user.setTheme(Theme.DARK);
            }
        userRepository.save(user);
            return theme;
    }

}