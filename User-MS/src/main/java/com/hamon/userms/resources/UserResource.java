package com.hamon.userms.resources;

import com.hamon.userms.models.dto.UserDto;
import com.hamon.userms.models.entities.User;
import com.hamon.userms.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserDto findById(@PathVariable Long id) {
        User user = userService.findById(id);
        System.out.println(user);
        UserDto map = modelMapper.map(user, UserDto.class);
        return map;
    }
}
