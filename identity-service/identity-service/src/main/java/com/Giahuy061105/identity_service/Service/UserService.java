package com.Giahuy061105.identity_service.Service;

import com.Giahuy061105.identity_service.Entity.User;
import com.Giahuy061105.identity_service.Repository.UserRepository;
import com.Giahuy061105.identity_service.dto.request.UserCreationRequest;
import com.Giahuy061105.identity_service.dto.request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

       return UserRepository.save(user);
    }

    public List<User> getUsers(){
        return UserRepository.findAll();
    }
    public User getUser( String id){
        return UserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void DeleteUser(String userId){
        UserRepository.deleteById(userId);
    }
    public User UpdateUser(String userId , UserUpdateRequest request){
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return UserRepository.save(user);

    }
}
