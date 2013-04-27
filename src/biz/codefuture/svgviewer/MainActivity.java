package biz.codefuture.svgviewer;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebView;
//import android.util.Log;

public class MainActivity extends Activity {
	
//	private static final String TAG = "SVGViewerActivity";

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
	        toggleFullscreen(true);
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
	
	private void toggleFullscreen(boolean fullscreen)
	{
	    WindowManager.LayoutParams attrs = getWindow().getAttributes();
	    if (fullscreen) {
	        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
	    } else {
	        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
	    }
	    getWindow().setAttributes(attrs);
	}
}
