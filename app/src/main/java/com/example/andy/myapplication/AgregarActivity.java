package com.example.andy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;



public class EditarSerieActivity extends AppCompatActivity {
    private EditText editHora;
    private Button btnAgregar;
    private RadioButton rbOpcion1;
    private RadioButton rbOpcion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        this.editHora = (EditText) findViewById(R.id.editHora);
        this.btnAgregar = (Button) findViewById(R.id.btnAgregar);
        this.rbOpcion1 = (RadioButton) findViewById(R.id.rbOpcion1);
        this.rbOpcion2 = (RadioButton) findViewById(R.id.rbOpcion2);

  
        
        public void onRadioClicked(View view)
      {
        boolean isChecked = ((RadioButton) view).isChecked();

        // Selección según el radio que llegó al método
        switch(view.getId()) {
            case R.id.rbOpcion1:
                if (isChecked) data.setSubjectData(this.rbOpcion1.getText);
                break;
            case R.id.rbOpcion2:
                if (isChecked) data.setSubjectData(this.rbOpcion2.getText);
                break;
        }
      }
        
        
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            
               
                data.setLink(editCategoria.getText());

                if(true) {
                    Toast.makeText(getApplicationContext(), "Agregado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No Agregado", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
