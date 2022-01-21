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

public class GroceryBotAdapter extends RecyclerView.Adapter<GroceryBotAdapter.GroceryBotViewHolder> {

    //배열 선언
    ArrayList<GroceryHelperClassBot> groceryBotLocation;
    //GroceryBotHelperClass안에 데이터 사용하겠다는 뜻이다

    // generate -> constructor
    public GroceryBotAdapter(ArrayList<GroceryHelperClassBot> groceryBotLocation) {
        this.groceryBotLocation = groceryBotLocation;
    }


    //우클릭 implement methods 누르니 자동으로 생성
    @NonNull
    @Override
// onCreateViewHolder()
// ViewHolder 를 새로 만들어야 할 때 호출되는 메소드로,
// 이를 통해 각 아이템을 위한 XML 레이아웃을 활용한 뷰 객체를
// 생성하고 이를 뷰 홀더 객체에 담아 리턴해준다. 다만 ViewHolder 가
// 아직 어떠한 데이터에 바인딩된 상태가 아니기 때문에 각 뷰의 내용 (TextView 의 Text 등) 은 채우지 않는다.
    public GroceryBotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_bot_design,parent,false);
        GroceryBotViewHolder groceryBotViewHolder = new GroceryBotViewHolder(view);

        return groceryBotViewHolder;
    }

    //    onBindViewHolder()
//    ViewHolder 를 어떠한 데이터와 연결할 때 호출되는 메소드로, 이를 통해
//    뷰 홀더 객체들의 레이아웃을 채우게 된다. position 이라는 파라미터를
//    활용하여 데이터의 순서에 맞게 아이템 레이아웃을 바인딩해줄 수 있다.
    @Override
    public void onBindViewHolder(@NonNull GroceryBotViewHolder holder, int position) {

        GroceryHelperClassBot groceryBotHelperClass = groceryBotLocation.get(position);
        holder.image.setImageResource(groceryBotHelperClass.getImage());
        holder.title.setText(groceryBotHelperClass.getTitle());
        holder.price.setText(groceryBotHelperClass.getPrice());


    }

    @Override
    public int getItemCount() {
        return groceryBotLocation.size();
        //개수가 몇개냐?
    }


    public static class GroceryBotViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView price;



        public GroceryBotViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.grocery_bot_design_image);
            title = itemView.findViewById(R.id.grocery_bot_design_title);
            price = itemView.findViewById(R.id.grocery_bot_design_price);

        }
    }

}





