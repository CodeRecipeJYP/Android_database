package com.asuscomm.yangyinetwork.dbexample.models.dto;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by jaeyoung on 2017. 6. 20..
 */

public class Stream {
    String svcCode;
    String svcTgtSeq;
    String groupTagCd;
    String spotDevSeq;
    Date occDt;
    HashMap<String, Object> attributes;

    @Override
    public String toString() {
        return "Stream{" +
                "attributes=" + attributes +
                '}';
    }
}
