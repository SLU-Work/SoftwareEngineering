package com.slu.se_project.login;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Sean on 3/22/2017.
 */

public class reg_Contact {

    public String fName;
    public String lName;
    public String userName;
    public String email;
    public String pass;
    public Map<String, Object> properties = new HashMap<String, Object>();


    public reg_Contact(){super();}

    public void setName(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }

    public void setUserName(String userName, String email){
        this.userName = userName;
        this.email = email;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setContact(String fName, String lName, String userName, String email, String pass){
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.email = email;
        this.pass = pass;
    }

    public Map<String, Object>getBackUser(){
        ///implement error checking and just generally fix this shit show
        String name = fName + " " + lName;
        this.properties.put("email", email);
        this.properties.put("name", name);
        this.properties.put("password", pass);

        return properties;
    }
}
