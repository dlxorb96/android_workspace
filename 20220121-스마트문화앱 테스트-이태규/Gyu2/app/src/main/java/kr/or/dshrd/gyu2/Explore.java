package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Explore extends AppCompatActivity {

    RelativeLayout shop, explore, cart, favorite, account;

    LinearLayout menu1, menu2, menu3, menu4, menu5, menu6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_explore);

        shop = findViewById(R.id.shopLayout);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Home.class);
                startActivity(intent);
            }
        });
//
//        explore = findViewById(R.id.exploreLayout);
//        explore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Account.this, Explore.class);
//                startActivity(intent);
//            }
//        });

        cart = findViewById(R.id.cartLayout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, MyCart.class);
                startActivity(intent);
            }
        });

        favorite = findViewById(R.id.favoriteLayout);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Favorite.class);
                startActivity(intent);
            }
        });

        account = findViewById(R.id.accountLayout);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Account.class);
                startActivity(intent);
            }
        });

        menu1 = findViewById(R.id.menu_1);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Beverage.class);
                startActivity(intent);
            }
        });

        menu2 = findViewById(R.id.menu_2);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Beverage.class);
                startActivity(intent);
            }
        });

        menu3 = findViewById(R.id.menu_3);
        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Beverage.class);
                startActivity(intent);
            }
        });

        menu4 = findViewById(R.id.menu_4);
        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Beverage.class);
                startActivity(intent);
            }
        });

        menu5 = findViewById(R.id.menu_5);
        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Beverage.class);
                startActivity(intent);
            }
        });

        menu6 = findViewById(R.id.menu_6);
        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Explore.this, Beverage.class);
                startActivity(intent);
            }
        });

    }
}