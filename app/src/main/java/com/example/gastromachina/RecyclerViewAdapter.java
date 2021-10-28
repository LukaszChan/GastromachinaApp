package com.example.gastromachina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private String[] menuItemNames, menuItemDescriptions, menuItemPrices;
    private int[] menuItemImages;
    private Context context;

    public RecyclerViewAdapter(Context context, String[] menuItemNames, String[] menuItemDescriptions, String[] menuItemPrices, int[] menuItemImages){
        this.context = context;
        this.menuItemNames = menuItemNames;
        this.menuItemDescriptions = menuItemDescriptions;
        this.menuItemPrices = menuItemPrices;
        this.menuItemImages = menuItemImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.itemName.setText(menuItemNames[position]);
        myViewHolder.itemDescription.setText(menuItemDescriptions[position]);
        myViewHolder.itemImage.setImageResource(menuItemImages[position]);
        myViewHolder.itemButton.setText(menuItemPrices[position]);
        myViewHolder.itemButton.setOnClickListener(v ->
                Toast.makeText(context,"Dodano do koszyka!",Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return menuItemNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView itemName,itemDescription;
        ImageView itemImage;
        Button itemButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.menu_item_name_txt);
            itemDescription = itemView.findViewById(R.id.menu_item_description_txt);
            itemImage = itemView.findViewById(R.id.menu_item_image);
            itemButton = itemView.findViewById(R.id.menu_item_price_btn);
        }
    }
}
