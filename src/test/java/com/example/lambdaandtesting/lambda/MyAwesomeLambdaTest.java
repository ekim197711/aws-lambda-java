package com.example.lambdaandtesting.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.api.client.api.LambdaClientContext;
import com.amazonaws.services.lambda.runtime.api.client.api.LambdaCognitoIdentity;
import com.amazonaws.services.lambda.runtime.api.client.api.LambdaContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MyAwesomeLambdaTest {

    @Test
    void handleRequest() {
        MyAwesomeLambda myAwesomeLambda = new MyAwesomeLambda();
        HashMap<String, String> event = new HashMap<>();
        Context context = new LambdaContext(2134,
                1234l, UUID.randomUUID().toString(),
                "mygroup", "mylogStream"
                ,"myfunction"
                ,new LambdaCognitoIdentity(UUID.randomUUID().toString(), "1"),
                "1.0",
                "sadfasdf", new LambdaClientContext());

        SpaceShip spaceShip = myAwesomeLambda.handleRequest(event, context);
        System.out.println();
        System.out.println("Ship: " + spaceShip);

        Assertions.assertNotNull(myAwesomeLambda);
        Assertions.assertNotNull(spaceShip);
        Assertions.assertNotNull(spaceShip.getCaptain());
        Assertions.assertNotNull(spaceShip.getFuel());
        Assertions.assertNotNull(spaceShip.getModel());
    }
}