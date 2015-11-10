package mendoza.luigui.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.TareaAdapter;
import models.Tarea;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        TareaAdapter adapter = new TareaAdapter(this, R.layout.custom_simple_list_item, FakeGetTareas());

        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });

    }

    private List<Tarea> FakeGetTareas() {
        List<Tarea> tareas = new ArrayList<>();


        tareas.add(new Tarea("Proyectos 1", "19:30 - 22:40"));
        tareas.add(new Tarea("Proyectos 2", "19:30 - 22:40"));
        tareas.add(new Tarea("Proyectos 3", "19:30 - 22:40"));
        tareas.add(new Tarea("Proyectos 4", "19:30 - 22:40"));

        return tareas;
    }


}
