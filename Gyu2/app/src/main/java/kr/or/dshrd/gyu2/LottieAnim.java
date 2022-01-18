package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class LottieAnim extends AppCompatActivity {

    Animation botanim;
    RelativeLayout apptitle;
    LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_anim);
        botanim= AnimationUtils.loadAnimation(this,R.anim.lottiebottom_animation);
        apptitle = findViewById(R.id.lottie_relative);
        apptitle.setAnimation(botanim);


        //hooks
//        lottie = findViewById(R.id.lottie);


        //animation
//        apptitle.animate().translationY(-500).setDuration(1500).setStartDelay(0);
//        lottie.animate()
//                .translationY(-300)
//                .setDuration(1500)
//                .setStartDelay(0);


//        화면 넘기기 이 부분업승면 화면 안넘어감
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(getApplicationContext(), GoogleMap.class);
//                startActivity(intent);
//            }
//        }, 4000);

    }
}