package hcmute.edu.vn.music_player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterAlbum extends RecyclerView.Adapter<MyAdapterAlbum.MyViewHolder> {

    Context context;
    ArrayList<Album> list;

    public MyAdapterAlbum(Context context, ArrayList<Album> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterAlbum.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_album,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterAlbum.MyViewHolder holder, int position) {

        Album album = list.get(position);
        //holder.imageArtist.setImageResource(artist.getImageArtist());
        holder.name.setText(album.name);
        holder.description.setText(album.description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //ImageView imageArtist;
        TextView name;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_album_name);
            description = itemView.findViewById(R.id.tv_description);
        }
    }
}
