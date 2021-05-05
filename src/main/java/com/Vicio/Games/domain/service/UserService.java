package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewUserDto;
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
        List<NewUserDto> users = new ArrayList<>();

        List<UserEntity> pUsers = userDomainRepository.findAllUsers();

        pUsers.forEach(userEntity -> users.add(modelMapper.map(userEntity, NewUserDto.class)));

        map.put("Users", users);

        return map;
    }

    public Map<String, Object> newUser(NewUserDto newUserDto) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = modelMapper.map(newUserDto, UserEntity.class);
        userDomainRepository.newUser(userEntity);

        map.put("Message", "User created succesfully");
        map.put("New User", newUserDto.getFirstName() + " " + newUserDto.getLastName());
        return map;
    }

    public Map<String, Object> updateUser(NewUserDto newUserDto, int uId) {

        Map<String, Object> map = new HashMap<>();
        UserEntity user = userDomainRepository.findUserByID(uId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"));

        user.setFirstName(newUserDto.getFirstName());
        user.setLastName(newUserDto.getLastName());
        user.setBirthDate(newUserDto.getBirthDate());
        user.setAddress(newUserDto.getAddress());
        user.setPhoneNumber(newUserDto.getPhoneNumber());


        userDomainRepository.updateUser(user);
        map.put("Message", "User updated succesfully");
        map.put("New User", newUserDto.getFirstName() + " " + newUserDto.getLastName());

        return map;
    }


    public Map<String, Object> findUserByID(int uId) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity pUser = userDomainRepository.findUserByID(uId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"+uId));

        NewUserDto user = modelMapper.map(pUser, NewUserDto.class);

        map.put("usId", user.getUsId());
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

    public Map<String, String> deleteUsers(int uId){

        Map<String, String> map = new HashMap<>();

        UserEntity pUser = userDomainRepository.findUserByID(uId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"+uId));

        userDomainRepository.deleteUser(uId);

        map.put("message", "User: "+ pUser.getFirstName()+" "+pUser.getLastName()+" deleted succesfully");
        return map;

    }

    public NewUserDto getByEmail(String mail) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity pUser = userDomainRepository.getByEmail(mail)
                .orElseThrow(() -> new NotFound("User doesn´t exist"));

        return modelMapper.map(pUser, NewUserDto.class);
    }
}
