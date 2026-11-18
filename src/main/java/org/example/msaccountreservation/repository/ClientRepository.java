package org.example.msaccountreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.msaccountreservation.entity.Client;

import java.util.UUID;


public interface ClientRepository extends JpaRepository<Client, UUID> {

}