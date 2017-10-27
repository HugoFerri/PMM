package com.example.hugtra.spinnerpersona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        webView1 = (WebView) findViewById(R.id.webView1);

        Bundle bundle = getIntent().getExtras();
        webView1.loadUrl("http://" + bundle.getString("direccion"));
    }
}
