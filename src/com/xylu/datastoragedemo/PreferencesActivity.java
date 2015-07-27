package com.xylu.datastoragedemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 *  
 *  使用SharedPreferences存储数据
 *  
 */

public class PreferencesActivity extends Activity implements OnClickListener{

	private EditText inputDataEt;
	private Button writeBtn;
	private Button readBtn;
	private TextView outputDataTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datastorage);
		
		inputDataEt = (EditText)findViewById(R.id.input_data_et);
		writeBtn = (Button)findViewById(R.id.write_btn);
		readBtn = (Button)findViewById(R.id.read_btn);
		outputDataTv = (TextView)findViewById(R.id.output_data_tv);
		
		writeBtn.setOnClickListener(this);
		readBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == writeBtn) {
			
			String data = inputDataEt.getText().toString();
			SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("test", Context.MODE_PRIVATE);
			Editor editor = sharedPreferences.edit();
			editor.putString("data", data);
			editor.commit();
			Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
			
		} else if (v == readBtn) {
			
			SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("test", Context.MODE_PRIVATE);
			outputDataTv.setText("从SharedPreferences中读取数据：" + sharedPreferences.getString("data", ""));
			
		}
	}

}
