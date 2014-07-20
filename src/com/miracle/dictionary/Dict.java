package com.miracle.dictionary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.AutoCompleteTextView;


public class Dict
{
	private DBHelper helper;
	private SQLiteDatabase db;
	private Context context=null;
	private String currOpen=null;
 	private String[] dictlists;//all dict database
	
	public String currDict;
	
	/**
	 * 1 is open,0 is close.
	 */
	
	public int status;
	
	public Dict(){

	}
	
	public List<String> searchTips(String word) {
		
		ArrayList<String> words = new ArrayList<String>();
		
    	for(int i=0;i<dictlists.length;i++)
    	{
    		
			openDict(dictlists[i]);
			
			Cursor c = db.rawQuery("SELECT * FROM Words where word like '"+word+"%' Limit 20", null);
	        while (c.moveToNext()) {
	        	
	        	words.add(c.getString(c.getColumnIndex("word")));
	        }
	        c.close();

	        //remove repeat item
	        HashSet h = new HashSet(words);
	        words.clear();
	        words.addAll(h);
	        
	        if(words.size()>=10)
	        {
	            return words; 
	        }
    	}
        
        return words; 
	}

	
	public String getWord(String word) {
		String wordOutput="";
    	for(int i=0;i<dictlists.length;i++)
    	{
    		
			openDict(dictlists[i]);
	    	//SingleWord singleword = new SingleWord();
	    	
			Cursor c = db.rawQuery("SELECT * FROM Words where word='"+ word +"' Limit 3", null);
	        while (c.moveToNext()) {
	        	
	        	/*singleword.id = c.getInt(c.getColumnIndex("id"));
	        	singleword.dictinfoid = c.getInt(c.getColumnIndex("dictinfoid"));
	        	singleword.word = c.getString(c.getColumnIndex("word"));
	        	singleword.content = c.getString(c.getColumnIndex("content"));
	        	*/
	        	
	    		wordOutput+=c.getString(c.getColumnIndex("content"))+"\r\n\r\n";
	        }
	        c.close();
    		
    	}
        
    	
        return wordOutput;
       
	}
	
	public void getDictInfo() {
		// TODO implement me	
	}

	public boolean openDict(Context context) {


        try {
        	dictlists=context.getAssets().list("databases");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		this.context=context;
		//helper = new DBHelper(context,dictfilename);
		//currOpen=dictfilename;
		//因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
		//所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
		//db = helper.getWritableDatabase();
		return true;
	}
	public boolean openDict(String dictfilename) {
		if(currOpen==dictfilename)
			return true;
		helper = new DBHelper(this.context,dictfilename);
		currOpen=dictfilename;
		//因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
		//所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
		db = helper.getWritableDatabase();
		return true;	
	}
	
	public boolean closeDict() {
		// TODO implement me
		currOpen=null;
		return false;	
	}
	
}

