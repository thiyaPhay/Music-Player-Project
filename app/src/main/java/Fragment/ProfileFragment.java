package Fragment;
import com.cscorner.music_player_project.LoginActivity;
import com.cscorner.music_player_project.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    private FirebaseAuth mAuth;
    private ImageView btnBack;
    private Button logoutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false); // Replace with your layout file name

        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Find views
        btnBack = view.findViewById(R.id.btnBack);
        logoutButton = view.findViewById(R.id.logoutButton);

        // Back button click
        btnBack.setOnClickListener(v -> {
            requireActivity().onBackPressed(); // Go back to previous screen
        });

        // Logout button click
        logoutButton.setOnClickListener(v -> signOut());

        return view;
    }

    private void signOut() {
        mAuth.signOut(); // Firebase sign out
        Toast.makeText(requireContext(), "Signed out successfully", Toast.LENGTH_SHORT).show();

        // Navigate to LoginActivity
        Intent intent = new Intent(requireActivity(), LoginActivity.class); // Replace LoginActivity with your actual login screen
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        requireActivity().finish(); // Close current Activity hosting the fragment
    }
}
