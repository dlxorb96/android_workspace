package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import HelperClass.BestSellingAdapter;
import HelperClass.BestSellingHelperClass;
import HelperClass.ExclusiveAdapter;
import HelperClass.ExclusiveHelperClass;
import HelperClass.GroceryBotAdapter;
import HelperClass.GroceryHelperClassBot;
import HelperClass.GroceryHelperClassTop;
import HelperClass.GroceryTopAdapter;
import HelperClass.SliderAdapter;

public class Home extends AppCompatActivity {

    RecyclerView exclusive_offer_recyclerview, best_selling_recycler, Groceries_recycler1, Groceries_recycler2;
    RecyclerView.Adapter adapter;
//    private GradientDrawable color1, color2, color3, color4;
    RelativeLayout shop, explore, cart, favorite, account;


        //변수선언
        ViewPager viewPager;
        LinearLayout dotsLayout;

        SliderAdapter sliderAdapter;
//        TextView[] dots;


        int currentPos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        TextView click_event;


        viewPager = findViewById(R.id.home_viewpager);
//        dotsLayout = findViewById(R.id.dots);


        //Call Adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

//        addDots(0);



        viewPager.addOnPageChangeListener(changeListener);



        click_event = findViewById(R.id.click_event);
        click_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ProductDetail.class);
                startActivity(intent);
            }
        });

        explore = findViewById(R.id.exploreLayout);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Explore.class);
                startActivity(intent);
            }
        });

        cart = findViewById(R.id.cartLayout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MyCart.class);
                startActivity(intent);
            }
        });

        favorite = findViewById(R.id.favoriteLayout);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Favorite.class);
                startActivity(intent);
            }
        });

        account = findViewById(R.id.accountLayout);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Account.class);
                startActivity(intent);
            }
        });

        //Hooks
        exclusive_offer_recyclerview = findViewById(R.id.exclusive_offer_recyclerview);
        best_selling_recycler = findViewById(R.id.best_selling_recycler);
        Groceries_recycler1 = findViewById(R.id.Groceries_recycler1);
        Groceries_recycler2 = findViewById(R.id.Groceries_recycler2);


        exclusive_offer_recyclerview();
        best_selling_recycler();
        Groceries_recycler1();
        Groceries_recycler2();

    }

    public void next(View view){
        viewPager.setCurrentItem(currentPos + 1);
    }

//    private void addDots(int position){
//        dots = new TextView[3];
//        dotsLayout.removeAllViews();
//
//        for (int i = 0; i < dots.length; i++){
//            dots[i] = new TextView(this);
//            dots[i].setText(Html.fromHtml(	"&#8226"));
//            dots[i].setTextSize(35);
//            dotsLayout.addView(dots[i]);
//        }
//
//        if(dots.length > 0){
//            dots[position].setTextColor(getResources().getColor(R.color.main_color));
//        }
//
//    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

//            addDots(position);

            currentPos = position;
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };





    private void exclusive_offer_recyclerview() {
        ArrayList<ExclusiveHelperClass> exclusiveLocation = new ArrayList<>();

        //Hooks
        adapter = new ExclusiveAdapter(exclusiveLocation);
        exclusive_offer_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        exclusive_offer_recyclerview.setAdapter(adapter);

        //잡아넣는 작업
        exclusiveLocation.add(new ExclusiveHelperClass(R.drawable.banana, "delicious banana", "$10.9"));
        exclusiveLocation.add(new ExclusiveHelperClass(R.drawable.apple, "delicious apple","$2085"));
        exclusiveLocation.add(new ExclusiveHelperClass(R.drawable.banana, "asdmwmmmmasd","$11111"));
        exclusiveLocation.add(new ExclusiveHelperClass(R.drawable.apple, "dasqqsca","$5.51"));
    }

    private void best_selling_recycler() {
        ArrayList<BestSellingHelperClass> bestsellingLocation = new ArrayList<>();

        //Hooks
        adapter = new BestSellingAdapter(bestsellingLocation);
        best_selling_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        best_selling_recycler.setAdapter(adapter);

        //잡아넣는 작업
        bestsellingLocation.add(new BestSellingHelperClass(R.drawable.pepper, "doctor pepper", "$22.9"));
        bestsellingLocation.add(new BestSellingHelperClass(R.drawable.ginger, "what is ginger?","$215"));
        bestsellingLocation.add(new BestSellingHelperClass(R.drawable.pepper, "i'm so sick","$111"));
        bestsellingLocation.add(new BestSellingHelperClass(R.drawable.ginger, "tomorrow~!","$10.51"));

    }

    private void Groceries_recycler1() {
        GradientDrawable color1, color2, color3, color4;

        ArrayList<GroceryHelperClassTop> groceryTopLocation = new ArrayList<>();

        //Hooks
        adapter = new GroceryTopAdapter(groceryTopLocation);
        Groceries_recycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Groceries_recycler1.setAdapter(adapter);

        color1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFDAC7FB, 0xFFDAC7FB});
        color2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFA1D5FF,0xFFA1D5FF});
        color3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFA4FFB4,0xFFA4FFB4});
        color4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFFF7B1,0xFFFFF7B1});

        //잡아넣는 작업
        groceryTopLocation.add(new GroceryHelperClassTop(R.drawable.beef_bone, "beef bone", color1));
        groceryTopLocation.add(new GroceryHelperClassTop(R.drawable.broller_chicken, "woo~~",color2));
        groceryTopLocation.add(new GroceryHelperClassTop(R.drawable.beef_bone, "home",color3));
        groceryTopLocation.add(new GroceryHelperClassTop(R.drawable.broller_chicken, "Friday",color4));

    }



    private void Groceries_recycler2() {

        ArrayList<GroceryHelperClassBot> groceryBotLocation = new ArrayList<>();

        //Hooks
        adapter = new GroceryBotAdapter(groceryBotLocation);
        Groceries_recycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Groceries_recycler2.setAdapter(adapter);

        //잡아넣는 작업
        groceryBotLocation.add(new GroceryHelperClassBot(R.drawable.beef_bone, "doctor pepper", "$22.9"));
        groceryBotLocation.add(new GroceryHelperClassBot(R.drawable.pulses, "what is ginger?","$215"));
        groceryBotLocation.add(new GroceryHelperClassBot(R.drawable.beef_bone, "i'm so sick","$111"));
        groceryBotLocation.add(new GroceryHelperClassBot(R.drawable.pulses, "tomorrow~!","$10.51"));

    }




}