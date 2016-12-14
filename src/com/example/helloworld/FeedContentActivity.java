package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author 刘世杰
 * 添加feed的ViewList点击事件Activity
 */

public class FeedContentActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_feed_content);
		
		String text = getIntent().getStringExtra("text");
		
		TextView textView = (TextView) findViewById(R.id.text);
		textView.setText(text);
	}
}
