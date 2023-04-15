package hcmute.edu.vn.music_player.Database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import hcmute.edu.vn.music_player.Models.Track;


public class DAOTrack {
    public DatabaseReference databaseReference;
    final FirebaseDatabase db;
    //start Track database
    public DAOTrack() {
        db = FirebaseDatabase.getInstance("https://mediaplayer-bd6cd-default-rtdb.firebaseio.com/");

        databaseReference = db.getReference("Track");
    }
    //function add Track
    public Task<Void> add(Track track){
        if(track != null) {
            try{
                // return databaseReference.push().setValue(album);
                return databaseReference.child(track.getName()).setValue(track);
            }
            catch (Exception e){
                e.getMessage();
            }
        }
        return null;
    }
    //function update Track
    public Task<Void> update(Track track){
        return databaseReference.child(track.getKey()).updateChildren(track.toMap());
    }
    //function remove Track
    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }

    //get attribute of Track
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
