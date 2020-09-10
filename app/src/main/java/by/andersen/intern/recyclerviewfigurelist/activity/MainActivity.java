package by.andersen.intern.recyclerviewfigurelist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import by.andersen.intern.recyclerviewfigurelist.R;
import by.andersen.intern.recyclerviewfigurelist.adapter.NumbersFigureAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView numberFigureList;
    private NumbersFigureAdapter numbersFigureAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberFigureList = findViewById(R.id.rv_figure_list);



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numberFigureList.setLayoutManager(layoutManager);

        numberFigureList.setHasFixedSize(true);

        numbersFigureAdapter = new NumbersFigureAdapter(100);
        numberFigureList.setAdapter(numbersFigureAdapter);
    }


}