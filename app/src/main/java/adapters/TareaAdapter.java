package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mendoza.luigui.holamundo.R;
import models.Tarea;


public class TareaAdapter extends ArrayAdapter<Tarea> {

    private int resource;

    public TareaAdapter(Context context, int resource, List<Tarea> tareas) {
        super(context, resource, tareas);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)

            convertView = inflater.inflate(resource, parent, false);

        Tarea tarea = getItem(position);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(tarea.title);

        TextView time = (TextView) convertView.findViewById(R.id.time);
        time.setText(tarea.time);


        ImageView imagen = (ImageView) convertView.findViewById(R.id.imageView);
        imagen.setImageResource(R.drawable.android);


        return convertView;

    }
}
