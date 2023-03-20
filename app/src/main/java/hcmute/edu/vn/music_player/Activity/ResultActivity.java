package hcmute.edu.vn.music_player.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import hcmute.edu.vn.music_player.R;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = findViewById(R.id.ava_search_result);
        Glide.with(this).load(R.drawable.sontung).circleCrop().into(imageView);

    }
}
