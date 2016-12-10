package page;

import com.example.helloworld.FeedContentActivity;
import com.example.helloworld.R;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FeedListFragment extends Fragment {
	View view;
	ListView listView;
	String[] arrays;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_page_feed_list, null);
			listView = (ListView) view.findViewById(R.id.list);
			initList();
			listView.setAdapter(listAdapter);
			
			
			listView.setOnItemClickListener(new OnItemClickListener() {
				
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

					onItemSelected(position);
				}
			});
		}

		return view;
	}
	private void onItemSelected(int position){
		String text = arrays [position];
		Intent intent = new Intent(getActivity(),FeedContentActivity.class);
		intent.putExtra("text", text);
		startActivity(intent);
	}
	
	private void initList(){
		arrays = new String[] {"��һ","�Ŷ�","����","����","����","����",
				"����","�Ű�","�ž�","��ʮ","��һ",
				"�ƶ�","����","����","����","����",
				"�Ż�","��ʮ","�ƾ�","�ư�","����",};
	}

	// ���������
	BaseAdapter listAdapter = new BaseAdapter() {

		@SuppressLint("InflateParams")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;

			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater.from(parent.getContext());
				view = inflater.inflate(android.R.layout.simple_list_item_1, null);
			} else {
				view = convertView;
			}

			TextView text1 = (TextView) view.findViewById(android.R.id.text1);
			text1.setText("Name:" + arrays[position]);

			return view;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return arrays[position];
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrays.length;
		}
	};
}
