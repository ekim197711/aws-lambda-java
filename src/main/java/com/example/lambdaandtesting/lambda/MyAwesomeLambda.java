package com.example.lambdaandtesting.lambda;

import com.amazonaws.lambda.thirdparty.com.google.gson.Gson;
import com.amazonaws.lambda.thirdparty.com.google.gson.GsonBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class MyAwesomeLambda implements RequestHandler<Map<String,String>, SpaceShip>{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public SpaceShip handleRequest(Map<String,String> event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("EVENT: " + gson.toJson(event));
        logger.log("EVENT TYPE: " + event.getClass().toString());
        return new SpaceShip("round", "Mike", 77);
    }
}
