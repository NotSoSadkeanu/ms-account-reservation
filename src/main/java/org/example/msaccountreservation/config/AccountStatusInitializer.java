package org.example.msaccountreservation.config;

import org.example.msaccountreservation.entity.AccountStatus;
import org.example.msaccountreservation.repository.AccountStatusRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusInitializer implements ApplicationRunner {

    private final AccountStatusRepository accountStatusRepository;

    public AccountStatusInitializer(AccountStatusRepository accountStatusRepository) {
        this.accountStatusRepository = accountStatusRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (accountStatusRepository.findByName("NEW").isEmpty()) {
            accountStatusRepository.save(new AccountStatus("NEW", "Счёт создан в БД")
            );
        }
        if (accountStatusRepository.findByName("IN_CREATION").isEmpty()) {
            accountStatusRepository.save(new AccountStatus("IN_CREATION", "Запрос на создание счета был отправлен в смежную систему")
            );
        }
        if (accountStatusRepository.findByName("CREATED").isEmpty()) {
            accountStatusRepository.save(new AccountStatus("CREATED", "Счёт создан в смежной системе")
            );
        }
        if (accountStatusRepository.findByName("CANCELLED").isEmpty()) {
            accountStatusRepository.save(new AccountStatus("CANCELLED", "Счёт аннулирован")
            );
        }
        if (accountStatusRepository.findByName("CLOSED").isEmpty()) {
            accountStatusRepository.save(new AccountStatus("CLOSED", "Счёт закрыт")
            );
        }
    }
}