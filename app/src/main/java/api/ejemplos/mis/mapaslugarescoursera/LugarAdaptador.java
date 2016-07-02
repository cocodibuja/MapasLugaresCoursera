package api.ejemplos.mis.mapaslugarescoursera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nicopro on 2/7/16.
 */
public class LugarAdaptador extends BaseAdapter {

    private Context context;
    private final String[] lugares;

    public LugarAdaptador(MainActivity context, String[] lugares) {
        this.context = context;
        this.lugares = lugares;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from lugar.xml
            gridView = inflater.inflate(R.layout.lugar, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(lugares[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String lugar = lugares[position];




            if (lugar.equals( "Obelisco")) {
                imageView.setImageResource(R.drawable.imagenobelisco);
            } else if (lugar.equals("Puerto Madryn")) {
                imageView.setImageResource(R.drawable.imagenpuertomadryn);
            } else if (lugar.equals("Tierra del Fuego")) {
                imageView.setImageResource(R.drawable.imagen_faro);
            } else if (lugar.equals("Boca Juniors")) {
                imageView.setImageResource(R.drawable.imagenboca);
            }

            else {
                imageView.setImageResource(R.drawable.cast_ic_notification_2);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return lugares.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
