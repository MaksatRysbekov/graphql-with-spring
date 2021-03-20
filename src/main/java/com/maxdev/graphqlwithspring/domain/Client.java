package com.maxdev.graphqlwithspring.domain;

import lombok.Builder;
import lombok.Setter;

import java.util.UUID;

@Setter
@Builder
public class Client {

    UUID id;
    String firstName;
    String lastName;
    @Setter
    Client client;
}
