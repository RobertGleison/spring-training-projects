package crud.application.services;

import crud.application.entities.User;
import crud.application.repositories.UserRepository;
import crud.application.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user == null) throw new ResourceNotFoundException(id);
        else repository.deleteById(id);
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public User update(User user, Integer id) {
        try {
            User oldUser = repository.getReferenceById(id);
            updateData(oldUser, user);
            return repository.save(oldUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User oldUser, User newUser) {
        newUser.setName(oldUser.getName());
        newUser.setEmail(oldUser.getEmail());
        newUser.setPassword(oldUser.getPassword());
        newUser.setPhone(oldUser.getPhone());
    }


}
