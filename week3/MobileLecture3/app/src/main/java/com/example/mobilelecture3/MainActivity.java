package com.example.mobilelecture3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Post> postList = new ArrayList<>();
    Button buttonPost;
    static final int POST_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        PostAdapter postAdapter = new PostAdapter(this, postList);
        listView.setAdapter(postAdapter);

        buttonPost = findViewById(R.id.btnPost);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostAtivity.class);
                startActivityForResult(intent, POST_REQUEST); // geçen hafta a.ıuorduk sadece şidmi bize geri döndürecek
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == POST_REQUEST && resultCode == Activity.RESULT_OK){
            Post post = new Post();
            post.setImage(data.getParcelableExtra("bitmap"));
            post.setMessage(data.getCharSequenceExtra("msg").toString());
            postList.add(post);
            ((PostAdapter)listView.getAdapter()).notifyDataSetChanged(); // eğer bunu çağırmazsak listview upsate olmaz
        }

    }
}