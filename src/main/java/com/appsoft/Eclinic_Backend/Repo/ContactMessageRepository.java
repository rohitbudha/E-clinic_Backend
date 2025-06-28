package com.appsoft.Eclinic_Backend.Repo;


import com.appsoft.Eclinic_Backend.models.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
