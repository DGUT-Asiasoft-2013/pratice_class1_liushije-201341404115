package fragments;

import com.example.helloworld.R;
import com.example.helloworld.RegisterActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.view.ViewGroup;
import inputcells.SimpleTextInputcellFragment;

/**
 * @author 刘世杰 点击忘记密码后进入的第二个界面 让用户输入收到的验证码,新密码并且再输入一遍
 */
public class PasswordRecoverStep2Fragment extends Fragment {
	View view;

	SimpleTextInputcellFragment fragver;
	SimpleTextInputcellFragment fragNewpassword;
	SimpleTextInputcellFragment fragNewpassword_repeat;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		if (view == null) {
			view = inflater.inflate(R.layout.fragment_password_recover_step2, null);
			fragver = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_ver);
			fragNewpassword = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_password);
			fragNewpassword_repeat = (SimpleTextInputcellFragment) getFragmentManager()
					.findFragmentById(R.id.input_password_repeat);
			view.findViewById(R.id.sumbit).setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					onSubmitClicked();
				}
			});
		}
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		fragver.setLabelText("验证码");
		fragver.setHintText("请输入收到的验证码");
		fragNewpassword.setLabelText("新密码");
		fragNewpassword.setHintText("请输入新的密码");
		fragNewpassword.setEditText(true);
		fragNewpassword_repeat.setLabelText("重复新密码");
		fragNewpassword_repeat.setHintText("请再次输入新的密码");
		fragNewpassword_repeat.setEditText(true);
	}

	public String getText() {
		return fragNewpassword.getText();
		
	}

	public static interface OnSubmitClickedListener {
		void onSubmitClicked();
	};

	OnSubmitClickedListener onSubmitClickeedListener;

	public void setOnSubmitClickeedListener(OnSubmitClickedListener onSubmitClickeedListener) {
		this.onSubmitClickeedListener = onSubmitClickeedListener;
	}

	void onSubmitClicked() {
		
		if (!fragNewpassword.getText().equals(fragNewpassword_repeat.getText())) {
			Toast.makeText(getActivity(), "重复密码不一致", Toast.LENGTH_LONG).show();
		}else{
			onSubmitClickeedListener.onSubmitClicked();
		}
	}

}
