package org.isa.monde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "org.isa.monde.MESSAGE";

    //declare elements of layout :
    private EditText nbDeFaces;
    private Button btnLancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get view elements and put them in the members:
        nbDeFaces = findViewById(R.id.nbDeFaces);
        btnLancer = findViewById(R.id.btnLancer);

        //make listener to work here with button 'btnLancer' :
        btnLancer.setOnClickListener(this);

    }

    //this method comes from interface view.onclicklistener and enables to get the event associated with the button:
    @Override
    public void onClick(View v) {
        Intent ResultActivity = new Intent(this, ResultActivity.class);

        Integer nbChoisi = Integer.parseInt(String.valueOf(nbDeFaces.getText()));

        ResultActivity.putExtra(EXTRA_MESSAGE, nbChoisi);
        startActivity(ResultActivity);
    }
}