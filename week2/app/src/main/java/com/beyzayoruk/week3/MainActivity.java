package com.beyzayoruk.week3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView ListView;
    List<Post> postList=new ArrayList<>();
    Button btnPost;
    static final int POST_REQUEST = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView = findViewById(R.id.listView);
        PostAdaptor postAdaptor=new PostAdaptor(this,postList);
        ListView.setAdapter(postAdaptor);

        btnPost=findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(MainActivity.this,PostActivity.class);
                startActivityForResult(intent,POST_REQUEST);

            }
        });

    }
}