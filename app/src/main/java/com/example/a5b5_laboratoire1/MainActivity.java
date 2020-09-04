package com.example.a5b5_laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        String messageUtilisateur = res.getString(R.string.courriel);
        TextView courrielUtilisateur = (TextView)findViewById(R.id.courrielUtilisateur);
        courrielUtilisateur.setText(messageUtilisateur);

        String messageMotDePasse = res.getString(R.string.password);
        TextView motDePasse = (TextView)findViewById(R.id.passwordComplexe);
        motDePasse.setText(messageMotDePasse);

        String messageVoir = res.getString(R.string.voirMot);
        CheckBox choixVoir = (CheckBox)findViewById(R.id.voirMotDePasse);
        choixVoir.setText(messageVoir);

        String messageValider = res.getString(R.string.validerBouton);
        Button boutonValider = (Button) findViewById(R.id.validerMotDePasse);
        boutonValider.setText(messageValider);
    }
}