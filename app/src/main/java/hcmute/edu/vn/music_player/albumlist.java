package hcmute.edu.vn.music_player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class albumlist extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapterAlbum myAdapterAlbum;
    ArrayList<Album> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albumlist);

        recyclerView = findViewById(R.id.albumList);
        database = FirebaseDatabase.getInstance().getReference("Album");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapterAlbum = new MyAdapterAlbum(this, list);
        recyclerView.setAdapter(myAdapterAlbum);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Album album = dataSnapshot.getValue(Album.class);
                    list.add(album);
                }
                myAdapterAlbum.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}