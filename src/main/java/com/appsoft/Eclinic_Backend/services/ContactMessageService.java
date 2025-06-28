package com.appsoft.Eclinic_Backend.services;

import com.appsoft.Eclinic_Backend.Repo.ContactMessageRepository;
import com.appsoft.Eclinic_Backend.models.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    public void saveMessage(ContactMessage message) {
        repository.save(message);
    }
}
