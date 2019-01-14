package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Project;
import pl.coderslab.model.Task;
import pl.coderslab.model.User;
import pl.coderslab.repository.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {




    @Autowired
    Validator validator;


    @Autowired
    private PriorityRepository priorityRepository;


    @Autowired
    private ProjectRepository projectRepository;


    @Autowired
    private StatusRepository statusRepository;


    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    private UserRepository userRepository;




    @ModelAttribute("projects")
    public List<Project> getProjects(){


        return projectRepository.findAll();

    }



    @ModelAttribute("tasks")
    public List<Task> getTasks(Long id){


        return taskRepository.findByUserId(id);

    }


    @ModelAttribute("users")
    public List<User> getUsers(){


        return userRepository.findAll();


    }




    @RequestMapping(value = "/users", produces = "text/html; charset=utf-8")
    public String viewBooks(Model model) {

        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);

        return "/user/users";



    }



    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model){

        model.addAttribute("user", new User());

        return "/user/addUser";



    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String saveBook(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {

            return "/user/addUser";

        }


        userRepository.save(user);

        return "redirect:/user/addUserTasks";



    }

















}