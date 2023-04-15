package hcmute.edu.vn.music_player.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.music_player.Activity.LoginActivity;
import hcmute.edu.vn.music_player.Activity.PlayMedia;
import hcmute.edu.vn.music_player.Adapter.TrackAdapter;
import hcmute.edu.vn.music_player.Database.DAOTrack;
import hcmute.edu.vn.music_player.Models.Track;
import hcmute.edu.vn.music_player.R;
import hcmute.edu.vn.music_player.databinding.FragmentPlaylistLibraryBinding;


public class Playlist_Library extends Fragment {
    FragmentPlaylistLibraryBinding binding;
    DAOTrack daoTrack=new DAOTrack();
    TrackAdapter trackAdapter;
    public Playlist_Library(){

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist__library, container, false);

        //set recycleView for Album
        RecyclerView recyclerView1 = view.findViewById(R.id.track_recycle);

        trackAdapter=new TrackAdapter(getActivity());
        trackAdapter.setData(getListTrack());
        recyclerView1.setAdapter(trackAdapter);
        recyclerView1.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return view;
    }
    private List<Track> getListTrack(){
        List<Track> tracks=new ArrayList<>();

        daoTrack.getByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data: snapshot.getChildren()){
                    Track track
                            =data.getValue(Track.class);
                    String key=data.getKey();
                    track.setKey(key);
                    tracks.add(track);
                }
                trackAdapter.notifyDataSetChanged();
                trackAdapter.setData(tracks);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return tracks;

    }
}