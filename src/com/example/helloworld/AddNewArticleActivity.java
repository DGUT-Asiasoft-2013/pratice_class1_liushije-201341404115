package com.example.helloworld;

import java.io.IOException;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import api.Server;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import inputcells.SimpleTextInputcellFragment;

public class AddNewArticleActivity extends Activity {
	SimpleTextInputcellFragment fragAddNewArticle = new SimpleTextInputcellFragment();
	Button btn_send;
	EditText input_main_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_page_sentmessage);
		input_main_text = (EditText) findViewById(R.id.input_main_text);
		btn_send = (Button) findViewById(R.id.btn_send);
		btn_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				submit();
				// finish();
				overridePendingTransition(R.anim.none, R.anim.slide_out_bottom);
			}
		});
		fragAddNewArticle = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_add);
	}

	@Override
	protected void onResume() {
		super.onResume();
		fragAddNewArticle.setLabelText("推送文字");
		fragAddNewArticle.setHintText("请输入推送文字");

	}

	void submit() {
		String title = fragAddNewArticle.getText();
		String text = input_main_text.getText().toString();
		OkHttpClient client = Server.getSharedClient();
		// new OkHttpClient();

		MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder().addFormDataPart("title", title)
				.addFormDataPart("text", text);

		Request request = Server.requestBuilderWithApi("article").method("post", null).post(requestBodyBuilder.build())
				.build();

		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(final Call arg0, final Response arg1) throws IOException {
				runOnUiThread(new Runnable() {
					public void run() {
					}
				});
			}

			@Override
			public void onFailure(final Call arg0, final IOException arg1) {
				runOnUiThread(new Runnable() {
					public void run() {
					}
				});
			}
		});

	}
}