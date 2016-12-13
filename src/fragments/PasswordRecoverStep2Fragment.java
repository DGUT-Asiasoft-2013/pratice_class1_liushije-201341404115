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
 * @author ������ ���������������ĵڶ������� ���û������յ�����֤��,�����벢��������һ��
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
		fragver.setLabelText("��֤��");
		fragver.setHintText("�������յ�����֤��");
		fragNewpassword.setLabelText("������");
		fragNewpassword.setHintText("�������µ�����");
		fragNewpassword.setEditText(true);
		fragNewpassword_repeat.setLabelText("�ظ�������");
		fragNewpassword_repeat.setHintText("���ٴ������µ�����");
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
			Toast.makeText(getActivity(), "�ظ����벻һ��", Toast.LENGTH_LONG).show();
		}else{
			onSubmitClickeedListener.onSubmitClicked();
		}
	}

}
