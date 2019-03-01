package com.gzeinnumer.getwifiinfo;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMITTION = 123;
    WifiManager wifiManager;
    List<ScanResult> wifiList;
    StringBuilder sb = new StringBuilder();

    Button btnClick;
    TextView wifiInfo;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnGetInfo);
        wifiInfo = findViewById(R.id.infoWifi);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            MY_PERMITTION);
                } else {
                    Toast.makeText(MainActivity.this, "Proses", Toast.LENGTH_SHORT).show();
                    myWifiMethod();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMITTION:
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    myWifiMethod();
                } else {
                    Toast.makeText(this, "Access di block!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private final BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)){
                wifiList = wifiManager.getScanResults()private void myWifiMethod() {
                    wifiManager = (WifiManager) MainActivity.this.getApplicationContext().getSystemService(WIFI_SERVICE);
                }
                sb= new StringBuilder();
                sb.append("\n"+"Number Of Wifi connection: "+wifiList.size()+"\n");
                for (int i=0; i < wifiList.size(); i++){
                    sb.append(new Integer(i+1).toString()+". ");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("BSSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                    sb.append("SSID: "+(wifiList.get(i).SSID).toString()+"\n");
                }
            }
        }
    }

    private void myWifiMethod() {
        wifiManager = (WifiManager) MainActivity.this.getApplicationContext().getSystemService(WIFI_SERVICE);
        MainActivity.this.registerReceiver()
    }
}
