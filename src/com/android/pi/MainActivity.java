package com.android.pi;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.android.bodylang.Body_Language;
import com.android.bodylang.Facial_Expressions;
import com.android.dating.Dating_Etiquette;
import com.android.dining.Dining_Etiquette;
import com.android.interview.Interview_Skills;
import com.android.presentation.Presentation_Skills;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;



public class MainActivity  extends ActionBarActivity{
	
	ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6,imageButton7 ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		addListenerOnButton();
		
		 
	}
		
	
 
	public void addListenerOnButton() {
		final Context context = this;
 
		ImageButton imageButton01 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton imageButton02 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton imageButton03 = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton imageButton04 = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton imageButton05 = (ImageButton) findViewById(R.id.imageButton5);
		//ImageButton imageButton06 = (ImageButton) findViewById(R.id.imageButton6);
		ImageButton imageButton07 = (ImageButton) findViewById(R.id.imageButton7);
 
		imageButton01.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View view) {
				// Launching All products Activity
				Intent i = new Intent(getApplicationContext(), BusinessEtiquette.class);
				startActivity(i);
				
			}
		});
		 
		
		imageButton02.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				// Launching All products Activity
				Intent i = new Intent(getApplicationContext(), Body_Language.class);
				startActivity(i);
				
			}
		});
	
		imageButton03.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				// Launching All products Activity
				Intent i = new Intent(getApplicationContext(), Presentation_Skills.class);
				startActivity(i);
								
			}
		});
		
		
		imageButton04.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				// Launching All products Activity
				Intent i = new Intent(getApplicationContext(), Dating_Etiquette.class);
				startActivity(i);
								
			}
		});
		
		
		imageButton05.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				// Launching All products Activity
				Intent i = new Intent(getApplicationContext(), Dining_Etiquette.class);
				startActivity(i);
								
			}
		});
		
		imageButton07.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				// Launching All products Activity
				Intent i = new Intent(getApplicationContext(), Interview_Skills.class);
				startActivity(i);
								
			}
		});
	}
	
	}
