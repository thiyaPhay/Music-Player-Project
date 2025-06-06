package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cscorner.music_player_project.NowPlayingActivity;
import com.cscorner.music_player_project.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.SongAdapter;
import Model.Song;

public class LibraryFragment extends Fragment {

    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private List<Song> songList;

    public LibraryFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_library);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        songList = new ArrayList<>();
        loadSongs();

        songAdapter = new SongAdapter(requireContext(), songList);
        songAdapter.setOnItemClickListener(song -> {
            // Launch NowPlayingActivity with song data
            Intent intent = new Intent(requireContext(), NowPlayingActivity.class);
            intent.putExtra("song_res_id", song.getAudioResId());
            intent.putExtra("song_title", song.getTitle());
            intent.putExtra("song_subtitle", song.getArtist());
            intent.putExtra("song_image_id", song.getImageResId());
            startActivity(intent);
        });

        recyclerView.setAdapter(songAdapter);

        return view;
    }

    private void loadSongs() {
        songList.add(new Song(R.drawable.song1, "NEW LIFE", "VannDa", R.raw.song1));
        songList.add(new Song(R.drawable.song2, "SOLO AGAIN", "VannDa", R.raw.song2));
        songList.add(new Song(R.drawable.song3, "Songkran Magic", "VannDa", R.raw.song3));
        songList.add(new Song(R.drawable.song4, "Rockstar", "VannDa", R.raw.song4));
        songList.add(new Song(R.drawable.song5, "Catch Me If You Can", "VannDa", R.raw.song5));
        songList.add(new Song(R.drawable.song6, "Not Okay But Okay", "VannDa", R.raw.song6));
        songList.add(new Song(R.drawable.song7, "Love Sick Blue", "VannDa", R.raw.song7));
        songList.add(new Song(R.drawable.song8, "Baby Mama", "VannDa", R.raw.song8));
        songList.add(new Song(R.drawable.song9, "J+O II", "VannDa", R.raw.song9));


    }
}
