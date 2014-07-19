package com.miracle.dictionary;


import java.io.IOException;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.os.Build;

public class MainActivity extends Activity {

 	private  AutoCompleteTextView autotext;
 	private Button cancel;
 	private String[] dictlists;//all dict database
 	private String maindict;//main dict database
 	private Dict d;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
        	dictlists=this.getAssets().list("databases");
        	maindict=dictlists[0];
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        d=new Dict();
	    d.openDict(maindict, MainActivity.this);
	        
	      autotext=(AutoCompleteTextView)findViewById(R.id.autotext);
	      autotext.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            public void onItemClick(AdapterView<?> parent, View view,  
                int position, long id) {  
            	/* 
                ListView listview = (ListView) parent;  
                ArrayAdapter<String> adapter  =  (ArrayAdapter<String>) parent.getAdapter();  
                TextView textview = (TextView) view;  */
            	String select=autotext.getText().toString();
           
            	onSearch(select);
            	Log.d("select",select);
            }});  
	      
	      autotext.setOnEditorActionListener(new OnEditorActionListener() {
	    	    @Override
	    	    public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
	    	        // TODO Auto-generated method stub
	    	        if (arg1 == EditorInfo.IME_ACTION_SEARCH) {
	    	            // search pressed and perform your functionality.
	                	String select=autotext.getText().toString();
	                	onSearch(select);
	    	        }
	    	        return false;
	    	    }
	    	});
	      
	   	  autotext.addTextChangedListener(new TextWatcher() {         
          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
        	
        	  
        	Log.i("test", "textchage");
      		String contentStr = s.toString(); 
      		
      		if (contentStr == null || contentStr.length() <= 0)//判断contentStr是否为空,判断字符串是否为空典型写法
      		{
      			Log.i("zhangya", "afterTextChanged null");

      		} else
      		{

                //设置数据源
                //String[] autoStrings=new String[]{"New York","Tokyo","beijing","london","Seoul Special","Los Angeles"};
                

      			//设置ArrayAdapter，并且设定以单行下拉列表风格展示（第二个参数设定）。
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, 
        android.R.layout.simple_dropdown_item_1line,  d.searchTips(maindict,contentStr));
                //设置AutoCompleteTextView的Adapter
                autotext.setAdapter(adapter);
               
      		}
      		
          }

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count,
                  int after) {                

          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });
	   	  
	   	  
	   	cancel =(Button) findViewById(R.id.cancel);
	   
	    cancel.setOnClickListener(new Button.OnClickListener()
	    {
	      @Override
	      public void onClick(View v)
	      {
	        // TODO Auto-generated method stub
	        autotext.setText("");            //按钮按下的处理部分
	      }
	    });
   	
    }


    private void onSearch(String word)
    {
  		TextView text= (TextView) findViewById(R.id.searchResult);
  	
  		text.setVisibility(View.VISIBLE); 
  		
    	String wordOutput="";
    	for(int i=0;i<dictlists.length;i++)
    	{
    		SingleWord w=d.getWord(dictlists[i],word);
    		wordOutput+=w.content+"\r\n\r\n";
    	}
        
        if(wordOutput.isEmpty())
        {
        	text.setText(R.string.word_not_find);
        }
        else
        {
        	text.setText(wordOutput);
        }
    }
      
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
        
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

    }

}
