package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);

    UserModel getUserbyUsername(String username);

    // method untuk mengecek password sama dengan yang ada di database
    boolean passwordMatch(String baru, String lama);

    // method untuk mengecek password sesuai dengan ketentuan
    boolean passwordValid(String password);
}