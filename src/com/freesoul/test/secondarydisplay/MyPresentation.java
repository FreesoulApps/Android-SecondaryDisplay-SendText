package com.freesoul.test.secondarydisplay;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;

public class MyPresentation extends Presentation {

	@TargetApi(17)
	public MyPresentation(Context outerContext, Display display) {
		super(outerContext, display);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondery_layout);
    }
	
	public void UpdateText(String text)
	{
		TextView mTextView=(TextView)findViewById(R.id.textView1);
		mTextView.setText(text);
	}

}
