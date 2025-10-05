package com.example.loginandprofile;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName, etPassword;
    private Button btn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etPassword = (EditText) findViewById(R.id.inputPassword);
        etUserName = (EditText) findViewById(R.id.inputUserName);
        btn_Login = (Button) findViewById(R.id.btn_Login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btn_Login.setOnClickListener(v->{
            String userName = etUserName.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            if(userName.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"Vui lòng nhập tài khoản và mật khẩu",Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            intent.putExtra("username",userName);
            intent.putExtra("password",password);
            startActivity(intent);
        });
    }
}