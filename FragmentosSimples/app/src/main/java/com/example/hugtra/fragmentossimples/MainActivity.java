package com.example.hugtra.fragmentossimples;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox aparece;
    View mioFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mioFrag = (View) findViewById(R.id.ejemplo);


        aparece = (CheckBox) findViewById(R.id.checkbox);

        aparece.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (aparece.isChecked())
                    mioFrag.setVisibility(View.VISIBLE);
                else
                    mioFrag.setVisibility(View.INVISIBLE);
            }
        });
    }
}
