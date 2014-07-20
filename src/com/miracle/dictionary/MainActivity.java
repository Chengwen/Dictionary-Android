package com.miracle.dictionary;


import com.google.analytics.tracking.android.EasyTracker;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.google.android.gms.ads.*;

public class MainActivity extends Activity {

 	private  AutoCompleteTextView autotext;
 	private Button cancel;
 	private com.miracle.dictionary.Dict d;
 	private AdView adView;
 	
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        d=new Dict();
	    d.openDict(this);
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
        android.R.layout.simple_dropdown_item_1line,  d.searchTips(contentStr));
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

	    // 创建adView。
	    adView = new AdView(this);
	    adView.setAdUnitId("ca-app-pub-3568858304593155/9069825423");
	    adView.setAdSize(AdSize.SMART_BANNER);

	    // 查询LinearLayout，假设其已指定
	    // 属性android:id="@+id/mainLayout"。
	    LinearLayout layout = (LinearLayout)findViewById(R.id.LinearLayout222);

	    // 在其中添加adView。
	    layout.addView(adView);

	    // 启动一般性请求。
	    AdRequest adRequest = new AdRequest.Builder().build();
	    /*AdRequest adRequest = new AdRequest.Builder()
	    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)       // 模拟器
	    .addTestDevice("35084AEE12F6A72B") // 我的Galaxy Nexus测试手机
	    .build();*/
	    
	    // 在adView中加载广告请求。
	    adView.loadAd(adRequest);
	    
    }

    @Override
    public void onStart() {
        super.onStart();
       // The rest of your onStart() code.
        EasyTracker.getInstance(this).activityStart(this);  // Add this method.
      }

      @Override
      public void onStop() {
        super.onStop();
       // The rest of your onStop() code.
        EasyTracker.getInstance(this).activityStop(this);  // Add this method.
      }

      @Override
      public void onPause() {
        adView.pause();
        super.onPause();
      }

      @Override
      public void onResume() {
        super.onResume();
        adView.resume();
      }

      @Override
      public void onDestroy() {
        adView.destroy();
        super.onDestroy();
      }
      
    private void onSearch(String word)
    {
    	
    	TextView text1= (TextView) findViewById(R.id.searchWord);
  		text1.setVisibility(View.VISIBLE); 
  		text1.setText(word);
    	TextView text= (TextView) findViewById(R.id.searchResult);
  		text.setVisibility(View.VISIBLE); 

    	//hide inupt
    	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);  
        imm.hideSoftInputFromWindow(text1.getWindowToken(), 0);
        
	    autotext.dismissDropDown();
        
        
    	String wordOutput=d.getWord(word);
        
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
