package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cscorner.music_player_project.R;
import Model.Album;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albums;
    private OnAlbumClickListener listener;

    // Interface for click callback
    public interface OnAlbumClickListener {
        void onAlbumClick(Album album);
    }

    // Constructor with listener
    public AlbumAdapter(List<Album> albums, OnAlbumClickListener listener) {
        this.albums = albums;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.imageView.setImageResource(album.getImageResId());
        holder.title.setText(album.getTitle());
        holder.subtitle.setText(album.getSubtitle()); // Show artist correctly

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAlbumClick(album);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, subtitle;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.album_image);
            title = itemView.findViewById(R.id.album_title);
            subtitle = itemView.findViewById(R.id.album_subtitle);
        }
    }
}
