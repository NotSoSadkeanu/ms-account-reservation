package org.example.msaccountreservation.repository;

import org.example.msaccountreservation.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}