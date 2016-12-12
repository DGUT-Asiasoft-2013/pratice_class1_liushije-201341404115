package com.example.helloworld;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import api.Server;
import api.entity.User;
import inputcells.SimpleTextInputcellFragment;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author 刘世杰 登陆Activity 分别就是定义了登陆界面各个点击事件
 */
public class LoginActivity extends Activity {
	SimpleTextInputcellFragment fragAccount, fragPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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

		fragAccount = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_account);
		fragPassword = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_password);
	}

	@Override
	protected void onResume() {
		super.onResume();

		fragAccount.setLabelText("账户名");
		fragAccount.setHintText("请输入账户名");
		fragPassword.setLabelText("密码");
		fragPassword.setHintText("请输入密码");
		fragPassword.setEditText(true);
	}

	void goRegister() {
		Intent itnt = new Intent(this, RegisterActivity.class);
		startActivity(itnt);
	}

	void goLogin() {
		OkHttpClient client = Server.getSharedClient();

		MultipartBody requestBody = new MultipartBody.Builder().addFormDataPart("account", fragAccount.getText())
				.addFormDataPart("passwordHash", MD5.getMD5(fragPassword.getText())).build();

		Request request = Server.requestBuilderWithApi("login").method("post", null).post(requestBody).build();

		final ProgressDialog dlg = new ProgressDialog(this);
		dlg.setCancelable(false);
		dlg.setCanceledOnTouchOutside(false);
		dlg.setMessage("正在登陆");
		dlg.show();

		client.newCall(request).enqueue(new Callback() {

			public void onResponse(Call arg0, Response arg1) throws IOException {

				final String responseString = arg1.body().string();
				ObjectMapper mapper = new ObjectMapper();
				final User user = mapper.readValue(responseString, User.class);

				runOnUiThread(new Runnable() {
					public void run() {
						dlg.dismiss();
						new AlertDialog.Builder(LoginActivity.this).setMessage("Hello," + user.getName())
								// .setMessage(responseString)
								.setPositiveButton("OK", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										Intent itnt = new Intent(LoginActivity.this, HelloWorldActivity.class);
										startActivity(itnt);
									}
								}).show();
					}
				});
			}

			public void onFailure(Call arg0, final IOException arg1) {
				runOnUiThread(new Runnable() {
					public void run() {
						dlg.dismiss();

						Toast.makeText(LoginActivity.this, arg1.getLocalizedMessage(), Toast.LENGTH_LONG).show();
					}
				});
			}
		});
	}

	void goRecoverPassword() {
		Intent itnt = new Intent(this, PasswordRecoverActivity.class);
		startActivity(itnt);
	}
}