package com.example.helloworld;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import api.entity.Server;
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
		String account = fragAccount.getText();
		String password = fragPassword.getText();
		password = MD5.getMD5(password);

		OkHttpClient client = Server.getSharedClient();
		MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder().addFormDataPart("account", account)
				.addFormDataPart("passwordHash", password);

		Request request = Server.requestBuilderWithApi("login").method("post", null).post(requestBodyBuilder.build())
				.build();

		final ProgressDialog dlg = new ProgressDialog(this);
		dlg.setCancelable(false);
		dlg.setCanceledOnTouchOutside(false);
		dlg.setMessage("正在登陆");
		dlg.show();

		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(final Call arg0, final Response arg1) throws IOException {
				try {
					ObjectMapper mapper = new ObjectMapper();
					String response=arg1.body().string();
					final User user = mapper.readValue(response, User.class);
					runOnUiThread(new Runnable() {
						public void run() {

							dlg.dismiss();

							LoginActivity.this.onResponse(arg0, user.getAccount());

						}
					});
				} catch (final IOException e) {
					e.printStackTrace();
					runOnUiThread(new Runnable() {
						public void run() {
							LoginActivity.this.onFailture(arg0, e);
						}
					});
				}
			}

			@Override
			public void onFailure(Call arg0, IOException arg1) {
				dlg.dismiss();
				onFailture(arg0, arg1);
			}
		});
	}

	void goRecoverPassword() {
		Intent itnt = new Intent(this, PasswordRecoverActivity.class);
		startActivity(itnt);
	}

	void onResponse(Call arg0, String responseBody) {
		new AlertDialog.Builder(this).setTitle("登陆成功").setMessage(responseBody)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Intent itnt = new Intent(LoginActivity.this, HelloWorldActivity.class);
						startActivity(itnt);
						finish();
					}
				}).show();
	}

	void onFailture(Call arg0, Exception arg1) {
		new AlertDialog.Builder(this).setTitle("登陆失败").setMessage(arg1.getLocalizedMessage())
				.setNegativeButton("OK", null).show();
	}

}