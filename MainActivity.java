package com.tm.bltuth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tm.bltuth.application.MyApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    //private TextView tvSEnd;
//    private TextView tvrcv;
    private static final int REQUEST_ENABLE_BT = 2;
    private static final int REQUEST_CONNECT_DEVICE = 1;
    //private EditText edtInput;
    private EditText editTextScreen;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnPlus;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnMinus;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnMultiply;
    private Button btnClear;
    private Button btnZero;
    private Button btnEqual;
    private Button btnDevided;

    private float mValueOne=0, mValueTwo=0;
    boolean mAddition, mSubtruction, mMultiplication, mDevition;
    private String str="";
    private Character op='q';
    private int i, num, tempnum;
    private String operator="";
    private boolean isSecond=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);



//        tvSEnd=(TextView)this.findViewById(R.id.tvSEnd);
//        edtInput=(EditText) this.findViewById(R.id.edtInput);
//        tvrcv=(TextView)this.findViewById(R.id.tvrcv);
//        tvrcv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                rcv();
//            }
//        });
//        tvSEnd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!MyApplication.mBluetoothService.isBTopen()) {
//                    Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                    startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
//                }
//                int state = MyApplication.mBluetoothService.getState();
//                if (state != 3) {
//                    Toast.makeText(MainActivity.this, "Please connect Bluetooth printer", Toast.LENGTH_LONG).show();
//                    Intent serverIntent = new Intent(MainActivity.this, DeviceListActivity.class);
//                    startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
//                }
//                else {
//                    connect();
//                }
//            }
//        });





        //=========================

        editTextScreen=(EditText) findViewById(R.id.et_screen);
        btnOne=(Button)findViewById(R.id.btn_one);
        btnTwo=(Button)findViewById(R.id.btn_two);
        btnThree=(Button)findViewById(R.id.btn_three);
        btnPlus=(Button)findViewById(R.id.btn_plus);
        btnFour=(Button)findViewById(R.id.btn_four);
        btnFive=(Button)findViewById(R.id.btn_five);
        btnSix=(Button)findViewById(R.id.btn_six);
        btnMinus=(Button)findViewById(R.id.btn_minus);
        btnSeven=(Button)findViewById(R.id.btn_seven);
        btnEight=(Button)findViewById(R.id.btn_eight);
        btnNine=(Button)findViewById(R.id.btn_nine);
        btnMultiply=(Button)findViewById(R.id.btn_multiply);
        btnClear=(Button)findViewById(R.id.btn_clear);
        btnZero=(Button)findViewById(R.id.btn_zero);
        btnEqual=(Button)findViewById(R.id.btn_equal);
        btnDevided=(Button)findViewById(R.id.btn_devided);



        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(1);
//                editTextScreen.setText(editTextScreen.getText()+"1");
                common("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(2);
//                editTextScreen.setText(editTextScreen.getText()+"2");
                common("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(3);
//                editTextScreen.setText(editTextScreen.getText()+"3");
                common("3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(4);
//                editTextScreen.setText(editTextScreen.getText()+"4");

                common("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(5);
//                editTextScreen.setText(editTextScreen.getText()+"5");
                common("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(6);
//                editTextScreen.setText(editTextScreen.getText()+"6");
                common("6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(7);
//                editTextScreen.setText(editTextScreen.getText()+"7");
                common("7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(8);
//                editTextScreen.setText(editTextScreen.getText()+"8");
                common("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(9);
//                editTextScreen.setText(editTextScreen.getText()+"9");
        common("9");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(0);
//                editTextScreen.setText(editTextScreen.getText()+"0");
                common("0");
            }
        });


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operate("+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operate("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operate("*");
            }
        });

        btnDevided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operate("/");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calculate();
                equal();
                operator="";
                mValueOne=0;
                str="";
                verified();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                verified();
            }
        });


        //=======
    }
    public void common(String input){

        if(operator=="" || mValueOne!=0){
            editTextScreen.setText("");
        }
        str=str+input;
        editTextScreen.setText(str);
        verified();
    }

    boolean stopWorker;
    void beginListenForData()
    {
        final Handler handler = new Handler();
        final byte delimiter = 10; //This is the ASCII code for a newline character




        //===========
//        InputStream instream=null;
//        btInputstreem=instream;
//        try {
//            btInputstreem=MyApplication.btsocket.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] buffer = new byte[1024];
//        int bytes;
//
//        try {
//            bytes = btInputstreem.read(buffer);
//            final String strReceived = new String(buffer, 0, bytes);
//            final String msgReceived = String.valueOf(bytes) +
//                    " bytes received:\n"
//                    + strReceived;
//
//            runOnUiThread(new Runnable(){
//
//                @Override
//                public void run() {
//                    Toast.makeText(MainActivity.this, ""+strReceived, Toast.LENGTH_SHORT).show();
////                    tvSEnd.setText(strReceived);
//                }});
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();

//        }





        stopWorker = false;
//        readBufferPosition = 0;
//        readBuffer = new byte[1024];
        Thread workerThread = new Thread(new Runnable()
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !stopWorker)
                {
                    InputStream instream=null;
                    btInputstreem=instream;
                    try {
                        btInputstreem=MyApplication.btsocket.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    byte[] buffer = new byte[1024];
                    int bytes;

                    try {
                        bytes = btInputstreem.read(buffer);
                        final String strReceived = new String(buffer, 0, bytes);
                        final String msgReceived = String.valueOf(bytes) +
                                " bytes received:\n"
                                + strReceived;

                        runOnUiThread(new Runnable(){

                            @Override
                            public void run() {
                                editTextScreen.setText(strReceived+"");
                                Toast.makeText(MainActivity.this, ""+strReceived, Toast.LENGTH_SHORT).show();
//                    tvSEnd.setText(strReceived);
                            }});

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();

                    }
                }
            }
        });

        workerThread.start();
    }


    public void equal(){

        float result = 0;
        if(str!="") {
            mValueTwo = Float.parseFloat(str);
            if (operator == "+") {
                result = mValueOne + mValueTwo;
                //mAddition=false;
            } else if (operator == "-") {
                result = mValueOne - mValueTwo;
                //mSubtruction=false;
            } else if (operator == "*") {
                result = mValueOne * mValueTwo;
                //mMultiplication=false;
            } else if (operator == "/") {
                result = mValueOne / mValueTwo;
                //mDevition=false;
            }
        }else {
            result=mValueOne;
        }

        editTextScreen.setText(((int)result)+"");

        mValueOne=result;
        mValueTwo=0;
    }

    public void operate(String op){

        if(editTextScreen==null || (editTextScreen.getText()+"")==""){
            editTextScreen.setText("");
        }else{
            if(mValueOne==0)
                mValueOne=Float.parseFloat(editTextScreen.getText()+"");
            else {
                equal();
            }
            operator=op;
            str="";
            //editTextScreen.setText(null);
        }
        verified();
    }

    public void reset(){
        mValueOne=0;
        mValueTwo=0;
        operator="";
        str="";
        editTextScreen.setText("0");
    }

    public void verified(){
        if (!MyApplication.mBluetoothService.isBTopen()) {
                    Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
                }
                int state = MyApplication.mBluetoothService.getState();
                if (state != 3) {
                    Toast.makeText(MainActivity.this, "Please connect Bluetooth printer", Toast.LENGTH_LONG).show();
                    Intent serverIntent = new Intent(MainActivity.this, DeviceListActivity.class);
                    startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
                }
                else {
                    connect();

                }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == Activity.RESULT_OK) {
                ToastHelper.showToast(MainActivity.this, "Bluetooth open successful");
            } else {
                ToastHelper.showToast(MainActivity.this, "Bluetooth open faild");
            }
        } else if (requestCode == REQUEST_CONNECT_DEVICE) {
            if (resultCode == Activity.RESULT_OK) {
                String address = data.getExtras()
                        .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
                String noDevices = "No paired device";
                Log.w("address",address);
                Log.w("noDevices",noDevices);

                if (!noDevices.contains(address)) {
                    BluetoothDevice mBluetoothDevice = MyApplication.mBluetoothService.getDevByMac(address);
                    if (mBluetoothDevice != null)
                        MyApplication.mBluetoothService.connect(mBluetoothDevice);
//                    connect();
                } else {
                    ToastHelper.showToast(MainActivity.this, noDevices);
                }

            } else {
                ToastHelper.showToast(MainActivity.this, "Bluetooth Connection fail");

            }
        }

    }

    public void rcv(){
        InputStream instream=null;
        btInputstreem=instream;
        try {
            btInputstreem=MyApplication.btsocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[1024];
        int bytes;

        try {
            bytes = btInputstreem.read(buffer);
            final String strReceived = new String(buffer, 0, bytes);
            final String msgReceived = String.valueOf(bytes) +
                    " bytes received:\n"
                    + strReceived;

            runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, ""+strReceived, Toast.LENGTH_SHORT).show();
//                    tvSEnd.setText(strReceived);
                }});

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }


    public void printSingleText(String msg) {
        try {
            byte[] format = { 27, 33, 0 };
            btoutputstream.write(format);
            btoutputstream.write(PrinterCommands.ESC_ALIGN_LEFT);
            btoutputstream.write(msg.getBytes(),0,msg.getBytes().length);
        } catch (IOException e) {
            Log.w("errorsending",e.toString());
            e.printStackTrace();
        }
    }
    public  OutputStream btoutputstream;
    public InputStream btInputstreem;

    protected void connect() {
        OutputStream opstream = null;

        try {
            opstream = MyApplication.btsocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btoutputstream = opstream;


        //print command
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            btoutputstream =  MyApplication.btsocket.getOutputStream();
            byte[] printformat = { 0x1B, 0*21, FONT_TYPE };
            btoutputstream.write(printformat);
            printSingleText(editTextScreen.getText().toString().trim());
            btoutputstream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        beginListenForData();

    }
    byte FONT_TYPE;

    private class ReceiveData extends Thread{
        public void rcv(){
            InputStream instream=null;
            btInputstreem=instream;
            try {
                btInputstreem=MyApplication.btsocket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] buffer = new byte[1024];
            int bytes;

            try {
                bytes = btInputstreem.read(buffer);
                final String strReceived = new String(buffer, 0, bytes);
                final String msgReceived = String.valueOf(bytes) +
                        " bytes received:\n"
                        + strReceived;

                runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, ""+strReceived, Toast.LENGTH_SHORT).show();
//                    tvSEnd.setText(strReceived);
                        editTextScreen.setText(strReceived);
                    }});

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }

    }
}
