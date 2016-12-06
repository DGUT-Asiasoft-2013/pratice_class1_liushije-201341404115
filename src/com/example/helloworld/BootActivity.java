package com.example.helloworld;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/**
 * @author 刘世杰
 * 一开始打开时弹出的界面,一秒延迟之后进入系统
 * (通常此处用于广告)
 */

public class BootActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boot);
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
//这一行有什么用吗?    ↓
			private int abcd = 0;
//                ↑			
			public void run(){
				BootActivity.this.startLoginActivity();
			}
		},1000);
	}
	void startLoginActivity(){
		Intent itnt = new Intent(this, LoginActivity.class);
		startActivity(itnt);
		finish();
	}
}
