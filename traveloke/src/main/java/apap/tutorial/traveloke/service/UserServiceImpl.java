package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUserbyUsername(String username) {
        return userDb.findByUsername(username);
    }

    @Override
    public boolean passwordMatch(String baru, String lama) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(baru, lama);
    }

    @Override
    public boolean passwordValid(String password) {

        // password harus ada angka
        boolean adaAngka = password.matches(".*[0-9]+.*");

        // password harus ada huruf
        boolean adaHuruf = password.matches(".*[a-zA-Z]+.*");

        // password harus minimal 8
        boolean minDelapan = password.length() > 7;

        return  adaAngka && adaHuruf && minDelapan;
    }
}