package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
/**
 * @author 刘世杰
 * HelloWorld Activity
 * 点击登陆后弹出的一个界面,并没有什么卵用----应该后面要做什么这个就改成什么吧
 */
public class HelloWorldActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_helloworld);
		
	}
}
