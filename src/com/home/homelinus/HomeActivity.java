package com.home.homelinus;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.home.homelinus.R;

public class HomeActivity extends Activity {
    private ImageButton ImageButton00;
    private ImageButton ImageButton01;
    private ImageButton ImageButton02;
    private ImageButton ImageButton03;
    private ImageButton ImageButton04;
    private ImageButton ImageButton05;
    private ImageButton ImageButton06;
    private ImageButton ImageButton07;
    private ImageButton ImageButton08;
    private ImageButton ImageButton09;
    
    
    private ImageButton LeftButton00;
    private ImageButton LeftButton01;
    private ImageButton LeftButton02;
    private ImageButton LeftButton03;
    private ImageButton LeftButton04;
    private ImageButton LeftButton05;
    private ImageButton LeftButton06;
    private ImageButton LeftButton07;
    private ImageButton LeftButton08;
    
    private TextView TextView0;
    private TextView TextView1;
    private TextView TextView2;
    private TextView TextView3;
    private TextView TextView4;
    private TextView TextView5;
    private TextView TextView6;
    private TextView TextView7;
    private TextView TextView8;

    

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        setupViewComponent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
    //disable back button
    @Override
    public void onBackPressed() {
    }
    
    //*******************************************************************************************************
    //download xml file new thread***************************************************************************
    //*******************************************************************************************************
    // Assign four Global Variables
    public String xml_source;
    boolean thread_start = false;
    private final String URL = "http://192.168.2.133:88/XC7000/homepage/abc.xml";
    XMLParser parser = new XMLParser();
    
    
    public void  downloadxml (){
            Thread thread = new Thread(){
                public void run(){
                    Log.v("devon", "devon run() " + URL);
                    String xml = parser.getXmlFromUrl(URL); // getting XML
                    xml_source = xml;
                    thread_start = true;
                    Log.v("devon", "devon  xml xml_source " + xml_source);
                }
          };
          thread.start();
    }
    
    public ArrayList<String> XPathParsing (String node){
        ArrayList<String> list = new ArrayList<String>();  //指定是String的型態
        try {
            if (xml_source != null) {
                InputStream is = new ByteArrayInputStream(xml_source.getBytes("UTF-8"));
                list = parser.parsexml(is, node, R.integer.text);
            } else {
                list.clear();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //*****************************************************************************************************
    //*****************************************************************************************************
    ArrayList<String> ImageNameList_right = new ArrayList<String>();  //指定是String的型態
    ArrayList<String> PackageNameList_right = new ArrayList<String>();  //指定是String的型態
    ArrayList<String> ActivityNameList_right = new ArrayList<String>();  //指定是String的型態
    ArrayList<String> ImageNameList_left = new ArrayList<String>();  //指定是String的型態
    ArrayList<String> PackageNameList_left = new ArrayList<String>();  //指定是String的型態
    ArrayList<String> ActivityNameList_left = new ArrayList<String>();  //指定是String的型態
    ArrayList<String> Text_left = new ArrayList<String>();  //指定是String的型態
    

    private void setupViewComponent() {
        
        // starting download xml///////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        downloadxml();
        while (thread_start == false) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                }
            }, 5000);
        }
        thread_start = false;
        //right--------------------------------------------------------
        // parsing imagename
        //for text XPath expression
        String XPathexp_ImageName_right = "//ImageName[@place='right']";
        ImageNameList_right = XPathParsing(XPathexp_ImageName_right);
        
        // parsing PackageName
        //for text XPath expression
        String XPathexp_PackageName_right = "//PackageName[@place='right']";
        PackageNameList_right = XPathParsing(XPathexp_PackageName_right);
        
        // parsing PackageName
        //for text XPath expression
        String XPathexp_ActivityName_right = "//ActivityName[@place='right']";
        ActivityNameList_right = XPathParsing(XPathexp_ActivityName_right);        
        
        //left----------------------------------------------------------
        // parsing imagename
        //for text XPath expression
        String XPathexp_ImageName_left = "//ImageName[@place='left']";
        ImageNameList_left = XPathParsing(XPathexp_ImageName_left);
        
        // parsing PackageName
        //for text XPath expression
        String XPathexp_PackageName_left = "//PackageName[@place='left']";
        PackageNameList_left = XPathParsing(XPathexp_PackageName_left);
        
        // parsing PackageName
        //for text XPath expression
        String XPathexp_ActivityName_left = "//ActivityName[@place='left']";
        ActivityNameList_left = XPathParsing(XPathexp_ActivityName_left);
        
        // parsing PackageName
        //for text XPath expression
        String XPathexp_Text_left = "//TextName[@place='left']";
        Text_left = XPathParsing(XPathexp_Text_left);
        
        //---------------------------------------------------------------
        
        
        //right side 00
        if (ImageNameList_right.get(0) != ""){
        ImageButton00 = (ImageButton) this.findViewById(R.id.ImageButton00);
        int id = getResources().getIdentifier(ImageNameList_right.get(0).toLowerCase(), "drawable", getPackageName());
        ImageButton00.setImageResource(id);
        ImageButton00.setOnClickListener(ImageButton00Lin);
        ImageButton00.getBackground().setAlpha(90);
        }else{
            ImageButton00 = (ImageButton) this.findViewById(R.id.ImageButton00);
            ImageButton00.setVisibility(ImageButton00.GONE);
        }

        //right side 01
        if (ImageNameList_right.get(1) != ""){
        ImageButton01 = (ImageButton) this.findViewById(R.id.ImageButton01);
        int id = getResources().getIdentifier(ImageNameList_right.get(1).toLowerCase(), "drawable", getPackageName());
        ImageButton01.setImageResource(id);
        ImageButton01.setOnClickListener(ImageButton01Lin);
        ImageButton01.getBackground().setAlpha(90);
        }else{
            ImageButton01 = (ImageButton) this.findViewById(R.id.ImageButton01);
            ImageButton01.setVisibility(ImageButton01.GONE);
        }
        
        //right side 02
        if (ImageNameList_right.get(2) != ""){
        ImageButton02 = (ImageButton) this.findViewById(R.id.ImageButton02);
        int id = getResources().getIdentifier(ImageNameList_right.get(2).toLowerCase(), "drawable", getPackageName());
        ImageButton02.setImageResource(id);
        ImageButton02.setOnClickListener(ImageButton02Lin);
        ImageButton02.getBackground().setAlpha(90);
        }else{
            ImageButton02 = (ImageButton) this.findViewById(R.id.ImageButton02);
            ImageButton02.setVisibility(ImageButton02.GONE);
        }
        
        //right side 03
        if (ImageNameList_right.get(3) != ""){
        ImageButton03 = (ImageButton) this.findViewById(R.id.ImageButton03);
        int id = getResources().getIdentifier(ImageNameList_right.get(3).toLowerCase(), "drawable", getPackageName());
        ImageButton03.setImageResource(id);
        ImageButton03.setOnClickListener(ImageButton03Lin);
        ImageButton03.getBackground().setAlpha(90);
        }else{
            ImageButton03 = (ImageButton) this.findViewById(R.id.ImageButton03);
            ImageButton03.setVisibility(ImageButton03.GONE);
        }
        
        //right side 04
        if (ImageNameList_right.get(4) != ""){
        ImageButton04 = (ImageButton) this.findViewById(R.id.ImageButton04);
        int id = getResources().getIdentifier(ImageNameList_right.get(4).toLowerCase(), "drawable", getPackageName());
        ImageButton04.setImageResource(id);
        ImageButton04.setOnClickListener(ImageButton04Lin);
        ImageButton04.getBackground().setAlpha(90);
        }else{
            ImageButton04 = (ImageButton) this.findViewById(R.id.ImageButton04);
            ImageButton04.setVisibility(ImageButton04.GONE);
        }
        
        //right side 05
        if (ImageNameList_right.get(5) != ""){
        ImageButton05 = (ImageButton) this.findViewById(R.id.ImageButton05);
        int id = getResources().getIdentifier(ImageNameList_right.get(5).toLowerCase(), "drawable", getPackageName());
        ImageButton05.setImageResource(id);
        ImageButton05.setOnClickListener(ImageButton05Lin);
        ImageButton05.getBackground().setAlpha(90);
        }else{
            ImageButton05 = (ImageButton) this.findViewById(R.id.ImageButton05);
            ImageButton05.setVisibility(ImageButton05.GONE);
        }
        
        //right side 06
        if (ImageNameList_right.get(6) != ""){
        ImageButton06 = (ImageButton) this.findViewById(R.id.ImageButton06);
        int id = getResources().getIdentifier(ImageNameList_right.get(6).toLowerCase(), "drawable", getPackageName());
        ImageButton06.setImageResource(id);
        ImageButton06.setOnClickListener(ImageButton06Lin);
        ImageButton06.getBackground().setAlpha(90);
        }else{
            ImageButton06 = (ImageButton) this.findViewById(R.id.ImageButton06);
            ImageButton06.setVisibility(ImageButton06.GONE);
        }
        //right side 07
        if (ImageNameList_right.get(7) != ""){
        ImageButton07 = (ImageButton) this.findViewById(R.id.ImageButton07);
        int id = getResources().getIdentifier(ImageNameList_right.get(7).toLowerCase(), "drawable", getPackageName());
        ImageButton07.setImageResource(id);
        ImageButton07.setOnClickListener(ImageButton07Lin);
        ImageButton07.getBackground().setAlpha(90);
        }else{
            ImageButton07 = (ImageButton) this.findViewById(R.id.ImageButton07);
            ImageButton07.setVisibility(ImageButton07.GONE);
        }
        
        //right side 08
        if (ImageNameList_right.get(8) != ""){
        ImageButton08 = (ImageButton) this.findViewById(R.id.ImageButton08);
        int id = getResources().getIdentifier(ImageNameList_right.get(8).toLowerCase(), "drawable", getPackageName());
        ImageButton08.setImageResource(id);
        ImageButton08.setOnClickListener(ImageButton08Lin);
        ImageButton08.getBackground().setAlpha(90);
        }else{
            ImageButton08 = (ImageButton) this.findViewById(R.id.ImageButton08);
            ImageButton08.setVisibility(ImageButton08.GONE);
        }
        
        //right side 09
        if (ImageNameList_right.get(9) != ""){
        ImageButton09 = (ImageButton) this.findViewById(R.id.ImageButton09);
        int id = getResources().getIdentifier(ImageNameList_right.get(9).toLowerCase(), "drawable", getPackageName());
        ImageButton09.setImageResource(id);
        ImageButton09.setOnClickListener(ImageButton09Lin);
        ImageButton09.getBackground().setAlpha(90);
        }else{
            ImageButton09 = (ImageButton) this.findViewById(R.id.ImageButton09);
            ImageButton09.setVisibility(ImageButton09.GONE);
        }
        
        /////////////////////////////////////////////////////////////////////
        //left side
        /////////////////////////////////////////////////////////////////////
        
        //left side 00
        if (ImageNameList_left.get(0) != ""){
            LeftButton00 = (ImageButton) this.findViewById(R.id.LeftButton00);
            int id = getResources().getIdentifier(ImageNameList_left.get(0).toLowerCase(), "drawable", getPackageName());
            LeftButton00.setImageResource(id);
            LeftButton00.setOnClickListener(LeftButton00Lin);
            
            TextView0 = (TextView) this.findViewById(R.id.TextView0);
            TextView0.setText(Text_left.get(0));
            
        }else{
            LeftButton00 = (ImageButton) this.findViewById(R.id.LeftButton00);
            LeftButton00.setVisibility(LeftButton00.GONE);
            TextView0.setVisibility(TextView0.GONE);
        }
        
        //left side 01
        if (ImageNameList_left.get(1) != ""){
            LeftButton01 = (ImageButton) this.findViewById(R.id.LeftButton01);
            int id = getResources().getIdentifier(ImageNameList_left.get(1).toLowerCase(), "drawable", getPackageName());
            LeftButton01.setImageResource(id);
            LeftButton01.setOnClickListener(LeftButton01Lin);
            LeftButton01.getBackground().setAlpha(90);
            
            TextView1 = (TextView) this.findViewById(R.id.TextView1);
            TextView1.setText(Text_left.get(1));
            
        }else{
            LeftButton01 = (ImageButton) this.findViewById(R.id.LeftButton01);
            LeftButton01.setVisibility(LeftButton01.GONE);
            TextView1.setVisibility(TextView1.GONE);
        }
        
        //left side 02
        if (ImageNameList_left.get(2) != ""){
            LeftButton02 = (ImageButton) this.findViewById(R.id.LeftButton02);
            int id = getResources().getIdentifier(ImageNameList_left.get(2).toLowerCase(), "drawable", getPackageName());
            LeftButton02.setImageResource(id);
            LeftButton02.setOnClickListener(LeftButton02Lin);
            
            TextView2 = (TextView) this.findViewById(R.id.TextView2);
            TextView2.setText(Text_left.get(2));
            
        }else{
            LeftButton02 = (ImageButton) this.findViewById(R.id.LeftButton02);
            LeftButton02.setVisibility(LeftButton02.GONE);
            TextView2.setVisibility(TextView2.GONE);
        }
        
        //left side 03
        if (ImageNameList_left.get(3) != ""){
            LeftButton03 = (ImageButton) this.findViewById(R.id.LeftButton03);
            int id = getResources().getIdentifier(ImageNameList_left.get(3).toLowerCase(), "drawable", getPackageName());
            LeftButton03.setImageResource(id);
            LeftButton03.setOnClickListener(LeftButton03Lin);
            
            TextView3 = (TextView) this.findViewById(R.id.TextView3);
            TextView3.setText(Text_left.get(0));
            
        }else{
            LeftButton03 = (ImageButton) this.findViewById(R.id.LeftButton03);
            LeftButton03.setVisibility(LeftButton03.GONE);
            TextView3.setVisibility(TextView3.GONE);
        }
        
        //left side 04
        if (ImageNameList_left.get(4) != ""){
            LeftButton04 = (ImageButton) this.findViewById(R.id.LeftButton04);
            int id = getResources().getIdentifier(ImageNameList_left.get(4).toLowerCase(), "drawable", getPackageName());
            LeftButton04.setImageResource(id);
            LeftButton04.setOnClickListener(LeftButton04Lin);
            
            TextView4 = (TextView) this.findViewById(R.id.TextView4);
            TextView4.setText(Text_left.get(4));
            
        }else{
            LeftButton04 = (ImageButton) this.findViewById(R.id.LeftButton04);
            LeftButton04.setVisibility(LeftButton04.GONE);
            TextView4.setVisibility(TextView4.GONE);
        }
        
        //left side 05
        if (ImageNameList_left.get(5) != ""){
            LeftButton05 = (ImageButton) this.findViewById(R.id.LeftButton05);
            int id = getResources().getIdentifier(ImageNameList_left.get(5).toLowerCase(), "drawable", getPackageName());
            LeftButton05.setImageResource(id);
            LeftButton05.setOnClickListener(LeftButton05Lin);
            
            TextView5 = (TextView) this.findViewById(R.id.TextView5);
            TextView5.setText(Text_left.get(5));
            
        }else{
            LeftButton05 = (ImageButton) this.findViewById(R.id.LeftButton05);
            LeftButton05.setVisibility(LeftButton05.GONE);
            TextView5.setVisibility(TextView5.GONE);
        }
        
        //left side 06
        if (ImageNameList_left.get(6) != ""){
            LeftButton06 = (ImageButton) this.findViewById(R.id.LeftButton06);
            int id = getResources().getIdentifier(ImageNameList_left.get(6).toLowerCase(), "drawable", getPackageName());
            LeftButton06.setImageResource(id);
            LeftButton06.setOnClickListener(LeftButton06Lin);
            
            TextView6 = (TextView) this.findViewById(R.id.TextView6);
            TextView6.setText(Text_left.get(6));
            
        }else{
            LeftButton06 = (ImageButton) this.findViewById(R.id.LeftButton06);
            LeftButton06.setVisibility(LeftButton06.GONE);
            TextView6.setVisibility(TextView6.GONE);
        }
        
        //left side 07
        if (ImageNameList_left.get(7) != ""){
            LeftButton07 = (ImageButton) this.findViewById(R.id.LeftButton07);
            int id = getResources().getIdentifier(ImageNameList_left.get(7).toLowerCase(), "drawable", getPackageName());
            LeftButton07.setImageResource(id);
            LeftButton07.setOnClickListener(LeftButton07Lin);
            
            TextView7 = (TextView) this.findViewById(R.id.TextView7);
            TextView7.setText(Text_left.get(7));
            
        }else{
            LeftButton07 = (ImageButton) this.findViewById(R.id.LeftButton07);
            LeftButton07.setVisibility(LeftButton07.GONE);
            TextView7.setVisibility(TextView7.GONE);
        }
        
        //left side 08
        if (ImageNameList_left.get(8) != ""){
            LeftButton08 = (ImageButton) this.findViewById(R.id.LeftButton08);
            int id = getResources().getIdentifier(ImageNameList_left.get(8).toLowerCase(), "drawable", getPackageName());
            LeftButton08.setImageResource(id);
            LeftButton08.setOnClickListener(LeftButton08Lin);
            
            TextView8 = (TextView) this.findViewById(R.id.TextView8);
            TextView8.setText(Text_left.get(8));
            
        }else{
            LeftButton08 = (ImageButton) this.findViewById(R.id.LeftButton08);
            LeftButton08.setVisibility(LeftButton08.GONE);
            TextView8.setVisibility(TextView8.GONE);
        }
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////
    //right side listener
    //////////////////////////////////////////////////////////////////////////////////////////////
    
    private ImageButton.OnClickListener ImageButton00Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {

			final Intent intent = new Intent(Intent.ACTION_MAIN, null);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			final ComponentName cn = new ComponentName(PackageNameList_right.get(0),ActivityNameList_right.get(0));
			intent.setComponent(cn);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton01Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(1),ActivityNameList_right.get(1));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton02Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(2),ActivityNameList_right.get(2));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton03Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(3),ActivityNameList_right.get(3));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton04Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(4),ActivityNameList_right.get(4));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton05Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(5),ActivityNameList_right.get(5));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

            
        }
    };
    private ImageButton.OnClickListener ImageButton06Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(6),ActivityNameList_right.get(6));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton07Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(7),ActivityNameList_right.get(7));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton08Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(8),ActivityNameList_right.get(8));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton09Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            final Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            final ComponentName cn = new ComponentName(PackageNameList_right.get(9),ActivityNameList_right.get(9));
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    
    //////////////////////////////////////////////////////////////////////////////
    //left side listener//////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    private ImageButton.OnClickListener LeftButton00Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton01Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton02Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton03Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton04Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton05Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton06Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton07Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener LeftButton08Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
    //sending string to server
    /////////////////////////////////////////////////////////////////////////////////////////////////
    public static void sendMessage(String msg) throws IOException{
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
    
        try {
            socket = new Socket("127.0.0.1", 6001);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        }
    
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String num1 = "message = system setting revised";
        String num2 = msg;
    
        //output
        num1=read.readLine();
        out.println(num1);
        
        num2=read.readLine();   
        out.println(num2);
    
        //input
        System.out.println(in.readLine());
    
        out.close();
        in.close();
        read.close();
        socket.close();
    }

}
