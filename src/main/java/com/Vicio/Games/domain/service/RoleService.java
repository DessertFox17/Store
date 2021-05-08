package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.ShowRoleDto;
import com.Vicio.Games.domain.repository.RoleDomainRepository;
import com.Vicio.Games.persistence.entity.RoleEntity;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDomainRepository roleDomainRepository;

    public ShowRoleDto getRoleById(int roId) throws NotFoundException {
        ModelMapper modelMapper = new ModelMapper();

        RoleEntity role = roleDomainRepository.getByRoleId(roId).orElse(null);

        if(role == null){
            throw new NotFoundException(String.format("The role with id: %s does not exist",roId));
        }
        return modelMapper.map(role,ShowRoleDto.class);
    }
}
