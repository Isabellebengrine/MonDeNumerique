package org.isa.monde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    //declare elements of layout :
    private TextView resultatRandom;
    private TextView rappelNbFaces;
    private Button btnRelancer;
    private int nbChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Récupère les infos de Intent
        Intent intent = getIntent();
        nbChoisi = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        //get view elements and put them in the members:
        rappelNbFaces = findViewById(R.id.rappelNb);
        btnRelancer = (Button) findViewById(R.id.btnRelancer);
        resultatRandom = findViewById(R.id.resultatRandom);

        // Récupère les infos de Intent

        rappelNbFaces.setText(String.valueOf(nbChoisi));

        // génération d'un nombre >= 0 et <nbChoisi et affichage du nombre aléatoire +1 (donc entre 1 et nbChoisi):
        Random r = new Random();
        int n = r.nextInt(nbChoisi);
        resultatRandom.setText(String.valueOf(n+1));

        //make listener to work here with button 'btnRelancer' :
        btnRelancer.setOnClickListener((View.OnClickListener) this);
        relancer();
    }

    //à revoir: méthode me renvoit sur mainacty au lieu de changer directement le resultatRandom :
    public void relancer() {
        // génération d'un nombre entre 1 et nbChoisi
        Random r1 = new Random();
        int n1 = r1.nextInt(nbChoisi) +1;
        //affiche n1 :
        resultatRandom.setText(String.valueOf(n1));
    }

    @Override
    public void onClick(View v) {
        if (v == btnRelancer){
            relancer();
        }
    }
}