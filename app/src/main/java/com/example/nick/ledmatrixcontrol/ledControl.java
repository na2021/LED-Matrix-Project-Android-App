package com.example.nick.ledmatrixcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.UUID;

public class ledControl extends AppCompatActivity {

    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    //SPP UUID. Look for it
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String TAG = "ledControl";

    @Override // creates all buttons and connects bluetooth
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceList.EXTRA_ADDRESS); //receive the address of the bluetooth device

        //view of the ledControl
        setContentView(R.layout.activity_led_control);

        new ConnectBT().execute(); //Call the class to connect

        Button btnani0 = (Button) findViewById(R.id.btnani0);
        btnani0.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Animation0");
                Toast.makeText(getApplicationContext(), "Animation0", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 100);

            }
        });
        Button btnani1 = (Button) findViewById(R.id.btnani1);
        btnani1.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Animation1");
                Toast.makeText(getApplicationContext(), "Animation1", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 101);

            }
        });
        Button btnani2 = (Button) findViewById(R.id.btnani2);
        btnani2.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Animation2");
                Toast.makeText(getApplicationContext(), "Animation2", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 102);

            }
        });

        //
        //
        //Row 0
        //
        //
        //

        Button btn00 = (Button) findViewById(R.id.btn00);
        btn00.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 00");
                Toast.makeText(getApplicationContext(), "Toggle 00", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 0);

            }
        });
        Button btn01 = (Button) findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 01");
                Toast.makeText(getApplicationContext(), "Toggle 01", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 1);
            }
        });
        Button btn02 = (Button) findViewById(R.id.btn02);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 02");
                Toast.makeText(getApplicationContext(), "Toggle 02", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 2);
            }
        });
        Button btn03 = (Button) findViewById(R.id.btn03);
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 03");
                Toast.makeText(getApplicationContext(), "Toggle 03", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 3);
            }
        });
        Button btn04 = (Button) findViewById(R.id.btn04);
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 04");
                Toast.makeText(getApplicationContext(), "Toggle 04", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 4);
            }
        });
        Button btn05 = (Button) findViewById(R.id.btn05);
        btn05.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 05");
                Toast.makeText(getApplicationContext(), "Toggle 05", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 5);
            }
        });
        Button btn06 = (Button) findViewById(R.id.btn06);
        btn06.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 06");
                Toast.makeText(getApplicationContext(), "Toggle 06", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 6);
            }
        });
        Button btn07 = (Button) findViewById(R.id.btn07);
        btn07.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 07");
                Toast.makeText(getApplicationContext(), "Toggle 07", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 7);
            }
        });
        Button btn08 = (Button) findViewById(R.id.btn08);
        btn08.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 08");
                Toast.makeText(getApplicationContext(), "Toggle 08", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 8);
            }
        });



        //
        //
        // Row 1
        //
        //

        Button btn10 = (Button) findViewById(R.id.btn10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 10");
                Toast.makeText(getApplicationContext(), "Toggle 10", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 10);

            }
        });
        Button btn11 = (Button) findViewById(R.id.btn11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 11");
                Toast.makeText(getApplicationContext(), "Toggle 11", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 11);
            }
        });
        Button btn12 = (Button) findViewById(R.id.btn12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 12");
                Toast.makeText(getApplicationContext(), "Toggle 12", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 12);
            }
        });
        Button btn13 = (Button) findViewById(R.id.btn13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 13");
                Toast.makeText(getApplicationContext(), "Toggle 13", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 13);
            }
        });
        Button btn14 = (Button) findViewById(R.id.btn14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 14");
                Toast.makeText(getApplicationContext(), "Toggle 14", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 14);
            }
        });
        Button btn15 = (Button) findViewById(R.id.btn15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 15");
                Toast.makeText(getApplicationContext(), "Toggle 15", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 15);
            }
        });
        Button btn16 = (Button) findViewById(R.id.btn16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 16");
                Toast.makeText(getApplicationContext(), "Toggle 16", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 16);
            }
        });
        Button btn17 = (Button) findViewById(R.id.btn17);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 17");
                Toast.makeText(getApplicationContext(), "Toggle 17", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 17);
            }
        });
        Button btn18 = (Button) findViewById(R.id.btn18);
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 18");
                Toast.makeText(getApplicationContext(), "Toggle 18", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 18);
            }
        });

        //
        //
        //Row 2
        //
        //
        //

        Button btn20 = (Button) findViewById(R.id.btn20);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 20");
                Toast.makeText(getApplicationContext(), "Toggle 20", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 20);

            }
        });
        Button btn21 = (Button) findViewById(R.id.btn21);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 21");
                Toast.makeText(getApplicationContext(), "Toggle 21", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 21);
            }
        });
        Button btn22 = (Button) findViewById(R.id.btn22);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 22");
                Toast.makeText(getApplicationContext(), "Toggle 22", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 22);
            }
        });
        Button btn23 = (Button) findViewById(R.id.btn23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 23");
                Toast.makeText(getApplicationContext(), "Toggle 23", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 23);
            }
        });
        Button btn24 = (Button) findViewById(R.id.btn24);
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 24");
                Toast.makeText(getApplicationContext(), "Toggle 24", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 24);
            }
        });
        Button btn25 = (Button) findViewById(R.id.btn25);
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 25");
                Toast.makeText(getApplicationContext(), "Toggle 25", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 25);
            }
        });
        Button btn26 = (Button) findViewById(R.id.btn26);
        btn26.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 26");
                Toast.makeText(getApplicationContext(), "Toggle 26", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 26);
            }
        });
        Button btn27 = (Button) findViewById(R.id.btn27);
        btn27.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 27");
                Toast.makeText(getApplicationContext(), "Toggle 27", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 27);
            }
        });
        Button btn28 = (Button) findViewById(R.id.btn28);
        btn28.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 28");
                Toast.makeText(getApplicationContext(), "Toggle 28", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 28);
            }
        });

        //
        //
        //Row 3
        //
        //
        //

        Button btn30 = (Button) findViewById(R.id.btn30);
        btn30.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 30");
                Toast.makeText(getApplicationContext(), "Toggle 30", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 30);

            }
        });
        Button btn31 = (Button) findViewById(R.id.btn31);
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 31");
                Toast.makeText(getApplicationContext(), "Toggle 31", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 31);
            }
        });
        Button btn32 = (Button) findViewById(R.id.btn32);
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 32");
                Toast.makeText(getApplicationContext(), "Toggle 32", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 32);
            }
        });
        Button btn33 = (Button) findViewById(R.id.btn33);
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 33");
                Toast.makeText(getApplicationContext(), "Toggle 33", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 33);
            }
        });
        Button btn34 = (Button) findViewById(R.id.btn34);
        btn34.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 34");
                Toast.makeText(getApplicationContext(), "Toggle 34", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 34);
            }
        });
        Button btn35 = (Button) findViewById(R.id.btn35);
        btn35.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 35");
                Toast.makeText(getApplicationContext(), "Toggle 35", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 35);
            }
        });
        Button btn36 = (Button) findViewById(R.id.btn36);
        btn36.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 36");
                Toast.makeText(getApplicationContext(), "Toggle 36", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 36);
            }
        });
        Button btn37 = (Button) findViewById(R.id.btn37);
        btn37.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 37");
                Toast.makeText(getApplicationContext(), "Toggle 37", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 37);
            }
        });
        Button btn38 = (Button) findViewById(R.id.btn38);
        btn38.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 38");
                Toast.makeText(getApplicationContext(), "Toggle 38", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 38);
            }
        });

        //
        //
        //Row 4
        //
        //
        //

        Button btn40 = (Button) findViewById(R.id.btn40);
        btn40.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 40");
                Toast.makeText(getApplicationContext(), "Toggle 40", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 40);

            }
        });
        Button btn41 = (Button) findViewById(R.id.btn41);
        btn41.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 41");
                Toast.makeText(getApplicationContext(), "Toggle 41", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 41);
            }
        });
        Button btn42 = (Button) findViewById(R.id.btn42);
        btn42.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 42");
                Toast.makeText(getApplicationContext(), "Toggle 42", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 42);
            }
        });
        Button btn43 = (Button) findViewById(R.id.btn43);
        btn43.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 43");
                Toast.makeText(getApplicationContext(), "Toggle 43", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 43);
            }
        });
        Button btn44 = (Button) findViewById(R.id.btn44);
        btn44.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 44");
                Toast.makeText(getApplicationContext(), "Toggle 44", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 44);
            }
        });
        Button btn45 = (Button) findViewById(R.id.btn45);
        btn45.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 45");
                Toast.makeText(getApplicationContext(), "Toggle 45", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 45);
            }
        });
        Button btn46 = (Button) findViewById(R.id.btn46);
        btn46.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 46");
                Toast.makeText(getApplicationContext(), "Toggle 46", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 46);
            }
        });
        Button btn47 = (Button) findViewById(R.id.btn47);
        btn47.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 47");
                Toast.makeText(getApplicationContext(), "Toggle 47", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 47);
            }
        });
        Button btn48 = (Button) findViewById(R.id.btn48);
        btn48.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 48");
                Toast.makeText(getApplicationContext(), "Toggle 48", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 48);
            }
        });

        //
        //
        //Row 5
        //
        //
        //

        Button btn50 = (Button) findViewById(R.id.btn50);
        btn50.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 50");
                Toast.makeText(getApplicationContext(), "Toggle 50", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 50);

            }
        });
        Button btn51 = (Button) findViewById(R.id.btn51);
        btn51.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 51");
                Toast.makeText(getApplicationContext(), "Toggle 51", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 51);
            }
        });
        Button btn52 = (Button) findViewById(R.id.btn52);
        btn52.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 52");
                Toast.makeText(getApplicationContext(), "Toggle 52", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 52);
            }
        });
        Button btn53 = (Button) findViewById(R.id.btn53);
        btn53.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 53");
                Toast.makeText(getApplicationContext(), "Toggle 53", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 53);
            }
        });
        Button btn54 = (Button) findViewById(R.id.btn54);
        btn54.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 54");
                Toast.makeText(getApplicationContext(), "Toggle 54", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 54);
            }
        });
        Button btn55 = (Button) findViewById(R.id.btn55);
        btn55.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 55");
                Toast.makeText(getApplicationContext(), "Toggle 55", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 55);
            }
        });
        Button btn56 = (Button) findViewById(R.id.btn56);
        btn56.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 56");
                Toast.makeText(getApplicationContext(), "Toggle 56", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 56);
            }
        });
        Button btn57 = (Button) findViewById(R.id.btn57);
        btn57.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 57");
                Toast.makeText(getApplicationContext(), "Toggle 57", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 57);
            }
        });
        Button btn58 = (Button) findViewById(R.id.btn58);
        btn58.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 58");
                Toast.makeText(getApplicationContext(), "Toggle 58", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 58);
            }
        });

        //
        //
        //Row 6
        //
        //
        //

        Button btn60 = (Button) findViewById(R.id.btn60);
        btn60.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 60");
                Toast.makeText(getApplicationContext(), "Toggle 60", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 60);

            }
        });
        Button btn61 = (Button) findViewById(R.id.btn61);
        btn61.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 61");
                Toast.makeText(getApplicationContext(), "Toggle 61", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 61);
            }
        });
        Button btn62 = (Button) findViewById(R.id.btn62);
        btn62.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 62");
                Toast.makeText(getApplicationContext(), "Toggle 62", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 62);
            }
        });
        Button btn63 = (Button) findViewById(R.id.btn63);
        btn63.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 63");
                Toast.makeText(getApplicationContext(), "Toggle 63", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 63);
            }
        });
        Button btn64 = (Button) findViewById(R.id.btn64);
        btn64.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 64");
                Toast.makeText(getApplicationContext(), "Toggle 64", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 64);
            }
        });
        Button btn65 = (Button) findViewById(R.id.btn65);
        btn65.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 65");
                Toast.makeText(getApplicationContext(), "Toggle 65", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 65);
            }
        });
        Button btn66 = (Button) findViewById(R.id.btn66);
        btn66.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 66");
                Toast.makeText(getApplicationContext(), "Toggle 66", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 66);
            }
        });
        Button btn67 = (Button) findViewById(R.id.btn67);
        btn67.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 67");
                Toast.makeText(getApplicationContext(), "Toggle 67", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 67);
            }
        });
        Button btn68 = (Button) findViewById(R.id.btn68);
        btn68.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 68");
                Toast.makeText(getApplicationContext(), "Toggle 68", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 68);
            }
        });

        //
        //
        //Row 7
        //
        //
        //

        Button btn70 = (Button) findViewById(R.id.btn70);
        btn70.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 70");
                Toast.makeText(getApplicationContext(), "Toggle 70", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 70);

            }
        });
        Button btn71 = (Button) findViewById(R.id.btn71);
        btn71.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 71");
                Toast.makeText(getApplicationContext(), "Toggle 71", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 71);
            }
        });
        Button btn72 = (Button) findViewById(R.id.btn72);
        btn72.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 72");
                Toast.makeText(getApplicationContext(), "Toggle 72", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 72);
            }
        });
        Button btn73 = (Button) findViewById(R.id.btn73);
        btn73.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 73");
                Toast.makeText(getApplicationContext(), "Toggle 73", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 73);
            }
        });
        Button btn74 = (Button) findViewById(R.id.btn74);
        btn74.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 74");
                Toast.makeText(getApplicationContext(), "Toggle 74", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 74);
            }
        });
        Button btn75 = (Button) findViewById(R.id.btn75);
        btn75.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 75");
                Toast.makeText(getApplicationContext(), "Toggle 75", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 75);
            }
        });
        Button btn76 = (Button) findViewById(R.id.btn76);
        btn76.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 76");
                Toast.makeText(getApplicationContext(), "Toggle 76", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 76);
            }
        });
        Button btn77 = (Button) findViewById(R.id.btn77);
        btn77.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 77");
                Toast.makeText(getApplicationContext(), "Toggle 77", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 77);
            }
        });
        Button btn78 = (Button) findViewById(R.id.btn78);
        btn78.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 78");
                Toast.makeText(getApplicationContext(), "Toggle 78", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 78);
            }
        });

        //
        //
        //Row 8
        //
        //
        //

        Button btn80 = (Button) findViewById(R.id.btn80);
        btn80.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 80");
                Toast.makeText(getApplicationContext(), "Toggle 80", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 80);

            }
        });
        Button btn81 = (Button) findViewById(R.id.btn81);
        btn81.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 81");
                Toast.makeText(getApplicationContext(), "Toggle 81", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 81);
            }
        });
        Button btn82 = (Button) findViewById(R.id.btn82);
        btn82.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 82");
                Toast.makeText(getApplicationContext(), "Toggle 82", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 82);
            }
        });
        Button btn83 = (Button) findViewById(R.id.btn83);
        btn83.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 83");
                Toast.makeText(getApplicationContext(), "Toggle 83", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 83);
            }
        });
        Button btn84 = (Button) findViewById(R.id.btn84);
        btn84.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 84");
                Toast.makeText(getApplicationContext(), "Toggle 84", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 84);
            }
        });
        Button btn85 = (Button) findViewById(R.id.btn85);
        btn85.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 85");
                Toast.makeText(getApplicationContext(), "Toggle 85", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 85);
            }
        });
        Button btn86 = (Button) findViewById(R.id.btn86);
        btn86.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 86");
                Toast.makeText(getApplicationContext(), "Toggle 86", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 86);
            }
        });
        Button btn87 = (Button) findViewById(R.id.btn87);
        btn87.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 87");
                Toast.makeText(getApplicationContext(), "Toggle 87", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 87);
            }
        });
        Button btn88 = (Button) findViewById(R.id.btn88);
        btn88.setOnClickListener(new View.OnClickListener() {
            @Override()
            public void onClick(View view) {
                Log.i(TAG, "Toggle 88");
                Toast.makeText(getApplicationContext(), "Toggle 88", Toast.LENGTH_SHORT).show();
                toggleLed((byte) 88);
            }
        });


    }

    // fast way to call Toast
    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    //sends information based on button pressed to the adafruit
    private void toggleLed(byte num)
    {
        if (btSocket != null)
        {
            try
            {
                btSocket.getOutputStream().write(num);
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    //connects to the bluetooth module
    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(ledControl.this, "Connecting...", "Please wait!!!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();//start connection
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
