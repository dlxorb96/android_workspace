package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MyCart extends AppCompatActivity {


    RelativeLayout shop, explore, favorite, account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);


            shop = findViewById(R.id.shopLayout);
            shop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyCart.this, Home.class);
                    startActivity(intent);
                }
            });

            explore = findViewById(R.id.exploreLayout);
            explore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyCart.this, Explore.class);
                    startActivity(intent);
                }
            });

//            cart = findViewById(R.id.cartLayout);
//            cart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MyCart.this, MyCart.class);
//                    startActivity(intent);
//                }
//            });

        favorite = findViewById(R.id.favoriteLayout);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCart.this, Favorite.class);
                startActivity(intent);
            }
        });

            account = findViewById(R.id.accountLayout);
            account.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyCart.this, Account.class);
                    startActivity(intent);
                }
            });

    }
}