package com.example.kidflix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kidflix.R;
import com.example.kidflix.model.Video;

import java.util.List;

public class AdaptadorVideo extends RecyclerView.Adapter<AdaptadorVideo.ViewHolder>{
    private List<Video> videos;
    private Context context;

    public AdaptadorVideo(List<Video> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_titulo.setText(videos.get(position).getTitulo());
        //Glide.with(context).load(videos.get(position).getPortada()).into(holder.iv_portada);//cambiar por lo de abajo
        Glide.with(context).load(videos.get(position).getPortada()).into(holder.iv_portada);

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_portada; //PROBABLEMENTE CAMBIAR IMAGEVIEW A VIDEOVIEW POR EL TIPO DE ARCHIVO
        private TextView tv_titulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_portada=itemView.findViewById(R.id.iv_portada);
            tv_titulo=itemView.findViewById(R.id.tv_titulo);
        }
    }
}
