package by.andersen.intern.recyclerviewfigurelist.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import by.andersen.intern.recyclerviewfigurelist.R;

/**
 * Работа с RecyclerView. Список из 10 элементов произвольного содержания (например, геометрические фигуры).
 * При нажатии отображать AlertDialogFragment с номером элемента (цифрой и, в скобках, словами, например - 1 (первый)).
 */

public class NumbersFigureAdapter extends RecyclerView.Adapter<NumbersFigureAdapter.NumberViewHolder> {
    private Context context;
    private String[] numberStringArray;
    private int[] imagesArray;
    private OnNoteListener mOnNoteListener;


    public NumbersFigureAdapter(Context context, String[] numberStringArray, int[] imagesArray, OnNoteListener mOnNoteListener) {
        this.context = context;
        this.numberStringArray = numberStringArray;
        this.imagesArray = imagesArray;
        this.mOnNoteListener = mOnNoteListener;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        int layoutIdForListItem = R.layout.number_list_item;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view, mOnNoteListener);

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


    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView numbersFigureView;
        ImageView imageFigureView;
        OnNoteListener onNoteListener;

        /**
         * wraps a list item and make 1 view clickable  and second view not
         *
         * @param itemView
         * @param onNoteListener
         */
        public NumberViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            numbersFigureView = itemView.findViewById(R.id.tv_number_image);
            imageFigureView = itemView.findViewById(R.id.iv_figure);

            this.onNoteListener = onNoteListener;

            imageFigureView.setClickable(false);
            numbersFigureView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}
