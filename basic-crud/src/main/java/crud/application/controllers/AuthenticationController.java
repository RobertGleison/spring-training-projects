//package crud.application.controllers;
//
//import crud.application.entities.user.AuthenticationDTO;
//import crud.application.entities.user.RegisterDTO;
//import crud.application.entities.user.User;
//import crud.application.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//public class AuthenticationController {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    //Authenticate users and admins using an DTO. The password saved in db is encrypted by hash
//    public ResponseEntity login(@RequestBody AuthenticationDTO data){
//        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),data.password());
//        var auth = authenticationManager.authenticate(usernamePassword);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody RegisterDTO data){
//        if(repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
//        //Creating encrypted password for a new user
//        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
//        User user = new User(data.name(),data.email(),data.password(),data.role());
//        repository.save(user);
//        return ResponseEntity.ok().build();
//    }
//}
