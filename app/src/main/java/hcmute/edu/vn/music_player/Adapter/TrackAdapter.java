package hcmute.edu.vn.music_player.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import hcmute.edu.vn.music_player.Activity.PlayMedia;
import hcmute.edu.vn.music_player.Models.Album;
import hcmute.edu.vn.music_player.Models.Artist;
import hcmute.edu.vn.music_player.Models.Track;
import hcmute.edu.vn.music_player.R;
public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder>{
    private Context mContext;
    private List<Track> trackList;
    Artist findingArtist=new Artist();
    public TrackAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Track> list)
    {
        this.trackList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        Track track = trackList.get(position);

        if(track == null)
        {
            return;
        }

        //set Track to recycle view
        Glide.with(mContext).load(track.getImage()).into(holder.item_tracks_TrackImg);
        holder.item_tracks_TrackNameTxt.setText(track.getName());
        try{
            if(track.gettAlbum() != null){
                holder.item_tracks_ArtistTxt.setText(track.getArtistId());
            }

        }
        catch (Exception e){

        }

        //set Track item to Track detail
        holder.item_tracks_TrackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick(holder, track);
            }
        });
        holder.item_tracks_TrackNameTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick(holder, track);
            }
        });
        holder.item_tracks_ArtistTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick(holder, track);
            }
        });
    }

    public void itemClick(TrackViewHolder holder,  Track track){
        Intent intent = new Intent(holder.itemView.getContext(), PlayMedia.class);
        intent.putExtra("track", track);
        holder.itemView.getContext().startActivity(intent);
    }
    @Override
    public int getItemCount() {

        if(trackList != null)
        {
            return trackList.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_song, parent, false);

        return new TrackViewHolder(view);
    }
    public class TrackViewHolder extends RecyclerView.ViewHolder{

        ImageView item_tracks_TrackImg;
        TextView item_tracks_TrackNameTxt, item_tracks_ArtistTxt;

        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);

            item_tracks_TrackImg = itemView.findViewById(R.id.image_track);
            item_tracks_TrackNameTxt = itemView.findViewById(R.id.track_name);
            item_tracks_ArtistTxt = itemView.findViewById(R.id.track_artist);


        }
    }
}
