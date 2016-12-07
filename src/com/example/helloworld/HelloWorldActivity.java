package com.example.helloworld;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import fragments.MainTabbarFragment;
import fragments.MainTabbarFragment.OnTabSelectedListener;
import page.FeedListFragment;
import page.MyProfileFragment;
import page.NoteListFragment;
import page.SearchPageFragment;

/**
 * @author 刘世杰 HelloWorld Activity 点击登陆后弹出的一个界面,并没有什么卵用----应该后面要做什么这个就改成什么吧
 */
public class HelloWorldActivity extends Activity {
	FeedListFragment contentFeedList = new FeedListFragment();
	NoteListFragment contentNoteList = new NoteListFragment();
	SearchPageFragment contentSearchPage = new SearchPageFragment();
	MyProfileFragment contentMyProfile = new MyProfileFragment();

	MainTabbarFragment tabbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_helloworld);

		tabbar = (MainTabbarFragment) getFragmentManager().findFragmentById(R.id.frag_tabbar);
		tabbar.setOnTabSelectedListener(new OnTabSelectedListener() {

			@Override
			public void onTabSelected(int index) {
				changeContentFragment(index);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();

		tabbar.setSelectedItem(0);
	}

	void changeContentFragment(int index) {
		Fragment newFrag = null;

		switch (index) {
		case 0:
			newFrag = contentFeedList;
			break;
		case 1:
			newFrag = contentNoteList;
			break;
		case 2:
			newFrag = contentSearchPage;
			break;
		case 3:
			newFrag = contentMyProfile;
			break;

		default:
			break;
		}

		if (newFrag == null)
			return;

		getFragmentManager().beginTransaction().replace(R.id.content, newFrag).commit();
	}
}
