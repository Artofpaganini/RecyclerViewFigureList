package by.andersen.intern.recyclerviewfigurelist.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import by.andersen.intern.recyclerviewfigurelist.R;
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
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //  тут  мы получили  наше предсталвение  из  xml  в java
        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.numbersFigureView.setText(numberStringArray[position]);
        holder.imageFigureView.setImageResource(imagesArray[position]);

//        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =  new Intent(context,AlertDialogFragment.class);
//                intent.putExtra("image_url",imagesArray); //  тут может быть не верно
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return imagesArray.length;
    }


    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView numbersFigureView;
        ImageView imageFigureView;
        ConstraintLayout constraintLayout;

        // оборачивает элемент списка,
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            numbersFigureView = itemView.findViewById(R.id.tv_number_image);
            imageFigureView = itemView.findViewById(R.id.iv_figure);


        }

        void  openDialog(){
            AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)context).getSupportFragmentManager();

        }

        //возможно тут  нужно  удет делать цикл или вставлять  массив  строк
        void bind(int listIndex) {
            numbersFigureView.setText(String.valueOf(listIndex));
        }
    }
}
//    private int numberFigureListSize;
//    Context context;
//
//
//    public NumbersFigureAdapter(int numberFigureListSize) {
//        this.numberFigureListSize = numberFigureListSize;
//    }
//
//    //начальное создание  Н-е кол-во  вьюхолдеров
//    @NonNull
//    @Override
//    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//      context = parent.getContext();
//
//        int layoutIdForListItem = R.layout.number_list_item;
//
//
//
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//
//        //  тут  мы получили  наше предсталвение  из  xml  в java
//        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);
//
//        //оборачивает во вьюхолдер, это позволит переиспользовать
//        NumberViewHolder viewHolder = new NumberViewHolder(view);
//
//        return viewHolder;
//    }
//
//    //вместо новых  вьюхолдеров ,  задаем новые значения   созданным ранее вьюхолдерам
//    @Override
//    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
//        holder.bind(position);
//
//    }
//
//    //общее кол-во  вьюхолдеров
//    @Override
//    public int getItemCount() {
//        return numberFigureListSize;
//    }
//
//    //одна ячейка РВ
//    class NumberViewHolder extends RecyclerView.ViewHolder {
//
//        TextView listNumbersFigureView;
//        ImageView imageFigureView;
//
//
//        // оборачивает элемент списка,
//        public NumberViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            listNumbersFigureView = itemView.findViewById(R.id.tv_number_image);
//            imageFigureView = itemView.findViewById(R.id.iv_figure);
//
//
//        }
//
//        //возможно тут  нужно  удет делать цикл или вставлять  массив  строк
//void bind(int listIndex) {
//    listNumbersFigureView.setText(String.valueOf(listIndex));
//}
//    }

