package hcmute.edu.vn.music_player.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.music_player.Models.Track;
import hcmute.edu.vn.music_player.R;
import hcmute.edu.vn.music_player.databinding.ActivityPlayMediaBinding;

public class    PlayMedia extends AppCompatActivity implements View.OnClickListener{
    // views declartion
    TextView tvTime, tvDuration,songName,artistName;
    SeekBar seekBarTime, seekBarVolume;
    Button btnPlay;

    MediaPlayer musicPlayer;
    Track trackSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_media);

        //setting get data from intent
        Intent intent = getIntent();
        trackSong=(Track)intent.getSerializableExtra("track");


        // hide the actionbar

        // get Data Texview
        tvTime = findViewById(R.id.tvTime);
        tvDuration = findViewById(R.id.tvDuration);
        songName=findViewById(R.id.song_name);
        artistName=findViewById(R.id.song_artist_name);

        //
        seekBarTime = findViewById(R.id.seekBarTime);
        seekBarVolume = findViewById(R.id.seekBarVolume);
        btnPlay = findViewById(R.id.btnPlay);


        //Load data music to
        musicPlayer = MediaPlayer.create(this, Uri.parse(trackSong.getSource()));
        songName.setText(trackSong.getName().toString());
        artistName.setText(trackSong.getArtistName().toString());
        musicPlayer.setLooping(true);
        musicPlayer.seekTo(0);
        musicPlayer.setVolume(0.5f, 0.5f);
        //pass data get from track
        String duration = millisecondsToString(musicPlayer.getDuration());
        tvDuration.setText(duration);



        btnPlay.setOnClickListener(this);

        seekBarVolume.setProgress(50);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isFromUser) {
                float volume = progress / 100f;
                musicPlayer.setVolume(volume,volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTime.setMax(musicPlayer.getDuration());
        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isFromUser) {
                if(isFromUser) {
                    musicPlayer.seekTo(progress);
                    seekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (musicPlayer != null) {
                    if(musicPlayer.isPlaying()) {
                        try {
                            final double current = musicPlayer.getCurrentPosition();
                            final String elapsedTime = millisecondsToString((int) current);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTime.setText(elapsedTime);
                                    seekBarTime.setProgress((int) current);
                                }
                            });

                            Thread.sleep(1000);
                        }catch (InterruptedException e) {}
                    }
                }
            }
        }).start();

    } // end main


    public String millisecondsToString(int time) {
        String elapsedTime = "";
        int minutes = time / 1000 / 60;
        int seconds = time / 1000 % 60;
        elapsedTime = minutes+":";
        if(seconds < 10) {
            elapsedTime += "0";
        }
        elapsedTime += seconds;

        return  elapsedTime;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnPlay) {
            if(musicPlayer.isPlaying()) {
                // is playing
                musicPlayer.pause();
                btnPlay.setBackgroundResource(R.drawable.ic_play);
            } else {
                // on pause
                musicPlayer.start();
                btnPlay.setBackgroundResource(R.drawable.ic_pause);
            }
        }
    }
}

