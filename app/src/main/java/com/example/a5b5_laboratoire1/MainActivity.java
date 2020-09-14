package com.example.a5b5_laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button boutonValider = null;
    String validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Resources res = getResources();

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

        validation = res.getString(R.string.messageInvalide);
        TextView messageValidation = (TextView)findViewById(R.id.messageValidation);
        messageValidation.setText(validation);

        CheckBox voirMot = (CheckBox)findViewById(R.id.voirMotDePasse);
        
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 10;
                String password = null;
                int compteurNombre = 0;
                int compteurSpecial = 0;
                int compteurMaj = 0;
                int compteurMin = 0;

                TextView messageValide = (TextView)findViewById(R.id.messageValidation);

                TextView motdePasseFourni = (TextView)findViewById(R.id.passwordComplexe);
                password = motdePasseFourni.getText().toString();

                String msgValidation = res.getString(R.string.messageValide);
                String msgInvalidation = res.getString(R.string.messageInvalide);


                if (password.length() > min) {

                    char c;

                    for (int i = 0; i < password.length() ; i++) {
                        c = password.charAt(i);

                        if(Character.isLowerCase(c)) {
                            compteurMin++;
                        }

                        if(Character.isUpperCase(c)) {
                            compteurMaj++;
                        }

                        if(Character.isDigit(c)) {
                            compteurNombre++;
                        }

                        if(c >= 33 && c <= 46 || c == 64 ) {
                            compteurSpecial++;
                        }
                    }

                    if (compteurMin >= 1 && compteurMaj >= 1 && compteurNombre >= 1 && compteurSpecial >= 1) {
                        validation = msgValidation;
                        messageValide.setText(validation);
                        messageValide.setTextColor(res.getColor(R.color.vert));
                        compteurMaj = 0;
                        compteurMin = 0;
                        compteurNombre = 0;
                        compteurSpecial = 0 ;

                    } else {
                       validation = msgInvalidation;
                       messageValide.setText(validation);
                       messageValide.setTextColor(res.getColor(R.color.rouge));
                    }
                }
            }
        });
    }
}