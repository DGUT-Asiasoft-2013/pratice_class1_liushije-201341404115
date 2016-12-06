package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import inputcells.PictureInputCellFragment;
import inputcells.SimpleTextInputcellFragment;
/**
 * @author ������
 * ע��Activity
 */
public class RegisterActivity extends Activity {
	SimpleTextInputcellFragment fragInputCellAccount;
	SimpleTextInputcellFragment fragInputCellPassword;
	SimpleTextInputcellFragment fragInputCellPasswordRepeat;
	PictureInputCellFragment fragInputCellImage;
	SimpleTextInputcellFragment fragInputCellEmail;
	
	
	protected void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		fragInputCellAccount=(SimpleTextInputcellFragment)getFragmentManager().findFragmentById(R.id.input_account);
		fragInputCellPassword=(SimpleTextInputcellFragment)getFragmentManager().findFragmentById(R.id.input_password);
		fragInputCellPasswordRepeat=(SimpleTextInputcellFragment)getFragmentManager().findFragmentById(R.id.input_password_repeat);
		fragInputCellEmail=(SimpleTextInputcellFragment)getFragmentManager().findFragmentById(R.id.input_email);
		fragInputCellImage=(PictureInputCellFragment)getFragmentManager().findFragmentById(R.id.input_img);
	}
	
	public void onResume(){
		super.onResume();
		fragInputCellAccount.setLabelText("�û���");
		fragInputCellAccount.setHintText("�������û���");
		fragInputCellPassword.setLabelText("����");
		fragInputCellPassword.setHintText("����������");
		fragInputCellPassword.setEditText(true);
		fragInputCellPasswordRepeat.setLabelText("�ظ�����");
		fragInputCellPasswordRepeat.setHintText("���ظ���������");
		fragInputCellPasswordRepeat.setEditText(true);
		fragInputCellEmail.setLabelText("����");
		fragInputCellEmail.setHintText("����������");
		fragInputCellImage.setLabelText("ͼƬ");
		fragInputCellImage.setHintText("��ѡ��ͼƬ");
	}
}
