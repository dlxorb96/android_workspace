package kr.or.dshrd.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;


    // 에니변수 지정
    Animation topanim, bottomanim;
    ImageView image;
    TextView ttit,ttit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //상단 상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //변수에 애니메이션 설정하기
        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //this뒤에는 ,임 . 이 아님

        //hooks
        image=findViewById(R.id.Imageview);
        ttit= findViewById(R.id.tit1);
        ttit2= findViewById(R.id.tit2);


        //이미지와 텍스트에 애니메이션 연결
        image.setAnimation(topanim);
        ttit.setAnimation(bottomanim);
        ttit2.setAnimation(bottomanim);


        //다음페이지 넘길 splash 적용
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}