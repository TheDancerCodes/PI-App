package com.android.presentation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import com.android.pi.R;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class Preparation extends ActionBarActivity{
	
/** Called when the activity is first created. */
	
	TextView resultView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preparation);
        StrictMode.enableDefaults(); //STRICT MODE ENABLED
       resultView = (TextView) findViewById(R.id.result);
        
        getData();
    }
    
    public void getData(){
    	String result = "";
    	InputStream isr = null;
    	try{
            HttpClient httpclient = new DefaultHttpClient();
            
            HttpPost httppost = new HttpPost("http://testserver.co.ke/mobile/publicimage/json2/preparation.php");
            
           // HttpPost httppost = new HttpPost("http://10.0.2.2/publicimage/office_etiq.php"); //YOUR PHP SCRIPT ADDRESS
            //HttpPost httppost = new HttpPost("http://213.150.96.154/tahseen0amin/php/getAllCustomers.php"); //YOUR PHP SCRIPT ADDRESS 
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
    }
    catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
            resultView.setText("Couldnt connect to database....Please Check your Internet Connection!!");
    }
    //convert response to string
    try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
            }
            isr.close();
     
            result=sb.toString();
    }
    catch(Exception e){
            Log.e("log_tag", "Error  converting result "+e.toString());
    }
     
    //parse json data
   try {
	   String s = "";
	   JSONArray jArray = new JSONArray(result);
	   
	   for(int i=0; i<jArray.length();i++){
		   JSONObject json = jArray.getJSONObject(i);
		   s = s + 
				   //"Name : "+json.getString("FirstName")+" "+json.getString("LastName")+"\n"+
				  // "Age : "+json.getInt("Age")+"\n"+
				  // "Mobile Using : "+json.getString("Mobile")+"\n\n";
		   
				   json.getString("FirstName")+"\n\n "+json.getString("LastName")+"\n\n"+
				    json.getString("Age")+"\n\n"
				    +json.getString("Mobile")+"\n\n" ;
	   }
	   
	   resultView.setText(s);
	
   } catch (Exception e) {
	// TODO: handle exception
	   Log.e("log_tag", "Error Parsing Data "+e.toString());
   }
    
    }

}
