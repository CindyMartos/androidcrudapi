package mendoza.luigui.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import models.Post;

public class ListBuscarPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buscar_post);
    }

    private List<Post> GetPostsFromWebService()
    {
        List<Post> posts = new ArrayList<>();

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://api.lumenagile.com/posts");

        try{

            HttpResponse httpResponse = httpClient.execute(httpGet);
            String stringResponse = EntityUtils.toString(httpResponse.getEntity());

            JSONArray jsonResponse = new JSONArray(stringResponse);
            for (int i = 0; i < jsonResponse.length(); i++)
            {
                Post post = new Post();

                JSONObject obj = jsonResponse.getJSONObject(i);


                post.user = obj.getString("user");
                post.title = obj.getString("name");
                post.content = obj.getString("content");

                posts.add(post);

            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return posts;
    }


}
