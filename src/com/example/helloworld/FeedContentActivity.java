package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 
 * @author 刘世杰
 * 添加feed的ViewList点击事件Activity
 */

public class FeedContentActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String text = getIntent().getStringExtra("text");
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}
