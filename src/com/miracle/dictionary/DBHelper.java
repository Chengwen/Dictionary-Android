package com.miracle.dictionary;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import android.content.Context;

public class DBHelper extends SQLiteAssetHelper  {

	private static final int DATABASE_VERSION = 1;
	
	public DBHelper(Context context,String DBFilename) {
		//CursorFactory设置为null,使用默认值
		super(context, DBFilename, null, DATABASE_VERSION);
	
	} 

}
