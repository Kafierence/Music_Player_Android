package hcmute.edu.vn.a19110094_tongvannam_week05_foregroundservice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyBuildApplication  extends Application {
    public  static final String CHANNEL_ID="karas_example_service";
    @Override
    public void onCreate() {
        super.onCreate();
    }
    private void createChanelNotification(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,"Channel Service Example", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            if(manager!=null){
                manager.createNotificationChannel(channel);
            }

        }
    }
}
