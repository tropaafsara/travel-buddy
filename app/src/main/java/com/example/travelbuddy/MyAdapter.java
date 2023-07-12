package com.example.travelbuddy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.security.AccessController;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private Context mContext;
    private List<PlaceData> myPlaceList;


    public MyAdapter(Context mContext, List<PlaceData> myPlaceList) {
        this.mContext = mContext;
        this.myPlaceList = myPlaceList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item,viewGroup, false);
        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {

        Glide.with(mContext).load(myPlaceList.get(i).getItemImage()).into(foodViewHolder.imageView);
        //foodViewHolder.imageView.setImageResource(myPlaceList.get(i).getItemImage());
        foodViewHolder.mTitle.setText(myPlaceList.get(i).getItemName());
        foodViewHolder.mDescription.setText(myPlaceList.get(i).getItemDescription());
        foodViewHolder.mPrice.setText(myPlaceList.get(i).getItemPrice());

        foodViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra("Image",myPlaceList.get(foodViewHolder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",myPlaceList.get(foodViewHolder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myPlaceList.size();
    }
}
class FoodViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mTitle, mDescription, mPrice;
    CardView mCardView;

    public FoodViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mPrice = itemView.findViewById(R.id.tvPrice);
        mCardView = itemView.findViewById(R.id.myCardView);



    }
}
