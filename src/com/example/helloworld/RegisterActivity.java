package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import inputcells.PictureInputCellFragment;
import inputcells.SimpleTextInputcellFragment;

public class RegisterActivity extends Activity {
	SimpleTextInputcellFragment fragInputCellAccount;
	SimpleTextInputcellFragment fragInputCellPassword;
	SimpleTextInputcellFragment fragInputCellPasswordRepeat;
	PictureInputCellFragment fragInputCellImage;
	
	
	protected void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		fragInputCellAccount=(SimpleTextInputcellFragment)getFragmentManager().findFragmentById(R.id.input_account);
		fragInputCellPassword=(SimpleTextInputcellFragment)getFragmentManager().findFragmentById(R.id.input_password);
		fragInputCellPasswordRepeat=(SimpleTextInputcellFragment)getFragmentManager().findFragmentById(R.id.input_password_repeat);
		fragInputCellImage=(PictureInputCellFragment)getFragmentManager().findFragmentById(R.id.input_img);
	}
	
	public void onResume(){
		super.onResume();
		fragInputCellAccount.setLabelText("”√ªß√˚");
		fragInputCellAccount.setHintText("«Î ‰»Î”√ªß√˚");
		fragInputCellPassword.setLabelText("√‹¬Î");
		fragInputCellPassword.setHintText("«Î ‰»Î√‹¬Î");
		fragInputCellPassword.setEditText(true);
		fragInputCellPasswordRepeat.setLabelText("÷ÿ∏¥√‹¬Î");
		fragInputCellPasswordRepeat.setHintText("«Î÷ÿ∏¥ ‰»Î√‹¬Î");
		fragInputCellPasswordRepeat.setEditText(true);
		fragInputCellImage.setLabelText("Õº∆¨");
		fragInputCellImage.setHintText("«Î—°‘ÒÕº∆¨");
	}
}
