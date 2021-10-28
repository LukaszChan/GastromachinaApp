package com.example.gastromachina;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomepageFragment extends Fragment implements View.OnClickListener{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_homepage, container, false);

        Button btnorder = rootView.findViewById(R.id.BtnTropic);
        Button btnmenu = rootView.findViewById(R.id.Btnlearnmore);


        btnorder.setOnClickListener(this);
        btnmenu.setOnClickListener(this);

        return rootView;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnTropic:
                Toast.makeText(getActivity(),"Dodano do koszyka!",Toast.LENGTH_LONG).show();
                break;
            case R.id.Btnlearnmore:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,
                        new MenuFragment()).commit();
                break;
        }
    }
}
