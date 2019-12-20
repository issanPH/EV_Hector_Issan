package com.example.andy.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    
    private int codPosicion =0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = findViewById(R.id.list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        arrayList.add(new SubjectData("PM", "4:00", ""));
        arrayList.add(new SubjectData("PM", "5:00", ""));
        arrayList.add(new SubjectData("AM", "6:00", ""));
        arrayList.add(new SubjectData("AM", "6:30", ""));
        arrayList.add(new SubjectData("AM", "7:00", ""));
        arrayList.add(new SubjectData("PM", "12:00", ""));
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
        
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirmación");
        builder.setMessage("¿Desea borrar?");
        builder.setPositiveButton("Si, borrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
               
                        if(arrayList.remove(codPosicion)){
                            Toast.makeText(getApplicationContext(), "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "No se ha podido eliminar", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        
        
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                dialog.show();
                return true;
            }
        });
        
        listSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPodicion = posicion;
                abrirEditarActivity();
            }
        });
    }
    
    
    private void abrirEditarActivity() {
        Intent intento = new Intent(MainActivity.this, EditarActivity.class);

        intento.putExtra("item", arrayList.get(codPosicion);
        startActivityForResult(intento, 100);
    }
    
    @Override
    public void onResume(){
            super.onResume();
            actualizarLista();
        
        }
    
    private void actualizarLista() {
        CustomAdapter.clear();
        CustomAdapter.addAll(arrayList);
        CustomAdapter.notifyDataSetChanged();
        
    }
    
    
}
