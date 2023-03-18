package hcmute.edu.vn.a19110094_tongvannam_week05_foregroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editDataIntent;
    Button btnStartService,btnStopService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editDataIntent=findViewById(R.id.edit_data_intent);
        btnStartService=findViewById(R.id.btn_start_service);
        btnStopService=findViewById(R.id.btn_stop_service);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();

            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();

            }
        });
    }
    private  void clickStartService(){
        Intent intent=new Intent(this,MyService.class);
        intent.putExtra("key_data_intent",editDataIntent.getText().toString().trim());
        startService(intent);
    }
    private  void clickStopService(){
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);

    }
}