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
	
	public List<String> searchTips(String word) {

		ArrayList<String> words = new ArrayList<String>();
		Cursor c = db.rawQuery("SELECT word FROM Words where word like '"+word+"%'", null);
        while (c.moveToNext()) {
        	words.add(c.getString(c.getColumnIndex("word")));
        }
        c.close();
        return words; 
	}

	
	public SingleWord getWord(String word) {

    	SingleWord singleword = new SingleWord();
		Cursor c = db.rawQuery("SELECT * FROM Words where word='"+ word +"' Limit 1", null);
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
/*
        
        EditText myTextBox = (EditText) findViewById(R.id.searchinput);
        myTextBox.setOnEditorActionListener(new OnEditorActionListener()
        {
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
				return false;
			}
        });
        myTextBox.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        }); 
        myTextBox.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable s) {
         }
       
         public void beforeTextChanged(CharSequence s, int start, 
           int count, int after) {
         }
       
         public void onTextChanged(CharSequence s, int start, 
           int before, int count) {
            // WebView webView1 = (WebView) findViewById(R.id.webView1);
        	// webView1.loadUrl("http://www.oldict.com/"+s+"/");
         }
        });*/

/*
        
        EditText myTextBox = (EditText) findViewById(R.id.searchinput);
        myTextBox.setOnEditorActionListener(new OnEditorActionListener()
        {
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
				return false;
			}
        });
        myTextBox.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        }); 
        myTextBox.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable s) {
         }
       
         public void beforeTextChanged(CharSequence s, int start, 
           int count, int after) {
         }
       
         public void onTextChanged(CharSequence s, int start, 
           int before, int count) {
            // WebView webView1 = (WebView) findViewById(R.id.webView1);
        	// webView1.loadUrl("http://www.oldict.com/"+s+"/");
         }
        });*/
       
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
		helper = new DBHelper(context,"fren.miracledict");
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

