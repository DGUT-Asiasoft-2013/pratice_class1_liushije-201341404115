package fragments;
import com.example.helloworld.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import inputcells.SimpleTextInputcellFragment;
/**
 * @author ������
 * ���������������ĵڶ�������
 * ���û������յ�����֤��,�����벢��������һ��
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
		fragver.setLabelText("��֤��");
		fragver.setHintText("�������յ�����֤��");
		fragpassword.setLabelText("������");
		fragpassword.setHintText("�������µ�����");
		fragpassword.setEditText(true);
		fragpassword_repeat.setLabelText("�ظ�������");
		fragpassword_repeat.setHintText("���ٴ������µ�����");
		fragpassword_repeat.setEditText(true);
	}
}
