package com.example.cst338_p2_movie_schmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    List<Movie> items;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.movieBanner.setImageResource(items.get(position).);
        holder.movieTitle.setText(items.get(position).getMovieName());
        holder.synopsis.setText(items.get(position).getSynopsis());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
