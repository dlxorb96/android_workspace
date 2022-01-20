package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Favorite extends AppCompatActivity {

    RelativeLayout shop, explore, cart, account;
    TextView toCart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        shop = findViewById(R.id.shopLayout);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Favorite.this, Home.class);
                startActivity(intent);
            }
        });

        explore = findViewById(R.id.exploreLayout);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Favorite.this, Explore.class);
                startActivity(intent);
            }
        });

        cart = findViewById(R.id.cartLayout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Favorite.this, MyCart.class);
                startActivity(intent);
            }
        });
//
//        favorite = findViewById(R.id.favoriteLayout);
//        favorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Explore.this, Favorite.class);
//                startActivity(intent);
//            }
//        });

        account = findViewById(R.id.accountLayout);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Favorite.this, Account.class);
                startActivity(intent);
            }
        });

        toCart2 = findViewById(R.id.toCart2);
        toCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Favorite.this, MyCart.class);
                startActivity(intent);
            }
        });
    }
}