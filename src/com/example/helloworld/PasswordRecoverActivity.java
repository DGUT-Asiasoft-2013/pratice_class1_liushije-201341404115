package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import fragments.PasswordRecoverStep1Fragment;
import fragments.PasswordRecoverStep1Fragment.OnGoNextListener;
import inputcells.SimpleTextInputcellFragment;
import fragments.PasswordRecoverStep2Fragment;
/**
 * @author 刘世杰
 * 忘记密码Activity
 */
public class PasswordRecoverActivity extends Activity {
	PasswordRecoverStep1Fragment step1 = new PasswordRecoverStep1Fragment();
	PasswordRecoverStep2Fragment step2 = new PasswordRecoverStep2Fragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_passwordrecover);
		step1.setOnGoNextListener(new OnGoNextListener() {

			@Override
			public void onGoNext() {
				goStep2();
			}
		});
		//此处将两个界面添加到一起????*************
		getFragmentManager().beginTransaction().replace(R.id.container, step1).commit();
	}
	void goStep2(){
		getFragmentManager()
		.beginTransaction()
		.replace(R.id.container, step2)
		.addToBackStack(null).commit();
	}
	
}
