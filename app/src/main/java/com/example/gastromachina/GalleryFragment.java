package com.example.gastromachina;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GalleryFragment extends Fragment implements  AdapterView.OnItemSelectedListener{
    private boolean piotrkowskaviewisvisible = true, dabrowskiegoviewisvisible = false;
    private View piotrkowskaview, dabrowskiegoview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery,container,false);
        piotrkowskaview = rootView.findViewById(R.id.piotrkowskagallery);
        dabrowskiegoview = rootView.findViewById(R.id.dabrowskiegogallery);

        Spinner spinner = rootView.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.adresy,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selection = parent.getItemAtPosition(position).toString();

        switch (selection){
            case "Gastromachina Stacja - Piotrkowska":
                piotrkowskaview.setVisibility(View.VISIBLE);
                dabrowskiegoview.setVisibility(View.GONE);
                break;
            case "Gastromachina Stacja - Dąbrowskiego":
                piotrkowskaview.setVisibility(View.GONE);
                dabrowskiegoview.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
