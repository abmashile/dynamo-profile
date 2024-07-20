package za.co.androman.dynamoprofile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.androman.dynamoprofile.entities.User;
import za.co.androman.dynamoprofile.repositories.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User save(User user){
        return this.userRepository.save(user);
    }
    public void delete(User user){
        this.userRepository.delete(user);
    }
    public User get(long id){
        return this.userRepository.findById(id).orElse(null);
    }
    public List<User> getAll() {
        return this.userRepository.findAll();
    }
}
