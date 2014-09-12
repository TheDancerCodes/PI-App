package com.android.pi;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class BusinessEtiquette  extends ActionBarActivity{
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
	ImageButton imageButtonemail,imageButtonphone,imageButtonsocial,imageButtonoffice ;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.biz_etiquette);
 
		addListenerOnButton();
 
	}
 
	public void addListenerOnButton() {
		final Context context = this;
 
		ImageButton imageButton01 = (ImageButton) findViewById(R.id.imageButtonemail);
		ImageButton imageButton02 = (ImageButton) findViewById(R.id.imageButtonphone);
		ImageButton imageButton03 = (ImageButton) findViewById(R.id.imageButtonsocial);
		ImageButton imageButton04 = (ImageButton) findViewById(R.id.imageButtonoffice);
		
 
		imageButton01.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				 //Launching Email Activity
				Intent i = new Intent(getApplicationContext(),Email2.class);
				startActivity(i);
			}
		
		
			});
		
		
		imageButton02.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				 //Launching Phone_Call Activity
				Intent i = new Intent(getApplicationContext(),Phone_Call.class);
				startActivity(i);
			}
			
			});
		
		imageButton03.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				 //Launching Social_Media Activity
				Intent i = new Intent(getApplicationContext(),Social_Media.class);
				startActivity(i);
			}
			
			});
		
		imageButton04.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View view) {
				 //Launching Office_Etiquette Activity
				Intent i = new Intent(getApplicationContext(),Office_Etiquette.class);
				startActivity(i);
			}
			
			});
		
		}
}
		 
		
		
	
	