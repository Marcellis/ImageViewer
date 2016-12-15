package com.example.marcellis.imageviewer;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import static android.support.design.widget.Snackbar.make;

public class MainActivity extends AppCompatActivity {


    private int currentImageIndex = 0;
    private int[] imageNames;

    private Button mNextButton;
    private ImageView mImageView;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.listView);
        mNextButton = (Button) findViewById(R.id.imageButton);
        mImageView = (ImageView) findViewById(R.id.imageView);

        imageNames = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3};

        String[] items = getResources().getStringArray(R.array.description_text);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String message;
                if (position == currentImageIndex) {
                    message = "Great";
                } else {
                    message = "Wrong";
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex++;

                if (currentImageIndex >= imageNames.length) {
                    currentImageIndex = 0;
                }
                mImageView.setImageResource(imageNames[currentImageIndex]);
            }
        });
    }
}
