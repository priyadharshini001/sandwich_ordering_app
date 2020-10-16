package com.madproject.sandwich4u;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.renderscript.ScriptGroup;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.app.AlertDialog;
import android.text.TextUtils;


public class userDetails extends Activity {

    TextView userdetailsText;
	int quantity = 1;
	Calendar calander;
	SimpleDateFormat simpledateformat;
	String Date;
	String name, Address, Phonenumber;
	String total_amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetails);
        userdetailsText = findViewById(R.id.userdetailsTextview);
       Typeface french = ResourcesCompat.getFont(this, R.font.french);

        userdetailsText.setTypeface(french);

        Bundle bundle = getIntent().getExtras();
        total_amt= bundle.getString("total_amount");
		}

  

	public void name_details(View view) {
	
		EditText nameTextInput = findViewById(R.id.name_text_input);
        name = nameTextInput.getText().toString();
		 if(TextUtils.isEmpty(name)) {
		nameTextInput.setError("Name is required");
		return;
		}
	}
		public void address_details(View view) {
        EditText addressTextInput = findViewById(R.id.address_text_input);
        Address = addressTextInput.getText().toString();
		if(TextUtils.isEmpty(Address)) {
		addressTextInput.setError("Address field is required");
		return;
		}
		}
		public void number_details(View view) {
        EditText num = findViewById(R.id.num_input);
        Phonenumber = num.getText().toString();
		if(Phonenumber.length()!= 10) {
		num.setError("Entered Mobile no. isn't valid");
		return;
		}
	}
		
	

    public void submitOrder(View view) {
		calander = Calendar.getInstance();
		simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date = simpledateformat.format(calander.getTime());
 
		new AlertDialog.Builder(this).setTitle("Sandwich4U").setMessage("Welcome," + name + ". your order placed on "+Date+" has been successfully received. Pay Rs: "+ total_amt+" [Cash on Delivery]").setNeutralButton("Okay", null).show();


    }


    public void increment(View view) {
        if (quantity == 5){
          
            Toast toastMessage = Toast.makeText(this,"Glad, you liked :)", Toast.LENGTH_SHORT);
            toastMessage.show();
            return;
        }
         quantity = quantity + 1;
         displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1){
         
            Toast toastMessage = Toast.makeText(this,"Oops ! we'll improve", Toast.LENGTH_SHORT);
            toastMessage.show();
            return;
        }
        quantity--;
        displayQuantity(quantity);
    }

    public void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }





}
