package hcmute.edu.vn.music_player;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterArtist extends RecyclerView.Adapter<MyAdapterArtist.MyViewHolder> {

    Context context;
    ArrayList<Artist> list;

    public MyAdapterArtist(Context context, ArrayList<Artist> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterArtist.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_artist,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterArtist.MyViewHolder holder, int position) {

        Artist artist = list.get(position);
        //holder.imageArtist.setImageResource(artist.getImageArtist());
        holder.nameArtist.setText(artist.nameArtist);
        holder.numFollower.setText(String.valueOf(artist.numFollower));
        //holder.numFollower.setText(artist.numFollower);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//        Artist artist = list.get(position);
//        //holder.imageArtist.setImageResource(artist.getImageArtist());
//        holder.nameArtist.setText(artist.getNameArtist());
//        holder.numFollower.setText((int) artist.getNumFollower());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //ImageView imageArtist;
        TextView nameArtist;
        TextView numFollower;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameArtist = itemView.findViewById(R.id.tv_artist_name);
        numFollower = itemView.findViewById(R.id.tv_follower);
    }
    }
}
