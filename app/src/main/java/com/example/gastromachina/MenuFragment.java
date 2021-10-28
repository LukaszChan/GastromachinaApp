package com.example.gastromachina;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MenuFragment extends Fragment implements View.OnClickListener {
    private View klasyczneview, autorskieview, dodatkiview, slodkieview, bbqview, napojeview;
    private TextView tvklasyczne, tvautorskie, tvdodatki, tvslodkie, tvbbq, tvnapoje;

    private final int[] menuImagesKlasyczne = {R.drawable.klasyczny_klasyk,R.drawable.cheesburger,R.drawable.cheese_and_bacon,R.drawable.vege_burger,R.drawable.mega_machina};
    private final int[] menuImagesAutorskie = {R.drawable.zart_tropikow,R.drawable.maczeta,R.drawable.czarna_perla,R.drawable.cheese_steryd,R.drawable.cheesus_christ,R.drawable.smash_bro};
    private final int[] menuImagesDodatki = {R.drawable.nachosy,R.drawable.zakrecone_frytki,R.drawable.frytki,R.drawable.bataty,R.drawable.onion_rings,R.drawable.kimchi,R.drawable.jalapeno};
    private final int[] menuImagesSlodkie = {R.drawable.torba,R.drawable.pasta_orzechowa};
    private final int[] menuImagesBbq = {R.drawable.zeberka,R.drawable.smalec};
    private final int[] menuImagesNapoje = {R.drawable.bombilla_classic,R.drawable.lemoniada_moon,R.drawable.sok_szot,R.drawable.pepsi,R.drawable.tonic};

    private final int[] names = {R.array.item_names_klasyczne, R.array.item_names_autorskie, R.array.item_names_dodatki, R.array.item_names_slodkie,
                    R.array.item_names_bbq, R.array.item_names_napoje};

    private final int[] descriptions = {R.array.item_descriptions_klasyczne, R.array.item_descriptions_autorskie, R.array.item_descriptions_dodatki, R.array.item_descriptions_slodkie,
                    R.array.item_descriptions_bbq, R.array.item_descriptions_napoje};

    private final int[] prices = {R.array.item_prices_klasyczne, R.array.item_prices_autorskie, R.array.item_prices_dodatki, R.array.item_prices_slodkie, R.array.item_prices_bbq,
                    R.array.item_prices_napoje};


    private String[] menuItemNames;
    private String[] menuItemDescriptions;
    private String[] menuItemPrices;

    private void setRecyclerData(int position){
        menuItemNames = getResources().getStringArray(names[position]);
        menuItemDescriptions = getResources().getStringArray(descriptions[position]);
        menuItemPrices = getResources().getStringArray(prices[position]);
    }

    private void changeVisibility(View view, TextView text){
            if (view.getVisibility() == View.VISIBLE) {
                view.setVisibility(View.GONE);
                text.setTextColor(getResources().getColor(R.color.white));
            } else {
                view.setVisibility(View.VISIBLE);
                text.setTextColor(getResources().getColor(R.color.dark_yellow));
            }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        LinearLayout klasycznetoggle, autorskietoggle, dodatkitoggle, slodkietoggle, bbqtoggle, napojetoggle;

        RecyclerView recyclerView;
        RecyclerViewAdapter klasyczneAdapter, autorskieAdapter, dodatkiAdapter, slodkieAdapter, bbqAdapter, napojeAdapter;

        klasyczneview = rootView.findViewById(R.id.klasyczne);
        klasycznetoggle = rootView.findViewById(R.id.klasyczne_toggle);
        tvklasyczne = rootView.findViewById(R.id.Tvklasyczne);

        setRecyclerData(0);
        recyclerView = rootView.findViewById(R.id.recyclerView_klasyczne);
        klasyczneAdapter = new RecyclerViewAdapter(getContext(),menuItemNames,menuItemDescriptions,menuItemPrices,menuImagesKlasyczne);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(klasyczneAdapter);

        autorskieview = rootView.findViewById(R.id.autorskie);
        autorskietoggle = rootView.findViewById(R.id.autorskie_toggle);
        tvautorskie = rootView.findViewById(R.id.Tvautorskie);

        setRecyclerData(1);
        recyclerView = rootView.findViewById(R.id.recyclerView_autorskie);
        autorskieAdapter = new RecyclerViewAdapter(getContext(),menuItemNames,menuItemDescriptions,menuItemPrices,menuImagesAutorskie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(autorskieAdapter);

        dodatkiview = rootView.findViewById(R.id.dodatki);
        dodatkitoggle = rootView.findViewById(R.id.dodatki_toggle);
        tvdodatki = rootView.findViewById(R.id.Tvdodatki);

        setRecyclerData(2);
        recyclerView = rootView.findViewById(R.id.recyclerView_dodatki);
        dodatkiAdapter = new RecyclerViewAdapter(getContext(),menuItemNames,menuItemDescriptions,menuItemPrices,menuImagesDodatki);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(dodatkiAdapter);

        slodkieview = rootView.findViewById(R.id.slodkie);
        slodkietoggle = rootView.findViewById(R.id.slodkie_toggle);
        tvslodkie = rootView.findViewById(R.id.Tvslodkie);

        setRecyclerData(3);
        recyclerView = rootView.findViewById(R.id.recyclerView_slodkie);
        slodkieAdapter= new RecyclerViewAdapter(getContext(),menuItemNames,menuItemDescriptions,menuItemPrices,menuImagesSlodkie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(slodkieAdapter);

        bbqview = rootView.findViewById(R.id.bbq);
        bbqtoggle = rootView.findViewById(R.id.bbq_toggle);
        tvbbq = rootView.findViewById(R.id.Tvbbq);

        setRecyclerData(4);
        recyclerView = rootView.findViewById(R.id.recyclerView_bbq);
        bbqAdapter = new RecyclerViewAdapter(getContext(),menuItemNames,menuItemDescriptions,menuItemPrices,menuImagesBbq);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(bbqAdapter);

        napojeview = rootView.findViewById(R.id.napoje);
        napojetoggle = rootView.findViewById(R.id.napoje_toggle);
        tvnapoje = rootView.findViewById(R.id.Tvnapoje);

        setRecyclerData(5);
        recyclerView = rootView.findViewById(R.id.recyclerView_napoje);
        napojeAdapter = new RecyclerViewAdapter(getContext(),menuItemNames,menuItemDescriptions,menuItemPrices,menuImagesNapoje);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(napojeAdapter);

        klasycznetoggle.setOnClickListener(this);
        autorskietoggle.setOnClickListener(this);
        dodatkitoggle.setOnClickListener(this);
        slodkietoggle.setOnClickListener(this);
        bbqtoggle.setOnClickListener(this);
        napojetoggle.setOnClickListener(this);



        return rootView;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.klasyczne_toggle:
                changeVisibility(klasyczneview,tvklasyczne);
                break;
            case R.id.autorskie_toggle:
                changeVisibility(autorskieview,tvautorskie);
                break;
            case R.id.dodatki_toggle:
                changeVisibility(dodatkiview,tvdodatki);
                break;
            case R.id.slodkie_toggle:
                changeVisibility(slodkieview,tvslodkie);
                break;
            case R.id.bbq_toggle:
                changeVisibility(bbqview,tvbbq);
                break;
            case R.id.napoje_toggle:
                changeVisibility(napojeview,tvnapoje);
                break;

        }

    }
}
