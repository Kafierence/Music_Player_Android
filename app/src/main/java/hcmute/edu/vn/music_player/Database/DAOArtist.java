package hcmute.edu.vn.music_player.Database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class DAOArtist {
    public DatabaseReference databaseReference;
    final FirebaseDatabase db;
    //start Artist database
    public DAOArtist() {
        db = FirebaseDatabase.getInstance("https://mediaplayer-bd6cd-default-rtdb.firebaseio.com/");

        databaseReference = db.getReference("Artists"); // return class name
    }

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
