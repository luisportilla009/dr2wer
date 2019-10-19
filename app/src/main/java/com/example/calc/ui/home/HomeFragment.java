package com.example.calc.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calc.R;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bpl,bmi,bmu,bdi,bpo,beq,bc,bce;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        b0 = view.findViewById(R.id.button_0);
        b1 = 
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}