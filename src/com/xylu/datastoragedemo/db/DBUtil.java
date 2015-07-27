package com.xylu.datastoragedemo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBUtil {

	DBOpenHelper dbOpenHelper;
	
	public DBUtil(Context context) {
		
		this.dbOpenHelper = new DBOpenHelper(context);
		
	}
	
	/**
     * 添加一条数据
     */
    public void write(String data){
    	
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("insert into test(data) values(?)", new Object[]{data});
        db.close();
        
    }
	
    /**
     * 读取一条数据
     */
    public String read(){
    	
        String data = "";
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from test order by id desc limit 1", null);
        if(cursor.moveToFirst()){
            data = cursor.getString(cursor.getColumnIndex("data"));
        }
        cursor.close();
        return data;
        
    }
}
