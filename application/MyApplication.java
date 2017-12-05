package com.tm.bltuth.application;

import android.app.Application;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.tm.bltuth.BluetoothService;
import com.tm.bltuth.ToastHelper;


/**
 * Created by Prosanto on 11/11/16.
 */

public class MyApplication extends Application {
    public static final String NEW_ORDER_ACCEIVE = "new_message";
    public static String internetconnectionstatus = "Network Connection Problem";
    public static String internetconnectionmessage = "Please check internet connection";
    public static String device_token = "TestDeviceToken1";
    public static String device_type = "Android 4.5";
    public static String app_version = "Dispatcher V2.1";
    public static String Usertoken = "12345";
    public static String restaurant_id = "2";
    public static String ORDERID = "order_new";
    public static boolean wattingTabFragment = false;
    //====================Public static=================
    public static BluetoothService mBluetoothService;
    public static BluetoothSocket btsocket;
    static final String TAG = "PrintDemoActivity";
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        connectBlutooth();
    }


    public void connectBlutooth() {
        mBluetoothService = new BluetoothService(getBaseContext(), mHandler_printer);

    }
    private final Handler mHandler_printer = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case BluetoothService.MESSAGE_STATE_CHANGE:

                    switch (msg.arg1) {
                        case BluetoothService.STATE_CONNECTED:
                            btsocket =mBluetoothService.getBluetoothSocket();
                            ToastHelper.showToast(getApplicationContext(),"Connect successfully done");

                            break;
                        case BluetoothService.STATE_CONNECTING:
                            Log.d(TAG, "Bluetooth is connecting");
                            break;
                        case BluetoothService.STATE_LISTEN:
                        case BluetoothService.STATE_NONE:
                            Log.d(TAG, "Bluetooth state listen or none");
                            break;
                    }
                    break;
                case BluetoothService.MESSAGE_CONNECTION_LOST:
                    ToastHelper.showToast(getApplicationContext(),"Device connection was lost");
                    break;
                case BluetoothService.MESSAGE_UNABLE_CONNECT:
                    ToastHelper.showToast(getApplicationContext(),"Unable to connect device");
                    break;
            }
        }

    };



}