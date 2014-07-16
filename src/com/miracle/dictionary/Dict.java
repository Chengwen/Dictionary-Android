package com.miracle.dictionary;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Dict
{
	private DBHelper helper;
	private SQLiteDatabase db;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String currDict;
	
	/**
	 * 1 is open,0 is close.
	 */
	
	public int status;
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Dict(){
		
	}

	/**
	 * get similar word
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public List<SingleWord> searchTips(String word) {

		ArrayList<SingleWord> words = new ArrayList<SingleWord>();
		Cursor c = db.rawQuery("SELECT * FROM Words where word like '"+word+"%'", null);
        while (c.moveToNext()) {
        	SingleWord singleword = new SingleWord();
        	singleword.id = c.getInt(c.getColumnIndex("id"));
        	singleword.dictinfoid = c.getInt(c.getColumnIndex("dictinfoid"));
        	singleword.word = c.getString(c.getColumnIndex("word"));
        	singleword.content = c.getString(c.getColumnIndex("content"));
        	Log.d("test", singleword.word);//debug output
        	words.add(singleword);
        }
        c.close();
        return words; 
	}
	
	/**
	 * get word&nbsp;explanation
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public SingleWord getWord(String word) {

    	SingleWord singleword = new SingleWord();
		Cursor c = db.rawQuery("SELECT * FROM Words where word='"+word+"' Limit 1", null);
        while (c.moveToNext()) {
        	singleword.id = c.getInt(c.getColumnIndex("id"));
        	singleword.dictinfoid = c.getInt(c.getColumnIndex("dictinfoid"));
        	singleword.word = c.getString(c.getColumnIndex("word"));
        	singleword.content = c.getString(c.getColumnIndex("content"));
        	Log.d("test", singleword.word);//debug output
            c.close();
            return singleword; 
        }
        c.close();
        return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void getDictInfo() {
		// TODO implement me	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean openDict(String dictfilename,Context context) {
		helper = new DBHelper(context,"sample.miracledict");
		//��ΪgetWritableDatabase�ڲ�������mContext.openOrCreateDatabase(mName, 0, mFactory);
		//����Ҫȷ��context�ѳ�ʼ��,���ǿ��԰�ʵ����DBManager�Ĳ������Activity��onCreate��
		db = helper.getWritableDatabase();
		return true;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean closeDict() {
		// TODO implement me
		return false;	
	}
	
}

