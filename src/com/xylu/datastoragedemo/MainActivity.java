package com.xylu.datastoragedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button fileBtn;
	private Button preferencesBtn;
	private Button sqliteBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fileBtn = (Button)findViewById(R.id.datastorage_file_btn);
		preferencesBtn = (Button)findViewById(R.id.datastorage_sharedpreferences_btn);
		sqliteBtn = (Button)findViewById(R.id.datastorage_sqlite_btn);
		
		fileBtn.setOnClickListener(this);
		preferencesBtn.setOnClickListener(this);
		sqliteBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == fileBtn) {
			Intent fileIntent = new Intent(this, FileActivity.class);
			this.startActivity(fileIntent);
		} else if (v == preferencesBtn) {
			Intent preferencesIntent = new Intent(this, PreferencesActivity.class);
			this.startActivity(preferencesIntent);
		} else if (v == sqliteBtn) {
			Intent sqliteIntent = new Intent(this, SQLiteActivity.class);
			this.startActivity(sqliteIntent);
		}
	}
}
