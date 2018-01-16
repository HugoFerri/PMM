package com.example.hugtra.fragmentosdinamico;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SimpleFragment extends Fragment {
    int mNum;
    static SimpleFragment newInstance(int number) {
        SimpleFragment f = new SimpleFragment();
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
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            tv = v.findViewById(R.id.text);            }
        else{
            v = inflater.inflate(R.layout.fragment_simple2 , container, false);
            tv = v.findViewById(R.id.text2);            }

        ((TextView)tv).setText("Fragmento numero #" + mNum);
        return v;
    }
}