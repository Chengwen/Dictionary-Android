package com.miracle.dictionary;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.os.Build;

public class MainActivity extends Activity {
	
	 private AutoCompleteTextView autotext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      //获取布局文件中的两个控件对象
        autotext=(AutoCompleteTextView)findViewById(R.id.autotext);
     
        //设置数据源
        String[] autoStrings=new String[]{"New York","Tokyo","beijing","london","Seoul Special","Los Angeles"};
        //设置ArrayAdapter，并且设定以单行下拉列表风格展示（第二个参数设定）。
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, 
android.R.layout.simple_dropdown_item_1line, autoStrings);
        //设置AutoCompleteTextView的Adapter
        autotext.setAdapter(adapter);
       

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
      
        
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


    public void onSearchClick(View view) {

        Dict d=new Dict();
        d.openDict("Sample.miracledict",this);
        d.searchTips("lov");
        /*
    	//获取编辑框值
        EditText myTextBox = (EditText) findViewById(R.id.searchinput);
        String s=myTextBox.getText().toString();
        WebView webView1 = (WebView) findViewById(R.id.webView1);
    	webView1.loadUrl("http://www.oldict.com/"+s+"/");*/
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

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            return rootView;
        }
    }

}
