package com.android.dating;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.json.JSONArray;

import com.android.pi.R;
import com.android.presentation.Delivery;
import com.android.presentation.Golden;
import com.android.presentation.Preparation;
import com.android.presentation.Structure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Dating_Etiquette extends ActionBarActivity {

	Button b;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    List<NameValuePair> nameValuePairs;
    static InputStream iStream = null;
    static JSONArray jArray = null;
    static String json = "";
   // private static final String READ_COMMENTS_URL = "http://213.150.98.46/webservice/comments.php";
    //private static final String TAG_SUCCESS = "success";
	//private static final String TAG_TITLE = "title";
	//private static final String TAG_POSTS = "posts";
	//private static final String TAG_POST_ID = "post_id";
	//private static final String TAG_USERNAME = "username";
	//private static final String TAG_MESSAGE = "message";
	//private JSONArray mComments = null;
	// manages all of our comments in a list.
	//private ArrayList<HashMap<String, String>> mCommentList;
	//private ProgressDialog pDialog;
	BufferedReader in = null;
    String data = null;
	ImageButton imageButtonDressing,imageButtonConversation,imageButtonDatingManners,imageButtonDatingTips;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dating_etiq);
 
		addListenerOnButton();
 
	}
 
	public void addListenerOnButton() {
		final Context context = this;
 
		ImageButton imageButton01 = (ImageButton) findViewById(R.id.imageButtonDressing);
		ImageButton imageButton02 = (ImageButton) findViewById(R.id.imageButtonConversation);
		//ImageButton imageButton03 = (ImageButton) findViewById(R.id.imageButtonDatingManners);
		ImageButton imageButton04 = (ImageButton) findViewById(R.id.imageButtonDatingTips);
		
 
		imageButton01.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				 //Launching Email Activity
				Intent i = new Intent(getApplicationContext(),Dressing.class);
				startActivity(i);
			}
		
		
			});
		
		imageButton02.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				 //Launching Email Activity
				Intent i = new Intent(getApplicationContext(),Conversation.class);
				startActivity(i);
			}
		
		
			});
		
//		imageButton03.setOnClickListener(new OnClickListener() {
//			 
//			@Override
//			public void onClick(View view) {
//				 //Launching Email Activity
//				Intent i = new Intent(getApplicationContext(),Dating_Manners.class);
//				startActivity(i);
//			}
//		
//		
//			});
		
		imageButton04.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				 //Launching Email Activity
				Intent i = new Intent(getApplicationContext(),Dating_Tips.class);
				startActivity(i);
			}
		
		
			});

}
	
}
