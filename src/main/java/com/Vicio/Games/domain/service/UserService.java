package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.UserDto;
import com.Vicio.Games.domain.repository.UserDomainRepository;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.persistence.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserDomainRepository userDomainRepository;


    public Map<String, Object> findAllUSers() {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        List<UserDto> users = new ArrayList<>();

        List<UserEntity> pUsers = userDomainRepository.findAllUSers();

        pUsers.forEach(userEntity -> users.add(modelMapper.map(userEntity, UserDto.class)));

        map.put("Users", users);

        return map;
    }

    public Map<String, Object> newUser(UserDto userDto) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userDomainRepository.newUser(userEntity);

        map.put("Message", "User created succesfully");
        map.put("New User", userDto.getFirstName() + " " + userDto.getLastName());
        return map;
    }

    public Map<String, Object> updateUser(UserDto userDto, int id) {

        Map<String, Object> map = new HashMap<>();
        UserEntity user = userDomainRepository.findUserByID(id)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"+id));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());


        userDomainRepository.updateUser(user);
        map.put("Message", "User updated succesfully");
        map.put("New User", userDto.getFirstName() + " " + userDto.getLastName());

        return map;
    }


    public Map<String, Object> findUserByID(int uId) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity pUser = userDomainRepository.findUserByID(uId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"+uId));

        UserDto user = modelMapper.map(pUser, UserDto.class);

        map.put("uId", user.getUId());
        map.put("firstName", user.getFirstName());
        map.put("lastName", user.getLastName());
        map.put("idNumber", user.getIdNumber());
        map.put("idType", user.getIdType());
        map.put("birthDate", user.getBirthDate());
        map.put("address", user.getAddress());
        map.put("phoneNumber", user.getPhoneNumber());
        map.put("email", user.getEmail());

        return map;
    }

}
