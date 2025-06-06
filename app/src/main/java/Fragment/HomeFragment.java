package Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cscorner.music_player_project.R;
import Adapter.AlbumAdapter;
import Model.Album;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private AlbumAdapter adapter;
    private List<Album> albumList;

    public HomeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        albumList = new ArrayList<>();
        loadAlbums();

        adapter = new AlbumAdapter(albumList, album -> {
            // Handle album click -> go to LibraryFragment
            LibraryFragment libraryFragment = new LibraryFragment();
            Bundle bundle = new Bundle();
            bundle.putString("albumTitle", album.getTitle());
            bundle.putString("albumArtist", album.getSubtitle());
            libraryFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, libraryFragment)
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView.setAdapter(adapter);
        return view;
    }

    private void loadAlbums() {
        albumList.add(new Album(R.drawable.album1, getString(R.string.album1_title), getString(R.string.album1_artist)));
        albumList.add(new Album(R.drawable.album2, getString(R.string.album2_title), getString(R.string.album2_artist)));
        albumList.add(new Album(R.drawable.album3, getString(R.string.album3_title), getString(R.string.album3_artist)));
        albumList.add(new Album(R.drawable.album4, getString(R.string.album4_title), getString(R.string.album4_artist)));
        albumList.add(new Album(R.drawable.album5, getString(R.string.album5_title), getString(R.string.album5_artist)));
        albumList.add(new Album(R.drawable.album6, getString(R.string.album6_title), getString(R.string.album6_artist)));
    }
}
