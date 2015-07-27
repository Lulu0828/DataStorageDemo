package com.xylu.datastoragedemo;

import com.xylu.datastoragedemo.db.DBUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 *  
 *  使用SQLite存储数据
 *  
 */

public class SQLiteActivity extends Activity implements OnClickListener{

	private EditText inputDataEt;
	private Button writeBtn;
	private Button readBtn;
	private TextView outputDataTv;
	
	private DBUtil dbUtil = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datastorage);
		dbUtil = new DBUtil(this);
		
		inputDataEt = (EditText)findViewById(R.id.input_data_et);
		writeBtn = (Button)findViewById(R.id.write_btn);
		readBtn = (Button)findViewById(R.id.read_btn);
		outputDataTv = (TextView)findViewById(R.id.output_data_tv);
		
		writeBtn.setOnClickListener(this);
		readBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		if (v == writeBtn) {
			
			dbUtil.write(inputDataEt.getText().toString());
			Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
			
		} else if (v == readBtn) {
			
			outputDataTv.setText("从SQLite中读取数据：" + dbUtil.read());
			
		}
		
	}

}
