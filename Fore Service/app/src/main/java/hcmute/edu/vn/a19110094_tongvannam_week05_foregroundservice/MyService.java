package hcmute.edu.vn.a19110094_tongvannam_week05_foregroundservice;

import static hcmute.edu.vn.a19110094_tongvannam_week05_foregroundservice.MyBuildApplication.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
         super.onCreate();
        Log.e("karas","MyService  onCreated");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         String strDataIntent=intent.getStringExtra("key_data_intent");
         sendNotification(strDataIntent);
        return START_NOT_STICKY;
    }
    public void sendNotification(String str){
        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID).setContentTitle("Title Notification")
                .setContentText(str).
                setSmallIcon(R.drawable.ic_baseline_360_24).setContentIntent(pendingIntent).
                build();
            startForeground(1,notification);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("karas","MyService  onDestroy");
    }
}
