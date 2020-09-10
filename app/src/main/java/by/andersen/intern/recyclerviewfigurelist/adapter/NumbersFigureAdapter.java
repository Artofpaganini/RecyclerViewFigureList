package by.andersen.intern.recyclerviewfigurelist.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import by.andersen.intern.recyclerviewfigurelist.R;

public class NumbersFigureAdapter extends RecyclerView.Adapter<NumbersFigureAdapter.NumberViewHolder> {

    private int numbersFigures;



    public NumbersFigureAdapter(int numbersFigures) {
        this.numbersFigures = numbersFigures;
    }

    //начальное создание  Н-е кол-во  вьюхолдеров
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.number_list_item;


        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //  тут  мы получили  наше предсталвение  из  xml  в java
        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);

        //оборачивает во вьюхолдер, это позволит переиспользовать
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }

    //вместо новых  вьюхолдеров ,  задаем новые значения   созданным ранее вьюхолдерам
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    //общее кол-во  вьюхолдеров
    @Override
    public int getItemCount() {
        return numbersFigures;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView listNumbersFigureView;
        ImageView imageFigureView;
         int [] figureArray = {

                R.drawable.triangle,
                R.drawable.square
        };


        // оборачивает элемент списка,
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            listNumbersFigureView = itemView.findViewById(R.id.tv_number_image);
            imageFigureView = itemView.findViewById(R.id.iv_figure);


            for (int i = 0; i <figureArray.length ; i++) {
                imageFigureView.setImageResource(figureArray[i]);
            }

        }

        //возможно тут  нужно  удет делать цикл или вставлять  массив  строк
        void bind(int listIndex) {
            listNumbersFigureView.setText(String.valueOf(listIndex));
        }
    }
}
