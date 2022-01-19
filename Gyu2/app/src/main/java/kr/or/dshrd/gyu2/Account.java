package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    RelativeLayout shop, explore, cart, favorite,account;
    TextView logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        shop = findViewById(R.id.shopLayout);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, Home.class);
                startActivity(intent);
            }
        });

        explore = findViewById(R.id.exploreLayout);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, Explore.class);
                startActivity(intent);
            }
        });

        cart = findViewById(R.id.cartLayout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, MyCart.class);
                startActivity(intent);
            }
        });

        favorite = findViewById(R.id.favoriteLayout);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, Favorite.class);
                startActivity(intent);
            }
        });

        logOut = findViewById(R.id.log_out);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, OnBoarding.class);
                startActivity(intent);
            }
        });

//        account.findViewById(R.id.account);
//        account.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Account.this, .class);
//                startActivity(intent);
//            }
//        });






        }
}