package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.repository.StatusDomainRepository;
import com.Vicio.Games.domain.repository.UserDomainRepository;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.persistence.entity.StatusEntity;
import com.Vicio.Games.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    private UserDomainRepository userDomainRepository;

    @Autowired
    private StatusDomainRepository statusDomainRepository;


    public void sendNotification(int usId, int stId) throws MailException {

        UserEntity user = userDomainRepository.findUserByID(usId)
                .orElseThrow(() -> new NotFound("User not found"));

        StatusEntity status = statusDomainRepository.findStatusById(stId)
                .orElseThrow(() -> new NotFound("Status not found"));


        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("viciogames.store@gmail.com");
        mail.setSubject("Purchase status notification");
        mail.setText("The purchase status is :" + status.getName() +
                "\n" +
                "\n Sincerly VicioGames Store");

        javaMailSender.send(mail);
    }

}
