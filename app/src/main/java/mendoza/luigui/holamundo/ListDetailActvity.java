package mendoza.luigui.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDetailActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail_actvity);

        TextView hello = (TextView)findViewById(R.id.textoHello);
        hello.setText("Hola Clase");

        ImageView image = (ImageView)findViewById(R.id.image);
        image.setImageResource(R.drawable.android);

        Button Agenda = (Button)findViewById(R.id.button);

        Agenda.setText("Soy un Boton");
    }



}
