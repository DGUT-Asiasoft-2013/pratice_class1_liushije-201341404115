package fragments;
import com.example.helloworld.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import inputcells.SimpleTextInputcellFragment;
/**
 * @author 刘世杰
 * 点击忘记密码后进入的第二个界面
 * 让用户输入收到的验证码,新密码并且再输入一遍
 */
public class PasswordRecoverStep2Fragment extends Fragment {
	View view;

	SimpleTextInputcellFragment fragver;
	SimpleTextInputcellFragment fragpassword;
	SimpleTextInputcellFragment fragpassword_repeat;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		if (view == null) {
			view = inflater.inflate(R.layout.fragment_password_recover_step2, null);
			fragver = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_ver);
			fragpassword = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_password);
			fragpassword_repeat = (SimpleTextInputcellFragment) getFragmentManager()
					.findFragmentById(R.id.input_password_repeat);
		}
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		fragver.setLabelText("验证码");
		fragver.setHintText("请输入收到的验证码");
		fragpassword.setLabelText("新密码");
		fragpassword.setHintText("请输入新的密码");
		fragpassword.setEditText(true);
		fragpassword_repeat.setLabelText("重复新密码");
		fragpassword_repeat.setHintText("请再次输入新的密码");
		fragpassword_repeat.setEditText(true);
	}
}
