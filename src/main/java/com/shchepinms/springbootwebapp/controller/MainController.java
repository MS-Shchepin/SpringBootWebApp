package com.shchepinms.springbootwebapp.controller;

import com.shchepinms.springbootwebapp.entity.Car;
import com.shchepinms.springbootwebapp.entity.User;
import com.shchepinms.springbootwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    private final UserService userService;

    public MainController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        System.out.println(users);
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/saveUser")
    public String saveUser(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        String name = request.getParameter("userName");
        String lastName = request.getParameter("userLastName");
        int age = 0;
        try {
            age = Integer.parseInt(request.getParameter("userAge"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String carModel = request.getParameter("userCarBrand");
        String carColor = request.getParameter("userCarColor");
        User user = new User(id == null ? 0 : id, name, lastName, age, new Car(carModel, carColor));
        userService.save(user);
        return "redirect:index";
    }

    @GetMapping(value = "/editor")
    public String showUserEditor(@RequestParam(value = "id", required = false) Long id, Model model) {
        System.out.println("/editor -> editor");
        if (id != null) {
            model.addAttribute("user", userService.getById(id));
        } else {
            model.addAttribute("user", new User("", "", 0, new Car("", "")));
        }
        return "editor";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam(value = "id", required = false) Long id) {
        if (id != null && id != 0) {
            userService.deleteById(id);
        }
        return "redirect:index";
    }
}
