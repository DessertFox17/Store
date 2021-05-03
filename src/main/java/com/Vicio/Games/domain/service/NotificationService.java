package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.repository.UserDomainRepository;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserDomainRepository userDomainRepository;


    public void sendNotification(int usId) {

        UserEntity userEntity = userDomainRepository.findUserByID(usId)
                .orElseThrow(() -> new NotFound("User not found"));

        SimpleMailMessage mail = new SimpleMailMessage();


        mail.setTo(userEntity.getEmail());
        mail.setFrom("viciogames.store@gmail.com");



    }

}
