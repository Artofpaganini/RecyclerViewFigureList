package by.andersen.intern.recyclerviewfigurelist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;



import by.andersen.intern.recyclerviewfigurelist.R;
import by.andersen.intern.recyclerviewfigurelist.adapter.NumbersFigureAdapter;

public class MainActivity extends AppCompatActivity {

    private String[] numberStringArray;
    int[] image = {
            R.drawable.circle,
            R.drawable.triangle,
            R.drawable.square,
            R.drawable.oval,
            R.drawable.pentagon,
            R.drawable.star,
            R.drawable.parallelogram,
            R.drawable.cube,
            R.drawable.rhombus,
            R.drawable.trapezium

    };

    private RecyclerView recyclerViewList;
    private NumbersFigureAdapter numbersFigureAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberStringArray = getResources().getStringArray(R.array.figure_string_number);
        recyclerViewList = findViewById(R.id.rv_figure_list);

        numbersFigureAdapter = new NumbersFigureAdapter(this, numberStringArray, image);

        recyclerViewList.setAdapter(numbersFigureAdapter);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));

//
//        numbersFigureAdapter = new NumbersFigureAdapter(100);
//        numberFigureList.setAdapter(numbersFigureAdapter);
    }

}



