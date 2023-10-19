package crud.application.services;

import crud.application.entities.User;
import crud.application.repositories.UserRepository;
import crud.application.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Integer id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Integer id){
        Optional<User> user = repository.findById(id);
        if(user == null) throw new ResourceNotFoundException(id);
        else repository.deleteById(id);
    }






}
