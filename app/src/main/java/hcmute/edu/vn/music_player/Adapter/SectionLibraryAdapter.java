package hcmute.edu.vn.music_player.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import hcmute.edu.vn.music_player.Fragment.Albums_Library;
import hcmute.edu.vn.music_player.Fragment.Artist_Library;
import hcmute.edu.vn.music_player.Fragment.Playlist_Library;

public class SectionLibraryAdapter extends FragmentStateAdapter {
    public  SectionLibraryAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new Artist_Library();
            case 2:
                return new Albums_Library();
            default:
                return new Playlist_Library();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
