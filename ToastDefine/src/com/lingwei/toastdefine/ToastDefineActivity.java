package com.lingwei.toastdefine;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class ToastDefineActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toast_define_activity);
	}
	
	public void toastWrap(View v){
		MyToast.makeText(this, R.layout.toast_msg, "test", MyToast.StyleFillPrompt).show();
	}

	public void toastFill(View v){
		MyToast.makeText(this, R.layout.toast_msg, "test", MyToast.StyleWrapPrompt).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.toast_define, menu);
		return true;
	}

}
