package com.example.zhang.na3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhang.base.BaseAuth;
import com.example.zhang.base.BaseMessage;
import com.example.zhang.base.BaseUI;
import com.example.zhang.base.Primer;
import com.example.zhang.model.Customer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2017/10/17.
 */

public class LoginActivity extends BaseUI{
    private EditText user_text;
    private EditText password_text;
    private Button sign_in;
    private Button sign_up;
    private SharedPreferences setting;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        user_text = (EditText) findViewById(R.id.user);
        password_text = (EditText) findViewById(R.id.password);
        sign_in = (Button) findViewById(R.id.sign_in_button);
        sign_up = (Button) findViewById(R.id.sign_up_button);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = user_text.getText().toString();
                String password = password_text.getText().toString();
                if(TextUtils.isEmpty(user)){
                    user_text.setError(getString(R.string.user_empty));
                }else if(TextUtils.isEmpty(password)){
                    password_text.setError(getString(R.string.password_empty));
                }else attempt_login_in(user,password);
            }});}
    public void attempt_login_in(String user,String password){
        HashMap<String,String> urlParams = new HashMap<String,String>();
        urlParams.put("user",user);
        urlParams.put("password",password);
        try{
            this.doTaskAsync(Primer.task.login,Primer.api.login,urlParams);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTaskComplete(int taskId,BaseMessage message){
        super.onTaskComplete(taskId,message);
        switch (taskId){
            case Primer.task.login:
                Customer customer = null;
                try{
                    customer = (Customer) message.getResult("Customer");
                    if(customer.getUser() != null){
                        BaseAuth.setCustomer(customer);
                        BaseAuth.setLogin(true);
                    }else{
                        BaseAuth.setCustomer(customer);
                        BaseAuth.setLogin(false);
                        toast(this.getString(R.string.password_error));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    toast(e.getMessage());
                }
                if(BaseAuth.isLogin()){
                    forward(MainActivity.class);
                }
        }
    }
}


