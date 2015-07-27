package com.xylu.datastoragedemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 *  
 *  使用File存储数据
 *  
 */

public class FileActivity extends Activity implements OnClickListener{

	private EditText inputDataEt;
	private Button writeBtn;
	private Button readBtn;
	private TextView outputDataTv;

	private String file_name = "test.txt";
	
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
		
		if (v == writeBtn) {
			
			String data = inputDataEt.getText().toString();
			try {
				FileOutputStream fos = openFileOutput(file_name, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
				Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				e.printStackTrace();
				Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
			}
			
		} else if (v == readBtn) {
			
	        byte[] b = new byte[1024];
	        StringBuffer sb = new StringBuffer();
	        try {
		        FileInputStream fis = openFileInput(file_name);
		        int num;
		        while ((num = fis.read(b)) != -1) {
		            sb.append(new String(b, 0, num));
		        }
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        outputDataTv.setText("从File中读取数据：" + sb.toString());
	        
		}
		
	}

}
