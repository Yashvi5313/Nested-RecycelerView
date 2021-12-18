package com.example.newssectiondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.newssectiondemo.Adapter.MainStoryAdapter;
import com.example.newssectiondemo.Model.Root;
import com.example.newssectiondemo.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainStoryAdapter mainStoryAdapter;

    String strStoryJson = new String("[\n" + "{\n" + "\"sectionTitle\":\"Latest\",\n" + "\"news\":[\n" + "{\n" + "\"newsTitle\":\"‘You write him off at your own peril’ – Joe Root backs Ben Stokes to come back stronger after Gabba drubbing\",\n" +
            "\"newsImage\":\"https://static.toiimg.com/thumb/msid-88117555,imgsize-19356,width-400,resizemode-4/88117555.jpg\",\n" + "\"newsStory\":\"Stokes scored 14 and 5 in two innings, while he sent down 12 wicketless overs in the Ashes opener in Brisbane.\",\n" + "\"newsTime\":\"Dec 11, 2021 2:41 pm\"\n" + "},\n" +
            "{\n" + "\"newsTitle\":\"Shane Warne names his top-five Test batters at present, Virat Kohli included\",\n" + "\"newsImage\":\"https://static.toiimg.com/thumb/msid-88087992,imgsize-38990,width-400,resizemode-4/88087992.jpg\",\n" + "\"newsStory\":\"One of the finest leg-spinners to have ever graced the game, Shane Warne named his top-five batters in Test cricket at the moment. With T20 cricket gaining popularity in recent years, many fans and experts reckons the quality of Test cricket has gone down. This major belief is batters nowadays don’t emphasise much on having a sound technique. Also, tackling the red cherry is any condition is not easy.\",\n" + "\"newsTime\":\"Dec 11, 2021 2:41 pm\"\n" + "}\n" + "]\n" + "},\n" +
            "{\n" + "\"sectionTitle\":\"Trending\",\n" + "\"news\":[\n" + "{\n" + "\"newsTitle\":\"Cricket not included in provisional list of games for 2028 Los Angeles Olympics\",\n" + "\"newsImage\":\"https://static.toiimg.com/thumb/msid-88074897,imgsize-22236,width-400,resizemode-4/88074897.jpg\",\n" + "\"newsStory\":\"Cricket as a sport has only 12 full-time member countries, whereas 94 countries are associate members.\",\n" + "\"newsTime\":\"Dec 12, 2021 2:41 pm\"\n" + "}\n" + "]\n" + "}\n" + "]");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Root>>() {
        }.getType();
        ArrayList<Root> rootArrayList = gson.fromJson(strStoryJson, listType);
        mainStoryAdapter = new MainStoryAdapter(MainActivity.this, rootArrayList);
        binding.rvNews.setAdapter(mainStoryAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        binding.rvNews.setLayoutManager(layoutManager);
        binding.progressBar.setVisibility(View.GONE);
    }
}