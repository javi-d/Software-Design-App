package com.example.cst338_p2_movie_schmovies;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    List<Movie> items;
    private OnClickListener onClickListener;


    public AdapterClass(Context context, List<Movie> items) {
        mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.movie_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.movieBanner.setImageResource(items.get(position).getImage());
        holder.movieTitle.setText(items.get(position).getMovieName());
        holder.synopsis.setText(items.get(position).getSynopsis());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            Movie item = items.get(position);
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(position, item);
                }
            }
        });
    }

    public interface OnClickListener {
        void onClick(int position, Movie item);
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
