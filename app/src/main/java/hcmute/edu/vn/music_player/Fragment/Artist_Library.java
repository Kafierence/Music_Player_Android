package hcmute.edu.vn.music_player.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hcmute.edu.vn.music_player.R;
import hcmute.edu.vn.music_player.databinding.FragmentArtistLibraryBinding;


public class Artist_Library extends Fragment {
    FragmentArtistLibraryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentArtistLibraryBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        return view;
    }
}