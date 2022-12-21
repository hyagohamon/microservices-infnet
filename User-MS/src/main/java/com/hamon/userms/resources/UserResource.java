package com.hamon.userms.resources;

import com.hamon.userms.models.dto.UserDto;
import com.hamon.userms.models.entities.User;
import com.hamon.userms.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public void cadastrar(@RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userService.cadastrar(user);

    }

    @RequestMapping("/{id}")
    public UserDto buscarPorId(@PathVariable Long id) {
        User user = userService.findById(id);
        System.out.println(user);
        UserDto map = modelMapper.map(user, UserDto.class);
        return map;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        userService.deletar(id);
    }

    @GetMapping()
    public List<UserDto> listarTodos() {
        List<User> allUsers = userService.findAll();
        return Arrays.asList(modelMapper.map(allUsers, UserDto[].class));
    }

}
