package hcmute.edu.vn.music_player.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hcmute.edu.vn.music_player.R;
import hcmute.edu.vn.music_player.databinding.FragmentAlbumsLibraryBinding;


public class Albums_Library extends Fragment {
    FragmentAlbumsLibraryBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      binding=FragmentAlbumsLibraryBinding.inflate(inflater,container,false);
      View view=binding.getRoot();
      return view;
    }
}