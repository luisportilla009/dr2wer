package com.example.calc.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private TextView put_Into;

    Button bpo;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        put_Into = view.findViewById(R.id.chain);
        Button b0 = view.findViewById(R.id.button_0);
        b0.setOnClickListener(this);
        Button b1 = view.findViewById(R.id.button_1);
        b1.setOnClickListener(this);
        Button b2 = view.findViewById(R.id.button_2);
        b2.setOnClickListener(this);
        Button b3 = view.findViewById(R.id.button_3);
        b3.setOnClickListener(this);
        Button b4 = view.findViewById(R.id.button_4);
        b4.setOnClickListener(this);
        Button b5 = view.findViewById(R.id.button_5);
        b5.setOnClickListener(this);
        Button b6 = view.findViewById(R.id.button_6);
        b6.setOnClickListener(this);
        Button b7 = view.findViewById(R.id.button_7);
        b7.setOnClickListener(this);
        Button b8 = view.findViewById(R.id.button_8);
        b8.setOnClickListener(this);
        Button b9 = view.findViewById(R.id.button_9);
        b9.setOnClickListener(this);
        Button bpl = view.findViewById(R.id.button_plus);
        bpl.setOnClickListener(this);
        Button bmi = view.findViewById(R.id.button_minus);
        bmi.setOnClickListener(this);
        Button bmu = view.findViewById(R.id.button_mul);
        bmu.setOnClickListener(this);
        Button bdi = view.findViewById(R.id.button_div);
        bdi.setOnClickListener(this);
        bpo = view.findViewById(R.id.button_point);
        bpo.setOnClickListener(this);
        Button beq = view.findViewById(R.id.button_equal);
        beq.setOnClickListener(this);
        Button bc = view.findViewById(R.id.button_clear);
        bc.setOnClickListener(this);
        Button bce = view.findViewById(R.id.button_clear_all);
        bce.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        int count_Par = 0;
        String total = put_Into.getText().toString();
        switch (view.getId()){
            case R.id.button_0:
                total = total + '0';
                break;
            case R.id.button_1:
                total = total + '1';
                break;
            case R.id.button_2:
                total = total + '2';
                break;
            case R.id.button_3:
                total = total + '3';
                break;
            case R.id.button_4:
                total = total + '4';
                break;
            case R.id.button_5:
                total = total + '5';
                break;
            case R.id.button_6:
                total = total + '6';
                break;
            case R.id.button_7:
                total = total + '7';
                break;
            case R.id.button_8:
                total = total + '8';
                break;
            case R.id.button_9:
                total = total + '9';
                break;
            case R.id.button_div:
                if(compare(total)) {
                    total = total + '/';

                    bpo.setEnabled(true);

                }
                break;
            case R.id.button_mul:
                if(compare(total)) {
                    total = total + '*';
                    bpo.setEnabled(true);
                }
                break;
            case R.id.button_minus:
                if(total.length() == 0) {
                    total = total + '-';
                    break;
                }
                if(compare2(total)) {
                    total = total + '-';
                    bpo.setEnabled(true);
                }
                break;
            case R.id.button_plus:
                if(compare(total)) {
                    total = total + '+';
                    bpo.setEnabled(true);
                }
                break;
            case R.id.button_point:
                if(compare(total)) {
                    total = total + '.';
                    bpo.setEnabled(false);
                }

                break;
            case R.id.button_equal:
                //if(compare(total)) total = String.valueOf(eval(total));
                if(compare(total)) {
                    DoubleEvaluator evaluator = new DoubleEvaluator();
                    total = evaluator.evaluate(total).toString();
                }
                break;
            /*case R.id.button_about:
                Intent about = new Intent(this,AboutActivity.class);
                startActivity(about);
                break;*/
            case R.id.button_clear:
                if(total.length() != 0) total = total.substring(0, total.length() - 1);
                //findViewById(R.id.button_point).setEnabled(true);
                break;
            case R.id.button_clear_all:
                while (total.length() != 0) total = total.substring(0, total.length() - 1);
                bpo.setEnabled(true);
                break;
            /*case R.id.button_par0:
                if(!compare(total)){
                    count_Par ++;
                    total = total + '(';
                    findViewById(R.id.button_point).setEnabled(true);
                }
                break;
            case R.id.button_par1:
                if(compare(total) && count_Par > 0){
                    count_Par --;
                    total = total + ')';
                    findViewById(R.id.button_point).setEnabled(true);
                }
                break;
            case R.id.button_p:
                total = total + '^';
                break;
            case R.id.button_sqrt:
                total = total + "sqrt";
                break;*/

        }
        if (total.equals("Infinity")) total = "";
        put_Into.setText(total);

    }

    private Boolean compare(String total){
        String list_0 = "0123456789";
        int i = 1;
        if (total.length() != 0) {
            while (total.charAt(total.length() - 1) != list_0.charAt(list_0.length() - i)
                    && i != 10 ) i++;
            return total.charAt(total.length() - 1) == list_0.charAt(list_0.length() - i);

        }
        return false;
    }
    private Boolean compare2(String total){
        String list_0 = "0123456789/*()";
        int i = 1;
        if (total.length() != 0) {
            while (total.charAt(total.length() - 1) != list_0.charAt(list_0.length() - i)
                    && i != 12 ) i++;
            return total.charAt(total.length() - 1) == list_0.charAt(list_0.length() - i);

        }
        return false;
    }
}