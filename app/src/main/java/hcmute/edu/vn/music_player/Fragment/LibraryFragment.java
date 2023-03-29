package hcmute.edu.vn.music_player.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import hcmute.edu.vn.music_player.Adapter.SectionLibraryAdapter;
import hcmute.edu.vn.music_player.R;
import hcmute.edu.vn.music_player.databinding.FragmentLibraryBinding;


public class LibraryFragment extends Fragment {
    private  FragmentLibraryBinding binding;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private SectionLibraryAdapter viewPagerAdapter;
    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentLibraryBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        tabLayout=binding.tabLibrary;
        viewPager=binding.libraryViewpager;
        viewPagerAdapter=new SectionLibraryAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Playlist");
                    break;
                case 1:
                    tab.setText("Artist");
                    break;
                case 2:
                    tab.setText("Album");
                    break;

            }
        }).attach();
        return view;

    }
}