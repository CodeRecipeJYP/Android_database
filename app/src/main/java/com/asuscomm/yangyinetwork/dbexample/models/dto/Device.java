package com.asuscomm.yangyinetwork.dbexample.models.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 6. 20..
 */

public class Device {
    long sequence;
    String id;
    String name;
    String description;
    boolean used;
    boolean published;
    String status;
    String firmwareVersion;
    String authenticationType;
    String authenticationId;
    String authenticationKey;
    String connectionId;
    String connectionType;
    String creator;
    long createdOn;
    long modifiedOn;
    Target target;
    class Target {
        String districtCode;
        String themeCode;
        String serviceCode;
        long sequence;
        String name;
    }
    Model model;
    class Model {
        long sequence;
        String id;
        String name;
        String type;
        String protocolType;
        String bindingType;
    }

    List<Category> categories;
    class Category {
        String code;
    }
    List<SensingTag> sensingTags;
    class SensingTag {
        String code;
        double value;
        long updatedOn;
    }

    @Override
    public String toString() {
        return "Device{" +
                "sequence=" + sequence +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", used=" + used +
                ", published=" + published +
                ", status='" + status + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                ", authenticationType='" + authenticationType + '\'' +
                ", authenticationId='" + authenticationId + '\'' +
                ", authenticationKey='" + authenticationKey + '\'' +
                ", connectionId='" + connectionId + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", creator='" + creator + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", target=" + target +
                ", model=" + model +
                ", categories=" + categories +
                ", sensingTags=" + sensingTags +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
