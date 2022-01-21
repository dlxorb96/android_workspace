package kr.or.dshrd.gyu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PopUp extends AppCompatActivity {

    ImageView pop_close;
    TextView pop_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pop_up);


        pop_btn = findViewById(R.id.pop_btn);
        pop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PopUp.this, LottieAnim.class);
                startActivity(intent);
            }
        });

        pop_close = findViewById(R.id.pop_close);
        pop_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(PopUp.this, LottieAnim.class);
//                startActivity(intent);
                finish();
            }
        });



    }
    public boolean onTouchEvent(MotionEvent event){
        pop_btn = findViewById(R.id.pop_btn);
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }
}