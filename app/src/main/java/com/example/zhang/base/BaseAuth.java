package com.example.zhang.base;
import com.example.zhang.model.Customer;

/**
 * Created by 张硕 on 2017/10/17.
 */

public class BaseAuth {
    static public boolean isLogin () {
        Customer customer = Customer.getInstance();
        if (customer.getLogin() == true) {
            return true;
        }
        return false;
    }
    static public void setLogin (Boolean status) {
        Customer customer = Customer.getInstance();
        customer.setLogin(status);
    }
    static public void setCustomer (Customer mc) {
        Customer customer = Customer.getInstance();
        customer.setId(mc.getId());
        customer.setSid(mc.getSid());
        customer.setUser(mc.getUser());
        customer.setSign(mc.getSign());
        customer.setFace(mc.getFace());
    }
    static public Customer getCustomer () {
        return Customer.getInstance();
    }
}
