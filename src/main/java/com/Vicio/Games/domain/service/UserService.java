package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewUserDto;
import com.Vicio.Games.domain.dto.UpdateUserDto;
import com.Vicio.Games.domain.repository.UserDomainRepository;
import com.Vicio.Games.exceptions.BadRequest;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.exceptions.Unauthorized;
import com.Vicio.Games.persistence.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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

    public Map<String, Object> newUser(NewUserDto newUserDto, BindingResult bindingResult) throws BadRequest {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        if(bindingResult.hasErrors()){
            throw new BadRequest("Mandatory fields are incomplete");
        }

        UserEntity userEntity = modelMapper.map(newUserDto, UserEntity.class);
        userEntity.setRoId(3);
        userDomainRepository.newUser(userEntity);

        map.put("Message", "User created succesfully");
        map.put("New User", newUserDto.getFirstName() + " " + newUserDto.getLastName());
        return map;
    }

    public Map<String, Object> updateUser(UpdateUserDto userPayload, int uId, BindingResult bindingResult) throws BadRequest {

        Map<String, Object> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            throw new BadRequest("Mandatory fields are incomplete");
        }
        UserEntity user = userDomainRepository.findUserByID(uId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"));

        user.setFirstName(userPayload.getFirstName());
        user.setLastName(userPayload.getLastName());
        user.setBirthDate(userPayload.getBirthDate());
        user.setAddress(userPayload.getAddress());
        user.setPhoneNumber(userPayload.getPhoneNumber());


        userDomainRepository.updateUser(user);
        map.put("Message", "User updated succesfully");
        map.put("New User", userPayload.getFirstName() + " " + userPayload.getLastName());

        return map;
    }


    public Map<String, Object> findUserByID(int uId) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity pUser = userDomainRepository.findUserByID(uId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"));

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
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id"));

        userDomainRepository.deleteUser(uId);

        map.put("message", "User: "+ pUser.getFirstName()+" "+pUser.getLastName()+" deleted succesfully");
        return map;

    }

    public NewUserDto getByEmail(String mail) throws Unauthorized {

        ModelMapper modelMapper = new ModelMapper();

        UserEntity pUser = userDomainRepository.getByEmail(mail)
                .orElseThrow(() -> new Unauthorized(""));

        return modelMapper.map(pUser, NewUserDto.class);
    }
}
