package com.cscorner.music_player_project;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class NowPlayingActivity extends AppCompatActivity {

    private ImageButton backBtn, likeBtn, playPauseBtn, shareBtn, playlistBtn;
    private TextView     nowPlaying, songTitle, subTitle;
    private ImageView songCover;
    private SeekBar musicSeekBar;

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        initViews();
        setupListeners();
        setupMediaPlayer();
    }

    private void initViews() {
        backBtn = findViewById(R.id.backBtn);
        likeBtn = findViewById(R.id.likeBtn);
        playPauseBtn = findViewById(R.id.playPauseBtn);
        shareBtn = findViewById(R.id.shareBtn);
        playlistBtn = findViewById(R.id.playlistBtn);
        nowPlaying = findViewById(R.id.nowPlaying);
        songTitle = findViewById(R.id.songTitle);
        subTitle = findViewById(R.id.subTitle);
        songCover = findViewById(R.id.songCover);
        musicSeekBar = findViewById(R.id.musicSeekBar);
    }

    private void setupListeners() {
        backBtn.setOnClickListener(v -> finish());

        playPauseBtn.setOnClickListener(v -> {
            if (isPlaying) {
                mediaPlayer.pause();
                playPauseBtn.setImageResource(R.drawable.baseline_pause_circle_filled_24);
            } else {
                mediaPlayer.start();
                playPauseBtn.setImageResource(R.drawable.baseline_pause_circle_filled_24);
            }
            isPlaying = !isPlaying;
        });

        musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    mediaPlayer.seekTo(progress);
                }
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void setupMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music_2); // Replace with your music file
        musicSeekBar.setMax(mediaPlayer.getDuration());

        // Optional: update SeekBar while playing
        new Thread(() -> {
            while (mediaPlayer != null) {
                try {
                    if (mediaPlayer.isPlaying()) {
                        musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
