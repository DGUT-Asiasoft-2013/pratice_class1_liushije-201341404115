package com.example.helloworld;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/**
 * @author ������
 * һ��ʼ��ʱ�����Ľ���,һ���ӳ�֮�����ϵͳ
 * (ͨ���˴����ڹ��)
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
//��һ����ʲô����?    ��
			private int abcd = 0;
//                ��			
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
