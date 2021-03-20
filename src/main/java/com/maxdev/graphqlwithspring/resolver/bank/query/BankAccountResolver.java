package com.maxdev.graphqlwithspring.resolver.bank.query;

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

        return BankAccount.builder()
                .id(id)
                .currency(Currency.EUR)
                .build();
    }
}
