package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        // Mengecek apakah password yang diberikan sesuai dengan ketentuan
        boolean valid = userService.passwordValid(user.getPassword());
        if( valid == true){
            userService.addUser(user);
            model.addAttribute("user", user);
            model.addAttribute("mes", "User berhasil ditambahkan!");
        }else{
            model.addAttribute("user", user);
            model.addAttribute("mes", "Password harus ada angka dan huruf serta minimal 8 karakter!");
            return "home";
        }
        return "add-user";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePassword(@ModelAttribute
                                 UserModel user,
                                 String lama,
                                 String baru,
                                 String confirmed,
                                 Model model)
    {
        UserModel usr = userService.getUserbyUsername(user.getUsername());
        String usr1 = usr.getPassword();

        // Mengecek apakah password yang diberikan sama dengan yang di database
        if (userService.passwordMatch(lama, usr1)){
            // Mengecek apakah password baru yang diberikan sama
            if (baru.equals(confirmed)){
                // Mengecek apakah password sesuai dengan ketentuan
                boolean sama = userService.passwordValid(baru);
                if(sama == true){
                    // Set password baru
                    usr.setPassword(baru);
                    userService.addUser(usr);
                    model.addAttribute("msg", "Password berhasil diubah!");
                }else{
                    model.addAttribute("msg", "Password harus ada angka dan huruf serta minimal 8 karakter!");
                }
            }else {
                model.addAttribute("msg", "Password berbeda!");
            }
        }else {
            model.addAttribute("msg", "Password salah!");
        }
        return "update-password";
    }
}
