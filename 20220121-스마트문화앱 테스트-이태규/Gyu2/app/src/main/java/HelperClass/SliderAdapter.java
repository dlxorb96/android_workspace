package HelperClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import kr.or.dshrd.gyu2.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.banner,
            R.drawable.banner3,
            R.drawable.banner2,
    };

//    int headings[] = {
//            R.string.first_slider_title,
//            R.string.second_slider_title,
//            R.string.third_slider_title,
//    };
//
//    int descriptions[] = {
//            R.string.first_slider_desc,
//            R.string.second_slider_desc,
//            R.string.third_slider_desc,
//    };
    //배열의 길이
    @Override
    public int getCount() {
        return images.length;
    }

    //보여질 object의 layout
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }
    //포함되어 질 아이템의 위치정보임

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        //Hooks
        ImageView imageView = view.findViewById(R.id.home_banner);
//        TextView heading = view.findViewById(R.id.slider_heading);
//        TextView desc = view.findViewById(R.id.slider_desc);

        imageView.setImageResource(images[position]);
//        heading.setText(headings[position]);
//        desc.setText(descriptions[position]);

        container.addView(view);


        return view;
    }
    //컨트롤 o destroyItem
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
