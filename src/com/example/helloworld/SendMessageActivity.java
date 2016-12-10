package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import inputcells.SimpleTextInputcellFragment;

public class SendMessageActivity extends Activity {

	// SimpleTextInputcellFragment frgsent;

	@Override

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_page_sentmessage);

		findViewById(R.id.bt_sent).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
