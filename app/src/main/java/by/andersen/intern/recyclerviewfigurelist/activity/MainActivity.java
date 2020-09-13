package by.andersen.intern.recyclerviewfigurelist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import by.andersen.intern.recyclerviewfigurelist.R;
import by.andersen.intern.recyclerviewfigurelist.adapter.NumbersFigureAdapter;
import by.andersen.intern.recyclerviewfigurelist.dialog.AlertDialogFragment;

/**
 * Работа с RecyclerView. Список из 10 элементов произвольного содержания (например, геометрические фигуры).
 * При нажатии отображать AlertDialogFragment с номером элемента (цифрой и, в скобках, словами, например - 1 (первый)).
 */
public class MainActivity extends AppCompatActivity implements NumbersFigureAdapter.OnNoteListener {

    private static final String TAG = "Activity";

    private RecyclerView recyclerViewList;
    private NumbersFigureAdapter numbersFigureAdapter;
    private String[] numberStringArray;
    private int[] image = {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberStringArray = getResources().getStringArray(R.array.figure_string_number);
        recyclerViewList = findViewById(R.id.rv_figure_list);

        numbersFigureAdapter = new NumbersFigureAdapter(this, numberStringArray, image,this);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewList.setAdapter(numbersFigureAdapter);

    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked"  + position);

        Bundle bundle = new Bundle();
        bundle.putString("transmitted_text",numberStringArray[position]);

        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        alertDialogFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();

        alertDialogFragment.show(fragmentManager,"dialogFragment");
    }

}
