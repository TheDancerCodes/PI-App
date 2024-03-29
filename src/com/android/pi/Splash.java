package com.android.pi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity{
	private int displayTime = 4000;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        Thread splashThread = new Thread(){
			int wait = 0;
			
			@Override
			public void run(){
				try{
					super.run();
					
					while(wait<displayTime){
						sleep(100);
						wait += 100;
					}
				}catch(Exception e){}
				finally{
					//Intent intent = new Intent(splashActivity.this,toutMain.class);
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					finish();


}
			}
			
			
        };
		splashThread.start();
    }

}
