package com.miracle.dictionary;
/*
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	private DBHelper helper;
	private SQLiteDatabase db;
	
	public DBManager(Context context) {
		helper = new DBHelper(context);
		//��ΪgetWritableDatabase�ڲ�������mContext.openOrCreateDatabase(mName, 0, mFactory);
		//����Ҫȷ��context�ѳ�ʼ��,���ǿ��԰�ʵ����DBManager�Ĳ������Activity��onCreate��
		db = helper.getWritableDatabase();
	}
	
	
	//query all persons, return list
	//@return List<Person>
	 
	public List<SingleWord> query() {
		ArrayList<SingleWord> words = new ArrayList<SingleWord>();
		Cursor c = queryTheCursor();
        while (c.moveToNext()) {
        	SingleWord singleword = new SingleWord();
        	singleword.id = c.getInt(c.getColumnIndex("id"));
        	singleword.dictinfoid = c.getInt(c.getColumnIndex("dictinfoid"));
        	singleword.word = c.getString(c.getColumnIndex("word"));
        	singleword.content = c.getString(c.getColumnIndex("content"));
        	words.add(singleword);
        }
        c.close();
        return words;
	}
	
	
	 // query all persons, return cursor
	 //@return	Cursor
	 
	public Cursor queryTheCursor() {
        Cursor c = db.rawQuery("SELECT * FROM person", null);
        return c;
	}
	
	
	// close database
	 
	public void closeDB() {
		db.close();
	}
}
*/