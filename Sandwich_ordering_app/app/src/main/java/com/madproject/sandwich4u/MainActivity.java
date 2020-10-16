package com.madproject.sandwich4u;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {


    TextView menu, vegsptv, veggcheesetv, clubcheesetv, garliccheesetv, layscheesetv, mushroomcheesetv,chickencheesetv, tandoorichickentv, bbqchickentv, egggrilledtv, breadomelettetv;
    TextView vegspptv, veggcheeseptv, clubcheeseptv, garliccheeseptv, layscheeseptv, mushroomcheeseptv,chickencheeseptv, tandoorichickenptv, bbqchickenptv, egggrilledptv, breadomeletteptv;
    String choices = "";
    String prices;
    Button vegsp, veggcheese, clubcheese, garliccheese, layscheese, mushroomcheese, chickencheese, tandoorichicken, bbqchicken, egggrilled, breadomelette;


    Button rm_vegsp, rm_veggcheese, rm_clubcheese, rm_garliccheese, rm_layscheese, rm_mushroomcheese, rm_chickencheese, rm_tandoorichicken, rm_bbqchicken, rm_egggrilled, rm_breadomelette,order;


    int vegspp = 0, veggcheesep = 0, clubcheesep = 0, garliccheesep = 0, layscheesep = 0, mushroomcheesep = 0, chickencheesep=0, tandoorichickenp=0, bbqchickenp=0, egggrilledp=0, breadomelettep=0;
    int tvegspp = 0, tveggcheesep = 0, tclubcheesep = 0, tgarliccheesep = 0, tlayscheesep = 0, tmushroomcheesep = 0, tchickencheesep=0, ttandoorichickenp=0, tbbqchickenp=0, tegggrilledp=0, tbreadomelettep=0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menuTv);
        vegsptv = findViewById(R.id.vegsp_textView);
        veggcheesetv = findViewById(R.id.veggcheese_textView);
        clubcheesetv = findViewById(R.id.clubcheese_textView);
        garliccheesetv = findViewById(R.id.garliccheese_textView);
        layscheesetv = findViewById(R.id.layscheese_textView);
        mushroomcheesetv = findViewById(R.id.mushroomcheese_textView);
		chickencheesetv = findViewById(R.id.chickencheese_textView);
		tandoorichickentv = findViewById(R.id.tandoorichicken_textView);
		bbqchickentv = findViewById(R.id.bbqchicken_textView);
		egggrilledtv = findViewById(R.id.egggrilled_textView);
		breadomelettetv = findViewById(R.id.breadomelette_textView);

        vegsp = (Button) findViewById(R.id.vegsp_button);
        veggcheese = (Button) findViewById(R.id.veggcheese_button);
        clubcheese = (Button) findViewById(R.id.clubcheese_button);
        garliccheese = (Button) findViewById(R.id.garliccheese_button);
        layscheese = (Button) findViewById(R.id.layscheese_button);
        mushroomcheese = (Button) findViewById(R.id.mushroomcheese_button);
        chickencheese = (Button) findViewById(R.id.chickencheese_button);
        tandoorichicken = (Button) findViewById(R.id.tandoorichicken_button);
        bbqchicken = (Button) findViewById(R.id.bbqchicken_button);
        egggrilled = (Button) findViewById(R.id.egggrilled_button);
        breadomelette = (Button) findViewById(R.id.breadomelette_button);
        

        rm_vegsp = (Button) findViewById(R.id.vegsp_button_rm);
        rm_veggcheese = (Button) findViewById(R.id.veggcheese_button_rm);
        rm_clubcheese = (Button) findViewById(R.id.clubcheese_button_rm);
        rm_garliccheese = (Button) findViewById(R.id.garliccheese_button_rm);
        rm_layscheese = (Button) findViewById(R.id.layscheese_button_rm);
        rm_mushroomcheese = (Button) findViewById(R.id.mushroomcheese_button_rm);
		rm_chickencheese = (Button) findViewById(R.id.chickencheese_button_rm);
		rm_tandoorichicken = (Button) findViewById(R.id.tandoorichicken_button_rm);

		rm_bbqchicken = (Button) findViewById(R.id.bbqchicken_button_rm);
		rm_egggrilled = (Button) findViewById(R.id.egggrilled_button_rm);
		rm_breadomelette = (Button) findViewById(R.id.breadomelette_button_rm);


        order = (Button) findViewById(R.id.order_button);


        vegspptv = findViewById(R.id.vegsp_price);
        veggcheeseptv = findViewById(R.id.veggcheese_price);
        clubcheeseptv = findViewById(R.id.clubcheese_price);
        garliccheeseptv = findViewById(R.id.garliccheese_price);
        layscheeseptv = findViewById(R.id.layscheese_price);
        mushroomcheeseptv = findViewById(R.id.mushroomcheese_price);
		chickencheeseptv = findViewById(R.id.chickencheese_price);
        tandoorichickenptv = findViewById(R.id.tandoorichicken_price);
        bbqchickenptv = findViewById(R.id.bbqchicken_price);
        egggrilledptv = findViewById(R.id.egggrilled_price);
        breadomeletteptv = findViewById(R.id.breadomelette_price);

		Typeface french_font = ResourcesCompat.getFont(this, R.font.french);
		Typeface stan_font = ResourcesCompat.getFont(this, R.font.stan);

        Typeface gatholic = ResourcesCompat.getFont(this, R.font.gatholic);

        menu.setTypeface(french_font);

        vegsptv.setTypeface(stan_font);
        veggcheesetv.setTypeface(stan_font);
        clubcheesetv.setTypeface(stan_font);
        garliccheesetv.setTypeface(stan_font);
        layscheesetv.setTypeface(stan_font);
        mushroomcheesetv.setTypeface(stan_font);
        chickencheesetv.setTypeface(stan_font);
        tandoorichickentv.setTypeface(stan_font);
        bbqchickentv.setTypeface(stan_font);
        egggrilledtv.setTypeface(stan_font);
        breadomelettetv.setTypeface(stan_font);



        vegspptv.setTypeface(gatholic);
        veggcheeseptv.setTypeface(gatholic);
        clubcheeseptv.setTypeface(gatholic);
        garliccheeseptv.setTypeface(gatholic);
        layscheeseptv.setTypeface(gatholic);
        mushroomcheeseptv.setTypeface(gatholic);
        chickencheeseptv.setTypeface(gatholic);
        tandoorichickenptv.setTypeface(gatholic);
        bbqchickenptv.setTypeface(gatholic);
        egggrilledptv.setTypeface(gatholic);
        breadomeletteptv.setTypeface(gatholic);



        order.setTypeface(gatholic);

    }


    public void place_order(View view) {

        balancesheet();
        Intent i = new Intent(MainActivity.this, orderDetails.class);
        Bundle bundle = new Bundle();
        bundle.putString("choice_iteams", choices);
        bundle.putString("total_price", prices);
        i.putExtras(bundle);
        startActivity(i);
        choices = "";
    }


    public void add_to_list(View view) {


        if (view == findViewById(R.id.vegsp_button)) {
            Toast.makeText(this, "Veg Sandwich Added", Toast.LENGTH_SHORT).show();
            vegspp = vegspp + 1;

            vegsp.setText(Integer.toString(vegspp));

        } else if (view == findViewById(R.id.veggcheese_button)) {
            Toast.makeText(this, "Veg cheese grilled sandwich Added", Toast.LENGTH_SHORT).show();
            veggcheesep = veggcheesep + 1;

            veggcheese.setText(Integer.toString(veggcheesep));

        } else if (view == findViewById(R.id.clubcheese_button)) {
            Toast.makeText(this, "Club cheese sandwich Added", Toast.LENGTH_SHORT).show();
            clubcheesep = clubcheesep + 1;
            clubcheese.setText(Integer.toString(clubcheesep));

        } else if (view == findViewById(R.id.garliccheese_button)) {
            Toast.makeText(this, "Garlic cheese sandwich Added", Toast.LENGTH_SHORT).show();
            garliccheesep = garliccheesep + 1;

            garliccheese.setText(Integer.toString(garliccheesep));
			
        } else if (view == findViewById(R.id.mushroomcheese_button)) {
            Toast.makeText(this, "Mushroom cheese sandwich Added", Toast.LENGTH_SHORT).show();
            mushroomcheesep = mushroomcheesep + 1;

            mushroomcheese.setText(Integer.toString(mushroomcheesep));
			
        } else if (view == findViewById(R.id.chickencheese_button)) {
            Toast.makeText(this, "Chicken cheese sandwich Added", Toast.LENGTH_SHORT).show();
            chickencheesep = chickencheesep + 1;

           chickencheese.setText(Integer.toString(chickencheesep));
		   
        } else if (view == findViewById(R.id.tandoorichicken_button)) {
            Toast.makeText(this, "Tandoori Chicken cheese sandwich Added", Toast.LENGTH_SHORT).show();
            tandoorichickenp = tandoorichickenp + 1;

           tandoorichicken.setText(Integer.toString(tandoorichickenp));
		   
        } else if (view == findViewById(R.id.bbqchicken_button)) {
            Toast.makeText(this, "BBQ sandwich Added", Toast.LENGTH_SHORT).show();
            bbqchickenp = bbqchickenp + 1;

           bbqchicken.setText(Integer.toString(bbqchickenp));
		   
        } else if (view == findViewById(R.id.egggrilled_button)) {
            Toast.makeText(this, "Egg grilled sandwich Added", Toast.LENGTH_SHORT).show();
            egggrilledp = egggrilledp + 1;

           egggrilled.setText(Integer.toString(egggrilledp));
		   
        } else if (view == findViewById(R.id.breadomelette_button)) {
            Toast.makeText(this, "Bread omelette sandwich Added", Toast.LENGTH_SHORT).show();
            breadomelettep = breadomelettep + 1;

           breadomelette.setText(Integer.toString(breadomelettep));
		   
        } else if (view == findViewById(R.id.layscheese_button)) {
            Toast.makeText(this, "Lays cheese sandwich Added", Toast.LENGTH_SHORT).show();
            layscheesep = layscheesep + 1;

           layscheese.setText(Integer.toString(layscheesep));
        }

    }


    public void rmv_from_list(View view) {

        if (view == findViewById(R.id.vegsp_button_rm)) {
            if (vegspp > 0) {

                vegspp = vegspp - 1;
                vegsp.setText(Integer.toString(vegspp));
                Toast.makeText(this, "Veg Sandwich(plain) Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.veggcheese_button_rm)) {

   
            if (veggcheesep > 0) {
               veggcheesep = veggcheesep - 1;

                veggcheese.setText(Integer.toString(veggcheesep));
                Toast.makeText(this, "Veg cheese grilled sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.clubcheese_button_rm)) {


            if (clubcheesep > 0) {

                clubcheesep = clubcheesep - 1;
                clubcheese.setText(Integer.toString(clubcheesep));
                Toast.makeText(this, "Club cheese sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.garliccheese_button_rm)) {
			
            if (garliccheesep > 0) {

                garliccheesep = garliccheesep - 1;
                garliccheese.setText(Integer.toString(garliccheesep));
                Toast.makeText(this, "Garlic cheese sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}

        } else if (view == findViewById(R.id.layscheese_button_rm)) {

           
            if (layscheesep > 0) {

                layscheesep = layscheesep - 1;
                layscheese.setText(Integer.toString(layscheesep));
                Toast.makeText(this, "Lays cheese sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}

        } else if (view == findViewById(R.id.mushroomcheese_button_rm)) {

            if (mushroomcheesep > 0) {
                mushroomcheesep = mushroomcheesep - 1;
                mushroomcheese.setText(Integer.toString(mushroomcheesep));
                Toast.makeText(this, "Mushroom cheese sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{

            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.chickencheese_button_rm)) {

            if (chickencheesep > 0) {
                chickencheesep = chickencheesep - 1;
                chickencheese.setText(Integer.toString(chickencheesep));
                Toast.makeText(this, "Chicken cheese sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.tandoorichicken_button_rm)) {

            if (tandoorichickenp > 0) {
                tandoorichickenp = tandoorichickenp - 1;
                tandoorichicken.setText(Integer.toString(tandoorichickenp));
                Toast.makeText(this, "Tandoori chicken cheese sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.bbqchicken_button_rm)) {

            if (bbqchickenp > 0) {
                bbqchickenp = bbqchickenp - 1;
                bbqchicken.setText(Integer.toString(bbqchickenp));
                Toast.makeText(this, "BBQ chicken sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{

            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.egggrilled_button_rm)) {

            if (egggrilledp > 0) {
                egggrilledp = egggrilledp - 1;
                egggrilled.setText(Integer.toString(egggrilledp));
                Toast.makeText(this, "Egg grilled sandwich Removed", Toast.LENGTH_SHORT).show();
            }
			else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
			}
        } else if (view == findViewById(R.id.breadomelette_button_rm)) {

            if (breadomelettep > 0) {
                breadomelettep = breadomelettep - 1;
                breadomelette.setText(Integer.toString(breadomelettep));
                Toast.makeText(this, "Bread omelette sandwich Removed", Toast.LENGTH_SHORT).show();
            }
				else{
            Toast.makeText(this, "Add Items First", Toast.LENGTH_SHORT).show();
				}
        }

    }

    public void balancesheet() {
        tvegspp = vegspp * 40;
        tveggcheesep = veggcheesep * 60;
        tclubcheesep = clubcheesep * 90;
        tgarliccheesep = garliccheesep * 80;
        tlayscheesep = layscheesep * 90;
        tmushroomcheesep = mushroomcheesep * 80;
		tchickencheesep = chickencheesep * 90;
		ttandoorichickenp = tandoorichickenp * 120;
		tbbqchickenp = bbqchickenp * 140;
		tegggrilledp = egggrilledp * 70;
		tbreadomelettep = breadomelettep * 70;
        total = tvegspp + tveggcheesep + tclubcheesep + tgarliccheesep + tlayscheesep + tmushroomcheesep + tchickencheesep + ttandoorichickenp + tbbqchickenp + tegggrilledp + tbreadomelettep;
        prices = Integer.toString(total);

        if (vegspp> 0) {
            choices = choices + "Veg Sandwich(plain) (" + vegspp + " x 40) = " + tvegspp;
        }

        if (veggcheesep > 0) {
            choices = choices + "\n\nVeg Cheese grilled sandwich (" + veggcheesep + " x 60) = " + tveggcheesep;
        }

        if (clubcheesep > 0) {
            choices = choices + "\n\nClub cheese sandwich (" + clubcheesep + " x 90) = " + tclubcheesep;
        }

        if (garliccheesep > 0) {
            choices = choices + "\n\nGarlic cheese sandwich (" + garliccheesep + " x 80) = " + tgarliccheesep;
        }
        if (layscheesep > 0) {
            choices = choices + "\n\nLays cheese sandwich (" + layscheesep + " x 90) = " + tlayscheesep;
        }

        if (mushroomcheesep > 0) {
            choices = choices + "\n\nMushroom cheese sandwich (" + mushroomcheesep + " x 80) = " + tmushroomcheesep;
        }
		
		if (chickencheesep > 0) {
            choices = choices + "\n\nChicken cheese sandwich (" + chickencheesep + " x 90) = " + tchickencheesep;
        }
		
		if (tandoorichickenp > 0) {
            choices = choices + "\n\nTandoori chicken cheese sandwich (" + tandoorichickenp + " x 120) = " + ttandoorichickenp;
        }
		
		if (bbqchickenp > 0) {
            choices = choices + "\n\nBBQ Chicken sandwich (" + bbqchickenp + " x 140) = " + tbbqchickenp;
        }
		
		if (egggrilledp > 0) {
            choices = choices + "\n\nEgg grilled sandwich (" + egggrilledp + " x 70) = " + tegggrilledp;
        }
		
		if (breadomelettep > 0) {
            choices = choices + "\n\nBread omelette sandwich (" + breadomelettep + " x 70) = " + tbreadomelettep;
        }


    }
}
