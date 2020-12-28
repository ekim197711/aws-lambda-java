package com.example.lambdaandtesting.lambda;

import com.amazonaws.lambda.thirdparty.com.google.gson.Gson;
import com.amazonaws.lambda.thirdparty.com.google.gson.GsonBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class AwesomeLambdaProxy implements RequestHandler<LambdaProxyRequest, LambdaProxyResponse> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public LambdaProxyResponse handleRequest(LambdaProxyRequest event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        logger.log("My lambda BEGIN");
        // log execution details
//        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("EVENT: " + gson.toJson(event));
        logger.log("EVENT TYPE: " + event.getClass().toString());
        SpaceShip spaceShip = new SpaceShip("pyramid", "Mike", 55);
        HashMap<String, Object> myheadermap = new HashMap<>();
        myheadermap.put("GreetingFromMike", "tuuttelluuuj helloooo hi hi hi123");
        logger.log("My lambda END");
        return LambdaProxyResponse.builder()
                .statusCode(200)
                .isBase64Encoded(false)
                .multiValueHeaders(new HashMap<>())
                .headers(myheadermap)
                .body(gson.toJson(spaceShip))
                .build();

    }
}
