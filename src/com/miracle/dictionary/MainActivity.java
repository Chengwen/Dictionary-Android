package com.miracle.dictionary;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.os.Build;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    /*public void onSearchClick(View view) {
    	//ªÒ»°±‡º≠øÚ÷µ
        EditText myTextBox = (EditText) findViewById(R.id.searchinput);
        String s=myTextBox.getText().toString();
        WebView webView1 = (WebView) findViewById(R.id.webView1);
    	webView1.loadUrl("http://www.oldict.com/"+s+"/");
   	 }*/
    
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
