package com.example.helloworld;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import api.entity.Server;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import fragments.PasswordRecoverStep1Fragment;
import fragments.PasswordRecoverStep1Fragment.OnGoNextListener;
import inputcells.SimpleTextInputcellFragment;
import fragments.PasswordRecoverStep2Fragment;
import fragments.PasswordRecoverStep2Fragment.OnSubmitClickedListener;

/**
 * @author 刘世杰 忘记密码Activity
 */
public class PasswordRecoverActivity extends Activity {

	PasswordRecoverStep1Fragment fragStep1 = new PasswordRecoverStep1Fragment();
	PasswordRecoverStep2Fragment fragStep2 = new PasswordRecoverStep2Fragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_passwordrecover);
		fragStep1.setOnGoNextListener(new OnGoNextListener() {

			@Override
			public void onGoNext() {
				goStep2();
			}
		});

		fragStep2.setOnSubmitClickeedListener(new OnSubmitClickedListener() {

			@Override
			public void onSubmitClicked() {
				goSubmit();
			}
		});
		getFragmentManager().beginTransaction().replace(R.id.container, fragStep1).commit();
	}

	/**
	 * 跳转到密码找回第二步页面 添加页面切换动画效果
	 */
	void goStep2() {

		getFragmentManager()
				.beginTransaction().setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_right,
						R.animator.slide_in_left, R.animator.slide_out_left)
				.replace(R.id.container, fragStep2).addToBackStack(null).commit();
	}

	void goSubmit() {
		OkHttpClient client = Server.getSharedClient();
		MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().addFormDataPart("email", fragStep1.getText())
				.addFormDataPart("passwordHash", MD5.getMD5(fragStep2.getText()));

		Request request = Server.requestBuilderWithApi("passwordrecover").method("post", null).post(bodyBuilder.build())
				.build();

		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(final Call arg0, final Response arg1) throws IOException {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						try {
							PasswordRecoverActivity.this.onResponse(arg0, arg1.body().string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}

			@Override
			public void onFailure(final Call arg0, final IOException arg1) {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						onFailure(arg0, arg1);
					}
				});
			}
		});
	}

	void onResponse(Call arg0, String responseBody) {
		new AlertDialog.Builder(this).setTitle("修改成功").setMessage(responseBody)
				.setPositiveButton("OK", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				}).show();
	}

	void onFailure(Call arg0, Exception e) {
		new AlertDialog.Builder(this).setTitle("修改失败").setMessage(e.getLocalizedMessage())
				.setPositiveButton("OK", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				}).show();
	}
}