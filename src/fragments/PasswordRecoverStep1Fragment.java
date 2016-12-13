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
 * 点击忘记密码的第一个界面
 * 让用户输入他注册此账号的邮箱,点击下一步则会发送验证码到邮箱中(还未实现)
 */
public class PasswordRecoverStep1Fragment extends Fragment {

	SimpleTextInputcellFragment fragEmail;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_password_recover_step1, null);
			fragEmail = (SimpleTextInputcellFragment) getFragmentManager().findFragmentById(R.id.input_email);
			view.findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					goNext();
				}
			});
		}
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		fragEmail.setLabelText("邮箱");
		fragEmail.setHintText("请输入邮箱");
	}

	public static interface OnGoNextListener {
		void onGoNext();
	}

	OnGoNextListener onGoNextListener;
	


	public void setOnGoNextListener(OnGoNextListener onGoNextListener) {
		this.onGoNextListener = onGoNextListener;
	}
	
	public String getText() {
		return fragEmail.getText();
}

	void goNext() {
		if (onGoNextListener != null) {
			onGoNextListener.onGoNext();
		}
	}
}
