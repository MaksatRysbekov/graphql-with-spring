package com.maxdev.graphqlwithspring.resolver;

import com.maxdev.graphqlwithspring.domain.BankAccount;
import com.maxdev.graphqlwithspring.domain.Client;
import com.maxdev.graphqlwithspring.domain.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account with id: {}", id);

        var clientA = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Dave")
                .lastName("Someguy1")
                .build();

        var clientB = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Dave")
                .lastName("Someguy2")
                .build();

        clientA.setClient(clientB);
        clientB.setClient(clientA);

        return BankAccount.builder().id(id).currency(Currency.EUR).client(clientA).build();
    }
}
