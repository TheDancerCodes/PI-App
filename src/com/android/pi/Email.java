package com.android.pi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

public class Email extends ActionBarActivity {
	TextView tv;
    
    // Progress Dialog
    private ProgressDialog pDialog;

    // Profile json object
    JSONArray product;
    JSONObject hay;
    // Profile JSON url
   private static final String url = "http://testserver.co.ke/mobile/publicimage/complete/get_info.php";
    //private static final String url = "http://localhost/publicimage/get_info.php";
   // private static final String url = "http://10.0.2.2/publicimage/get_info.php";
  //private static final String url = "http://testserver.co.ke/mobile/publicimage/json2/get_info.php";
   //HttpPost httppost = new HttpPost("http://testserver.co.ke/mobile/publicimage/json2/office_etiq.php");
    
    // ALL JSON node names
    private static final String TAG_PRODUCT = "product";
    private static final String TAG_USER = "user";
    private static final String TAG_ID = "id";
    private static final String TAG_CONTENT = "content";
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        tv = (TextView) findViewById(R.id.tv);
        
        // Loading Profile in Background Thread
        new LoadProfile().execute();
    }

    class LoadProfile extends AsyncTask<String, String,JSONObject> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Email.this);
            pDialog.setMessage("Loading content...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {
        JSONParser jParser = new JSONParser();
        // Getting JSON from URL
        JSONObject json = jParser.getJSONFromUrl(url);
        return json;
      }
       @Override
         protected void onPostExecute(JSONObject json) {
         pDialog.dismiss();
         try {
            // Getting JSON Array
            
       ArrayList<String> stringArray = new ArrayList<String>(); 
        	 product = json.getJSONArray(TAG_PRODUCT);
        	 
            	for (int i=0; i < product.length(); i++) 
                {
                		
                JSONObject c = product.getJSONObject(0);
            //JSONObject c = product.getJSONObject(0);
            // Storing  JSON item in a Variable
            String id = c.getString(TAG_ID);
            String content = c.getString(TAG_CONTENT);
            //stringArray.add(c.getString("product").toString());

            //String email = c.getString(TAG_EMAIL);
            //Set JSON Data in TextView
            //uid.setText(id);
            tv.setText(content);
            //email1.setText(email);
            }
        } catch (JSONException e) {
          e.printStackTrace();
        }
       }
    }
}
	
