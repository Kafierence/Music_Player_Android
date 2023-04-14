package hcmute.edu.vn.music_player.Database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


import hcmute.edu.vn.music_player.Models.Album;


public class DAOAlbum {
    public DatabaseReference databaseReference;
    final FirebaseDatabase db;
    //start Album database
    public DAOAlbum() {
        db = FirebaseDatabase.getInstance("https://mediaplayer-bd6cd-default-rtdb.firebaseio.com/");

        databaseReference = db.getReference("Album"); // return class name
    }

    //get attribute of Album
    public Query getByKey(){
        return databaseReference.orderByKey();
    }
    public Query getByChild(){
        return databaseReference.orderByChild("");
    }
    public Query getByValue(){
        return databaseReference.orderByValue();
    }
}
