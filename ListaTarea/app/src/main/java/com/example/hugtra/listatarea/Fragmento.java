package com.example.hugtra.listatarea;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragmento extends Fragment {
    int mNum;
    static Fragmento newInstance(int number) {
        Fragmento f = new Fragmento();
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = null;
        View tv = null;
        if (mNum % 2 == 0){
            v = inflater.inflate(R.layout.fragmento, container, false);
            tv = v.findViewById(R.id.text);            }
        else{
            v = inflater.inflate(R.layout.fragmento , container, false);
            tv = v.findViewById(R.id.text2);            }

        ((TextView)tv).setText("Fragmento numero #" + mNum);
        return v;
    }
}