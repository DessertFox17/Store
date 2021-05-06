package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.ShowRoleDto;
import com.Vicio.Games.domain.repository.RoleDomainRepository;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.persistence.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleDomainRepository roleDomainRepository;

    public ShowRoleDto getRoleById(int roId){
        ModelMapper modelMapper = new ModelMapper();

        RoleEntity role = roleDomainRepository.getByRoleId(roId).orElseThrow(() -> new NotFound("Role not found"));

        return modelMapper.map(role,ShowRoleDto.class);
    }
}
