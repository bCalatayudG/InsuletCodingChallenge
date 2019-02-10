package com.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aidl.aidlserver.IRemoteService;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    IRemoteService remoteService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: preService");
        ComponentName aidlComponent = new ComponentName("com.aidl.aidlserver", "com.aidl.aidlserver.MyAIDLService");
        Intent remoteIntent = new Intent();
        remoteIntent.setComponent(aidlComponent);
        bindService(remoteIntent, serviceConnection, BIND_AUTO_CREATE);

        Log.d(TAG, "onCreate: postService");
        try {
            Log.d(TAG, "onCreate: " + remoteService.getPersonList().toString());
//            Log.d(TAG, "onCreate: ");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");
            remoteService = IRemoteService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
