package com.synectiks.asset.handler;

import com.synectiks.asset.AssetserviceApp;
import com.synectiks.asset.config.Constants;
import com.synectiks.asset.handler.aws.AppConfigHandler;
import com.synectiks.asset.handler.aws.EksHandler;
import com.synectiks.asset.handler.aws.LambdaHandler;

public class AwsHandlerFactory {
    public static CloudHandler getHandler(String elementType){
        if(Constants.APP_CONFIG_SUMMARY.equalsIgnoreCase(elementType)){
            return AssetserviceApp.getBean(AppConfigHandler.class);
        }
        if(Constants.LAMBDA.equalsIgnoreCase(elementType)){
            return AssetserviceApp.getBean(LambdaHandler.class);
        }
        if(Constants.EKS.equalsIgnoreCase(elementType)){
            return AssetserviceApp.getBean(EksHandler.class);
        }
        return null;
    }
}
