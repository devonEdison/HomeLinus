package com.home.homelinus;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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
        
    }
    
    
    private ImageButton.OnClickListener ImageButton00Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton01Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton02Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton03Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton04Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton05Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton06Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton07Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton08Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private ImageButton.OnClickListener ImageButton09Lin = new ImageButton.OnClickListener() {
        public void onClick(View v) {
        }
    };
    
}
