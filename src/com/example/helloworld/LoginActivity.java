package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * @author 刘世杰
 * 登陆Activity
 * 分别就是定义了登陆界面各个点击事件
 */
public class LoginActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		findViewById(R.id.bt_register).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				goRegister();
			}
		});
		findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				goLogin();
			}
		});
		findViewById(R.id.tx_forgot_password).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				goRecoverPassword();
			}
		});
	}
	
	//下面都是点击事件跳转到其他Activity中

	void goRegister() {
		Intent itnt = new Intent(this, RegisterActivity.class);
		startActivity(itnt);
	}
	void goLogin(){
		Intent itnt = new Intent(this,HelloWorldActivity.class);
		startActivity(itnt);
	}
	void goRecoverPassword(){
		Intent itnt = new Intent(this, PasswordRecoverActivity.class);
		startActivity(itnt);
	}
	
}
