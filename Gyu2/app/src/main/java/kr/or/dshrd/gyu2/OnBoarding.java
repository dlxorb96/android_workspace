package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {

    Animation topanim, bottomanim;
    ImageView image;
    TextView ttit, ttit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding);

        //변수에 애니메이션 설정하기
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animateion);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image=findViewById(R.id.board_logo);
        ttit=findViewById(R.id.board_title);
        ttit2=findViewById(R.id.board_start);


        // 이미지와 텍스트에 애니메이션 연결
        image.setAnimation(topanim);
        ttit.setAnimation(topanim);
        ttit2.setAnimation(bottomanim);
    }
}