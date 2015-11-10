package mendoza.luigui.holamundo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.ContactAdapter;
import models.Contact;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView list = (ListView)findViewById(R.id.listView);

        ContactAdapter adapter = new ContactAdapter(this, R.layout.contact_simple_list_item, GetContacts());

        list.setAdapter(adapter);

    }

    private List<Contact> GetContacts() {
        List<Contact> contacts = new ArrayList<>();

        ContentResolver resolver = getContentResolver();

        Cursor people = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        while(people.moveToNext())
        {
            Contact contact = new Contact();

            int indexName  = people.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            int indexPhoto = people.getColumnIndex(ContactsContract.Contacts.PHOTO_URI);

            contact.setName(people.getString(indexName));
            contact.setPhoto(people.getString(indexPhoto));


            contacts.add(contact);

        }

        people.close();



        return contacts;

    }

}
