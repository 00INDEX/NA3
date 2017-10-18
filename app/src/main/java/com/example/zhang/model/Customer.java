package com.example.zhang.model;
import com.example.zhang.base.BaseCustomer;

/**
 * Created by 张硕 on 2017/10/17.
 */

public class Customer {
    // model columns
    public final static String COL_ID = "id";
    public final static String COL_SID = "sid";
    public final static String COL_NAME = "user";
    public final static String COL_PASS = "password";
    public final static String COL_SIGN = "sign";
    public final static String COL_FACE = "face";
    public final static String COL_FACEURL = "faceurl";

    private String id;
    private String sid;
    private String user;
    private String password;
    private String sign;
    private String face;
    private String faceurl;
    private String uptime;

    // default is no login
    private boolean isLogin = false;

    // single instance for login
    static private Customer customer = null;

    static public Customer getInstance () {
        if (Customer.customer == null) {
            Customer.customer = new Customer();
        }
        return Customer.customer;
    }

    public Customer () {}

    public String getId () {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getSid () {
        return this.sid;
    }

    public void setSid (String sid) {
        this.sid = sid;
    }

    public String getUser () {
        return this.user;
    }

    public void setUser (String user) {
        this.user = user;
    }

    public String getPass () {
        return this.password;
    }

    public void setPass (String pass) {
        this.password = pass;
    }

    public String getSign () {
        return this.sign;
    }

    public void setSign (String sign) {
        this.sign = sign;
    }

    public String getFace () {
        return this.face;
    }

    public void setFace (String face) {
        this.face = face;
    }

    public String getFaceurl () {
        return this.faceurl;
    }

    public void setFaceurl (String faceurl) {
        this.faceurl = faceurl;
    }

    public Boolean getLogin () {
        return this.isLogin;
    }

    public void setLogin (boolean isLogin) {
        this.isLogin = isLogin;
    }
}
