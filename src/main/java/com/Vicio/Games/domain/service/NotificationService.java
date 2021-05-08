package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.repository.StatusDomainRepository;
import com.Vicio.Games.domain.repository.UserDomainRepository;
import com.Vicio.Games.persistence.entity.StatusEntity;
import com.Vicio.Games.persistence.entity.UserEntity;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        super();
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    private UserDomainRepository userDomainRepository;

    @Autowired
    private StatusDomainRepository statusDomainRepository;


    public void sendNotification(int usId, int stId) throws NotFoundException {

        UserEntity user = userDomainRepository.findUserByID(usId).orElse(null);

        if(user == null){
            throw new NotFoundException(String.format("The user with id: %s does not exist",usId));
        }

        StatusEntity status = statusDomainRepository.findStatusById(stId).orElse(null);

        if(status == null){
            throw new NotFoundException(String.format("The status with id: %s does not exist",stId));
        }

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
