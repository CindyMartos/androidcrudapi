package adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mendoza.luigui.holamundo.R;
import models.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private int resource;

    public ContactAdapter(Context context, int resource, List<Contact> objects) {

        super(context, resource, objects);

        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(resource, parent, false);

        Contact contact = getItem(position);

        ((TextView) convertView.findViewById(R.id.name)).setText(contact.Name);

        if(contact.Photo != null)

            ((ImageView) convertView.findViewById(R.id.image)).setImageURI(Uri.parse(contact.Photo));

        else

            ((ImageView) convertView.findViewById(R.id.image)).setImageResource(R.drawable.android);


        return convertView;
    }
}
