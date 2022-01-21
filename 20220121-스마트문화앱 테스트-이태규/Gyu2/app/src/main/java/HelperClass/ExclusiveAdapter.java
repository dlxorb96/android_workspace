package HelperClass;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.or.dshrd.gyu2.R;

public class ExclusiveAdapter extends RecyclerView.Adapter<ExclusiveAdapter.ExclusiveViewHolder> {

    //배열 선언
    ArrayList<ExclusiveHelperClass> exclusiveLocation;
    //ExclusiveHelperClass안에 데이터 사용하겠다는 뜻이다

    // generate -> constructor
    public ExclusiveAdapter(ArrayList<ExclusiveHelperClass> exclusiveLocation) {
        this.exclusiveLocation = exclusiveLocation;
    }


    //우클릭 implement methods 누르니 자동으로 생성
    @NonNull
    @Override
// onCreateViewHolder()
// ViewHolder 를 새로 만들어야 할 때 호출되는 메소드로,
// 이를 통해 각 아이템을 위한 XML 레이아웃을 활용한 뷰 객체를
// 생성하고 이를 뷰 홀더 객체에 담아 리턴해준다. 다만 ViewHolder 가
// 아직 어떠한 데이터에 바인딩된 상태가 아니기 때문에 각 뷰의 내용 (TextView 의 Text 등) 은 채우지 않는다.
    public ExclusiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exclusive_design,parent,false);
        ExclusiveViewHolder exclusiveViewHolder = new ExclusiveViewHolder(view);

        return exclusiveViewHolder;
    }

    //    onBindViewHolder()
//    ViewHolder 를 어떠한 데이터와 연결할 때 호출되는 메소드로, 이를 통해
//    뷰 홀더 객체들의 레이아웃을 채우게 된다. position 이라는 파라미터를
//    활용하여 데이터의 순서에 맞게 아이템 레이아웃을 바인딩해줄 수 있다.
    @Override
    public void onBindViewHolder(@NonNull ExclusiveViewHolder holder, int position) {

        ExclusiveHelperClass exclusiveHelperClass = exclusiveLocation.get(position);
        holder.image.setImageResource(exclusiveHelperClass.getImage());
        holder.title.setText(exclusiveHelperClass.getTitle());
        holder.price.setText(exclusiveHelperClass.getPrice());


    }

    @Override
    public int getItemCount() {
        return exclusiveLocation.size();
        //개수가 몇개냐?
    }


    public static class ExclusiveViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView price;



        public ExclusiveViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.exclusive_image);
            title = itemView.findViewById(R.id.exclusive_title);
            price = itemView.findViewById(R.id.exclusive_price);

        }
    }

}





