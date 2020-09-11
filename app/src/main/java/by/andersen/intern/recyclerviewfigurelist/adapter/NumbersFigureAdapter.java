package by.andersen.intern.recyclerviewfigurelist.adapter;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import by.andersen.intern.recyclerviewfigurelist.R;
import by.andersen.intern.recyclerviewfigurelist.activity.MainActivity;
import by.andersen.intern.recyclerviewfigurelist.dialog.AlertDialogFragment;


public class NumbersFigureAdapter extends RecyclerView.Adapter<NumbersFigureAdapter.NumberViewHolder> {

    Context context;
    String[] numberStringArray;
    int[] imagesArray;



    public NumbersFigureAdapter(Context context, String[] numberStringArray, int[] imagesArray) {
        this.context = context;
        this.numberStringArray = numberStringArray;
        this.imagesArray = imagesArray;

    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //  тут  мы получили  наше предсталвение  из  xml  в java
        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, final int position) {
        holder.numbersFigureView.setText(numberStringArray[position]);
        holder.imageFigureView.setImageResource(imagesArray[position]);

    }

    @Override
    public int getItemCount() {
        return imagesArray.length;
    }


    class NumberViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayout;
        TextView numbersFigureView;
        ImageView imageFigureView;


        // оборачивает элемент списка,
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            numbersFigureView = itemView.findViewById(R.id.tv_number_image);
            imageFigureView = itemView.findViewById(R.id.iv_figure);

            numbersFigureView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"123",Toast.LENGTH_SHORT).show();
                    AlertDialogFragment alertDialogFragment = new AlertDialogFragment ();
                    ((MainActivity)context).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.rv_figure_list, alertDialogFragment,"AlertDialogFragment").addToBackStack(null).commit();

                }
            });


        }
    }
}
