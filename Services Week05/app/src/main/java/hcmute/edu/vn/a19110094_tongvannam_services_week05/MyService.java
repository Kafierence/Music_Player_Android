package hcmute.edu.vn.a19110094_tongvannam_services_week05;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyService(String name) {
        super("my_intent_thread");
    }
    public MyService() {
        super("s");

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
