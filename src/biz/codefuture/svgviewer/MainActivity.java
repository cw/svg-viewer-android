package biz.codefuture.svgviewer;

import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebView;
//import android.util.Log;

public class MainActivity extends Activity {
	
//	private static final String TAG = "SVGViewerActivity";
	boolean mIsFullscreen = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = getIntent();
	    Uri data = intent.getData();
	    //Log.v(TAG, "data=" + data);

	    if (data != null && data.toString().indexOf("file") > -1) {	
	    	WebView webview = (WebView) findViewById(R.id.webView1);
	    	webview.loadUrl(data.toString());
	    	webview.getSettings().setBuiltInZoomControls(true);
	    	webview.getSettings().setDisplayZoomControls(false);
	    	webview.getSettings().setUseWideViewPort(true);
	    	//webview.zoomOut();
	    }
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.menu_zoom_fit:
	        toggleFullscreen();
	        return true;
	    }
        return super.onOptionsItemSelected(item);
	}
	
	private void toggleFullscreen()
	{
	    Log.v("svg viewer", "about to toggle fullscreen");
	    
		if (!mIsFullscreen) {
		  getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		  getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		  ActionBar actionBar = getActionBar();
		  actionBar.hide();
	      Log.v("svg viewer", "set fullscreen");
	      mIsFullscreen = true;
	    } else {
	      getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
	      getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		  ActionBar actionBar = getActionBar();
		  actionBar.show();
		  Log.v("svg viewer", "remove fullscreen");
	      mIsFullscreen = true;
	    }
	}
	
}
