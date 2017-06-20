package com.asuscomm.yangyinetwork.dbexample.utils.consts;

import com.asuscomm.yangyinetwork.dbexample.services.network.KtIotMakerAuthService;
import com.asuscomm.yangyinetwork.dbexample.services.network.KtIotMakerService;

import java.util.HashMap;

/**
 * Created by jaeyoung on 2017. 6. 20..
 */

public class URL {
    public static HashMap<String, String> urls;
    static {
        urls = new HashMap<>();
        urls.put(KtIotMakerAuthService.class.getName(), "https://iotmakers.olleh.com/");
        urls.put(KtIotMakerService.class.getName(), "https://iotmakers.olleh.com:443/");
    }


}
