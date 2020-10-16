package com.madproject.sandwich4u;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class orderDetails extends Activity {

    TextView ordered__list,total_price_view,show_price_view,orderlistText;
    TextToSpeech t1;
    String total_price;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderdetails);



        b1= findViewById(R.id.listen);
        b2 = findViewById(R.id.order);

        Bundle bundle = getIntent().getExtras();
        String data= bundle.getString("choice_iteams");
        total_price= bundle.getString("total_price");
   

        orderlistText = findViewById(R.id.orderlistTextview);
       ordered__list = findViewById(R.id.orderDetailstextView);

       show_price_view = findViewById(R.id.showprice);
       show_price_view.setText("Total Amount : Rs. "+total_price);

        ordered__list.setText(data);



        Typeface gatholic = ResourcesCompat.getFont(this, R.font.gatholic);

        ordered__list.setTypeface(gatholic);
        b1.setTypeface(gatholic);
        b2.setTypeface(gatholic);

        Typeface french = ResourcesCompat.getFont(this, R.font.french);

        orderlistText.setTypeface(french);


        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = ordered__list.getText().toString();
                t1.setPitch(0.8f);
                t1.setSpeechRate(0.8f);

                //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
		
			b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final_order();
            }
        });
     
            }
			public void final_order(){
         Intent intent=new Intent(orderDetails.this,userDetails.class);
		 Bundle bundle = new Bundle();
        bundle.putString("total_amount", total_price);
        intent.putExtras(bundle);
		 
         startActivity(intent);
         }


    }








