package com.excercise.lesson2.service;

import com.excercise.lesson2.dto.UserDto;
import com.excercise.lesson2.entity.User;
import com.excercise.lesson2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        //dto'lar User listesinde tutulacak
        List<UserDto> dtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        //user listesini streame dönüştürüldü, her data dtoya dönüştürülerek dto listesine aktarıldı
        return dtos;
    }

    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        return null;
    }

    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> resultUser = userRepository.findById(id);
        if (resultUser.isPresent()) {
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            return modelMapper.map(userRepository.save(resultUser.get()), UserDto.class);
        }
        return null;

    }

    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}