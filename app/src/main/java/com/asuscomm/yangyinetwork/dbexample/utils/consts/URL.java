package com.asuscomm.yangyinetwork.dbexample.utils.consts;

import com.asuscomm.yangyinetwork.dbexample.utils.retrofit.KtIotMakerAuthService;
import com.asuscomm.yangyinetwork.dbexample.utils.retrofit.KtIotMakerOpenApiService;

import java.util.HashMap;

/**
 * Created by jaeyoung on 2017. 6. 20..
 */

public class URL {
    public static HashMap<String, String> urls;
    static {
        urls = new HashMap<>();
        urls.put(KtIotMakerAuthService.class.getName(), "https://iotmakers.olleh.com/");
        urls.put(KtIotMakerOpenApiService.class.getName(), "https://iotmakers.olleh.com:443/");
    }


}
