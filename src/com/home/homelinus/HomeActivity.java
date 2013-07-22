package com.home.homelinus;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

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
    
    private void setupViewComponent() {
        //right side 00
        ImageButton00 = (ImageButton) this.findViewById(R.id.ImageButton00);
        ImageButton00.setOnClickListener(ImageButton00Lin);
        ImageButton00.getBackground().setAlpha(90);
        
        //right side 01
        ImageButton01 = (ImageButton) this.findViewById(R.id.ImageButton01);
        ImageButton01.setOnClickListener(ImageButton01Lin);
        ImageButton01.getBackground().setAlpha(90);
        
        //right side 02
        ImageButton02 = (ImageButton) this.findViewById(R.id.ImageButton02);
        ImageButton02.setOnClickListener(ImageButton02Lin);
        ImageButton02.getBackground().setAlpha(90);
        
        //right side 03
        ImageButton03 = (ImageButton) this.findViewById(R.id.ImageButton03);
        ImageButton03.setOnClickListener(ImageButton03Lin);
        ImageButton03.getBackground().setAlpha(90);
        
        //right side 04
        ImageButton04 = (ImageButton) this.findViewById(R.id.ImageButton04);
        ImageButton04.setOnClickListener(ImageButton04Lin);
        ImageButton04.getBackground().setAlpha(90);
        
        //right side 05
        ImageButton05 = (ImageButton) this.findViewById(R.id.ImageButton05);
        ImageButton05.setOnClickListener(ImageButton05Lin);
        ImageButton05.getBackground().setAlpha(90);
        
        //right side 06
        ImageButton06 = (ImageButton) this.findViewById(R.id.ImageButton06);
        ImageButton06.setOnClickListener(ImageButton06Lin);
        ImageButton06.getBackground().setAlpha(90);
        
        //right side 07
        ImageButton07 = (ImageButton) this.findViewById(R.id.ImageButton07);
        ImageButton07.setOnClickListener(ImageButton07Lin);
        ImageButton07.getBackground().setAlpha(90);
        
        //right side 08
        ImageButton08 = (ImageButton) this.findViewById(R.id.ImageButton08);
        ImageButton08.setOnClickListener(ImageButton08Lin);
        ImageButton08.getBackground().setAlpha(90);
        
        //right side 09
        ImageButton09 = (ImageButton) this.findViewById(R.id.ImageButton09);
        ImageButton09.setOnClickListener(ImageButton09Lin);
        ImageButton09.getBackground().setAlpha(90);
        
        /////////////////////////////////////////////////////////////////////
        //left side
        /////////////////////////////////////////////////////////////////////
        
        //left side 00
        LeftButton00 = (ImageButton) this.findViewById(R.id.LeftButton00);
        LeftButton00.setOnClickListener(LeftButton00Lin);
        
        //left side 01
        LeftButton01 = (ImageButton) this.findViewById(R.id.LeftButton01);
        LeftButton01.setOnClickListener(LeftButton01Lin);
        
        //left side 02
        LeftButton02 = (ImageButton) this.findViewById(R.id.LeftButton02);
        LeftButton02.setOnClickListener(LeftButton02Lin);
        
        //left side 03
        LeftButton03 = (ImageButton) this.findViewById(R.id.LeftButton03);
        LeftButton03.setOnClickListener(LeftButton03Lin);
        
        //left side 04
        LeftButton04 = (ImageButton) this.findViewById(R.id.LeftButton04);
        LeftButton04.setOnClickListener(LeftButton04Lin);
        
        //left side 05
        LeftButton05 = (ImageButton) this.findViewById(R.id.LeftButton05);
        LeftButton05.setOnClickListener(LeftButton05Lin);
        
        //left side 06
        LeftButton06 = (ImageButton) this.findViewById(R.id.LeftButton06);
        LeftButton06.setOnClickListener(LeftButton06Lin);
        
        //left side 07
        LeftButton07 = (ImageButton) this.findViewById(R.id.LeftButton07);
        LeftButton07.setOnClickListener(LeftButton07Lin);
        
        //left side 08
        LeftButton08 = (ImageButton) this.findViewById(R.id.LeftButton08);
        LeftButton08.setOnClickListener(LeftButton08Lin);
        
    }
    //right side listener
    private ImageButton.OnClickListener ImageButton00Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {

			final Intent intent = new Intent(Intent.ACTION_MAIN, null);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			final ComponentName cn = new ComponentName("com.android.gallery3d","com.android.camera.CameraLauncher");
			intent.setComponent(cn);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton01Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 

        }
    };
    private ImageButton.OnClickListener ImageButton02Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	
			final Intent intent = new Intent(Intent.ACTION_MAIN, null);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			final ComponentName cn = new ComponentName("com.android.settings",
					"com.android.settings.fuelgauge.PowerUsageSummary");
			intent.setComponent(cn);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
			
        }
    };
    private ImageButton.OnClickListener ImageButton03Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.browser");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener ImageButton04Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	
        	Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.gallery3d");
        	startActivity(intent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener ImageButton05Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener ImageButton06Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener ImageButton07Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        }
    };
    private ImageButton.OnClickListener ImageButton08Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    private ImageButton.OnClickListener ImageButton09Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        	startActivity(LaunchIntent);
        	overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
        }
    };
    
    //left side listener

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

}
