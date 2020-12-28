package com.example.lambdaandtesting.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.api.client.api.LambdaClientContext;
import com.amazonaws.services.lambda.runtime.api.client.api.LambdaCognitoIdentity;
import com.amazonaws.services.lambda.runtime.api.client.api.LambdaContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AwesomeLambdaProxyTest {

    @Test
    void handleRequest() {
        Context context = new LambdaContext(2134,
                1234l, UUID.randomUUID().toString(),
                "mygroup", "mylogStream"
                ,"myfunction"
                ,new LambdaCognitoIdentity(UUID.randomUUID().toString(), "1"),
                "1.0",
                "sadfasdf", new LambdaClientContext());

        LambdaProxyRequest request = LambdaProxyRequest.builder()
                .isBase64Encoded(false)
                .headers(new HashMap<>())
                .httpMethod("GET")
                .path("/asdsdf")
                .pathParameters(new HashMap<>())
                .queryStringParameters(new HashMap<>())
                .body("{}")
                .resource("")
                .context(context)
                .stageVariables(new HashMap<>())
                .build();

        LambdaProxyResponse lambdaProxyResponse = new AwesomeLambdaProxy().handleRequest(
                request, context);
        System.out.println(lambdaProxyResponse);
        assertNotNull(lambdaProxyResponse.getBody());
        assertNotNull(lambdaProxyResponse.getHeaders());
        assertNotNull(lambdaProxyResponse.getIsBase64Encoded());
        assertNotNull(lambdaProxyResponse.getStatusCode());
        assertNotNull(lambdaProxyResponse.getMultiValueHeaders());
    }
}