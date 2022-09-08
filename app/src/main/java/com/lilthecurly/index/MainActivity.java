package com.lilthecurly.index;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public Spinner spinner_weight;
    public Spinner spinner_height;
    public Spinner spinner_old;
    public String[] weight = new String[251];
    public String[] height = new String[222];
    public String[] old = new String[101];
    public static String weight_const = "Select your weight, kilograms";
    public static String height_const= "Select your height, centimeters";
    public static String old_const = "Select your age, years";
    public String weight_check;
    public String height_check;
    public String old_check;
    public TextView output;
    public Button button;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight[0] = weight_const;
        height[0] = height_const;
        old[0] = old_const;

        for(int i = 1; i < 251; i++){
            weight[i] = String.valueOf(i);
        }
        for(int i = 30; i < 251; i++){
            height[i-29] = String.valueOf(i);
        }
        for(int i = 1; i < 101; i++){
            old[i] = String.valueOf(i);
        }
        spinner_weight = findViewById(R.id.spinner_weight);
        spinner_height = findViewById(R.id.spinner_height);
        spinner_old = findViewById(R.id.spinner_old);
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);
        button.setText("Calculate IMT");
        ArrayAdapter<String> adapter_weight = new ArrayAdapter(this, android.R.layout.simple_spinner_item, weight);
        adapter_weight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_weight.setAdapter(adapter_weight);
        ArrayAdapter<String> adapter_height = new ArrayAdapter(this, android.R.layout.simple_spinner_item, height);
        adapter_height.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_height.setAdapter(adapter_height);
        ArrayAdapter<String> adapter_old = new ArrayAdapter(this, android.R.layout.simple_spinner_item, old);
        adapter_old.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_old.setAdapter(adapter_old);


        AdapterView.OnItemSelectedListener weightSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                weight_check = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        spinner_weight.setOnItemSelectedListener(weightSelectedListener);

        AdapterView.OnItemSelectedListener heightSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                height_check = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        spinner_height.setOnItemSelectedListener(heightSelectedListener);

        AdapterView.OnItemSelectedListener oldSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                old_check = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        spinner_old.setOnItemSelectedListener(oldSelectedListener);


        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(Objects.equals(weight_check, weight_const) || Objects.equals(height_check, height_const) || Objects.equals(old_check, old_const)){
                    output.setText("Choose your options");
                } else {
                    float weight_selected = Integer.parseInt(weight_check);
                    float height_selected = Integer.parseInt(height_check);
                    int old_selected = Integer.parseInt(old_check);
                    float height_meters = height_selected / 100;
                    float sqr = (float) Math.pow(height_meters, 2);
                    float res = weight_selected / sqr;
                    double imt = Math.ceil(res * 10) / 10;

                    String imt_const = String.valueOf(imt);

                    if(old_selected == 1){
                        if(imt < 18.6 & imt > 15.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 18.6){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 2){
                        if(imt < 18.0 & imt > 14.7){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 18.0){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 3){
                        if(imt < 17.6 & imt > 14.4){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 17.6){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 4){
                        if(imt < 17.5 & imt > 14.1){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 17.5){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 5){
                        if(imt < 17.5 & imt > 14.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 17.5){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 6){
                        if(imt < 17.7 & imt > 13.9){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 17.7){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 7){
                        if(imt < 18.5 & imt > 14.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 18.5){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 8){
                        if(imt < 18.8 & imt > 13.2){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 18.8){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 9){
                        if(imt < 19.8 & imt > 13.7){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 19.8){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 10){
                        if(imt < 20.7 & imt > 14.2){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 20.7){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 11){
                        if(imt < 20.8 & imt > 14.6){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 20.8){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 12){
                        if(imt < 21.5 & imt > 16.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 21.5){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 13){
                        if(imt < 22.1 & imt > 15.6){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 22.1){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 14){
                        if(imt < 23.2 & imt > 17.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 23.2){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 15){
                        if(imt < 23.2 & imt > 17.6){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 23.2){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 16){
                        if(imt < 22.8 & imt > 17.8){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 22.8){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected == 17){
                        if(imt < 23.4 & imt > 17.8){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 23.4){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected > 17 & old_selected <= 24){
                        if(imt < 24.0 & imt > 19.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 24.0){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected > 24 & old_selected <= 34){
                        if(imt < 25.0 & imt > 20.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 25.0){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected > 34 & old_selected <= 44){
                        if(imt < 26.0 & imt > 21.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 26.0){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected > 44 & old_selected <= 54){
                        if(imt < 27.0 & imt > 22.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 27.0){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected > 54 & old_selected <= 64){
                        if(imt < 28.0 & imt > 23.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 28.0){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                    if(old_selected > 64){
                        if(imt < 29.0 & imt > 24.0){
                            output.setText("Your IMT = " + imt_const + "\nThis is normal");
                        } else if(imt >= 29.0){
                            output.setText("Your IMT = " + imt_const + "\nIt's above normal");
                        }else{
                            output.setText("Your IMT = " + imt_const + "\nIt's below normal");
                        }
                    }
                }
            }
        });

    }
}