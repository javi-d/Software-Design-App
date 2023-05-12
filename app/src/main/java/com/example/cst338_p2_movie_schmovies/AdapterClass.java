package com.example.cst338_p2_movie_schmovies;

import static com.example.cst338_p2_movie_schmovies.MainActivity.MOVIE_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<ViewHolder> {

    private final RecyclerViewInterface mRecyclerViewInterface;
    Context mContext;
    List<Movie> items;
//    private OnClickListener onClickListener;


    public AdapterClass(Context context, List<Movie> items, RecyclerViewInterface recyclerViewInterface) {
        mContext = context;
        this.items = items;
        this.mRecyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.movie_view,parent, false), mRecyclerViewInterface);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  Movie item = items.get(position);
        holder.movieBanner.setImageResource(item.getImage());
        holder.movieTitle.setText(item.getMovieName());
        holder.synopsis.setText(item.getSynopsis());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            Movie item = items.get(position);
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext ,"Sup Bitch", Toast.LENGTH_SHORT).show();


               if( mRecyclerViewInterface != null) {
                   int pos = position;
                   if (pos != RecyclerView.NO_POSITION) {
                       mRecyclerViewInterface.onItemClick(pos);
                   }
               }
            }
        });
    }



    @Override
    public int getItemCount() {
        return items.size();
    }
}
