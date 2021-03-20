package com.maxdev.graphqlwithspring.resolver.bank;

import com.maxdev.graphqlwithspring.domain.BankAccount;
import com.maxdev.graphqlwithspring.domain.Client;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    public Client client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());

        throw new GraphQLException("Client unavailable");
//        return Client.builder()
//                .id(UUID.randomUUID())
//                .firstName("Dave")
//                .lastName("Moon")
//                .build();
    }
}
