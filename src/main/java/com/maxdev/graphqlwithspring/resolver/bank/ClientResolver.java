package com.maxdev.graphqlwithspring.resolver.bank;

import com.maxdev.graphqlwithspring.domain.BankAccount;
import com.maxdev.graphqlwithspring.domain.Client;
import graphql.GraphQLException;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(
      Runtime.getRuntime().availableProcessors()
    );

    public CompletableFuture<Client> client(BankAccount bankAccount) {


        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Requesting client data for bank account id {}", bankAccount.getId());
                    return Client.builder()
                            .id(UUID.randomUUID())
                            .firstName("Dave")
                            .lastName("Moon")
                            .build();

                },
                executorService
        );
    }
}
