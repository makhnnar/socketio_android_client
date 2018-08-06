package com.house.domotic.my.mylogintest.views.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.login.mvp.LoginContract;
import com.house.domotic.my.mylogintest.views.login.mvp.LoginPresenter;
import com.house.domotic.my.mylogintest.views.home.HomeActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View,View.OnClickListener {

    private EditText name;

    private EditText pass;

    private Button login;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.campo_name);
        pass = findViewById(R.id.campo_pass);
        login = findViewById(R.id.btn_login);
        login.setOnClickListener(this);
        name.setText("JUANCHO");
        pass.setText("1234");
        presenter = new LoginPresenter(this);
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getBaseContext(),"LOGIN EXITOSO",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(),"LOGIN FALLIDO",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.equals(login)){
            presenter.makeLogin(name.getText().toString(),pass.getText().toString());
        }
    }
}
