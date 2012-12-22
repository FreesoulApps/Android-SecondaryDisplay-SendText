package com.freesoul.test.secondarydisplay;

import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements android.view.View.OnClickListener  {
	private MyPresentation mPresentation = null;
	Button mButton=null;
	EditText mEditText=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton=(Button)findViewById(R.id.button1);
		mButton.setOnClickListener(this);
		mEditText=(EditText)findViewById(R.id.editText1);
		DisplayManager dm = 
            (DisplayManager) getSystemService(DISPLAY_SERVICE);
        if (dm != null)
        {
            Display[] displays = 
                dm.getDisplays(
                    DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
            if(displays.length>0)
            {
                mPresentation = new MyPresentation(this, displays[0]);
                mPresentation.show();
            }
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.button1:
				if(mEditText!=null&&mPresentation!=null)
					mPresentation.UpdateText(mEditText.getText().toString());
				mEditText.setText("");
				break;
		}
		
	}


}
