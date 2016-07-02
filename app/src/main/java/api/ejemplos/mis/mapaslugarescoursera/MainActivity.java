package api.ejemplos.mis.mapaslugarescoursera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    GridView gridViewLugares;

    static final String[] LUGARES = new String[] {
            "Obelisco", "Puerto Madryn","Tierra del Fuego", "Boca Juniors" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewLugares = (GridView) findViewById(R.id.gridView1);

        gridViewLugares.setAdapter(new LugarAdaptador(this,LUGARES));

        gridViewLugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                /*
                Toast.makeText(
                        getApplicationContext(),
                        ((TextView) v.findViewById(R.id.grid_item_label))
                                .getText(), Toast.LENGTH_SHORT).show();

                */

                String lugarparaVer = ((TextView)v.findViewById(R.id.grid_item_label)).getText().toString();



                irA(v,lugarparaVer);

            }
        });





    }



    public void irA(View v, String lugar){


        String latitud = "-34.603738900";
        String longitud = "-58.381570400";




        if (lugar.equals( "Obelisco"))
        {
            latitud = "-34.603738900";
            longitud = "-58.381570400";

        }  if (lugar.equals("Puerto Madryn"))
        {
            latitud = "-42.7667";
            longitud = "-65.05";

        }  if (lugar.equals("Tierra del Fuego"))
        {

            latitud = "-54.732979";
            longitud = "-63.860882";

        }  if (lugar.equals("Boca Juniors"))
        {
            latitud = "-34.635925";
            longitud = "-58.365222";


        }



        Intent intentEnviarCoordenadas= new Intent(v.getContext(), MapasActivity.class);
        intentEnviarCoordenadas.putExtra("latitud",latitud);
        intentEnviarCoordenadas.putExtra("longitud",longitud);
        intentEnviarCoordenadas.putExtra("referencia",lugar);
        startActivity(intentEnviarCoordenadas);

    }

    }




