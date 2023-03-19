package hcmute.edu.vn.music_player.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import hcmute.edu.vn.music_player.Activity.MainActivity;
import hcmute.edu.vn.music_player.Activity.SplashScreen;
import hcmute.edu.vn.music_player.R;
import hcmute.edu.vn.music_player.databinding.FragmentLibraryBinding;


public class LibraryFragment extends Fragment {
    FragmentLibraryBinding binding;
    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentLibraryBinding.inflate(inflater,container,false);
        View view=binding.getRoot();

        return  view;
    }
}