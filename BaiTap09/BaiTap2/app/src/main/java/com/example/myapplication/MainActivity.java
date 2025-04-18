package com.example.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button btnPaired;
    ListView listDanhSach;
    public static int REQUEST_BLUETOOTH = 1;
    //Bluetooth
    private BluetoothAdapter myBluetooth = null;
    private Set<BluetoothDevice> pairedDevices;
    public static String EXTRA_ADDRESS = "device_address";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        btnPaired = (Button) findViewById(R.id.btnTimthietbi);
//        listDanhSach = (ListView) findViewById(R.id.listTb);
//
//// Kiểm tra thiết bị có Bluetooth
//        myBluetooth = BluetoothAdapter.getDefaultAdapter();
//        if (myBluetooth == null) {
//            // Show a message that the device has no bluetooth adapter
//            Toast.makeText(getApplicationContext(), "Thiết bị Bluetooth chưa bật", Toast.LENGTH_LONG).show();
//            finish();
//        } else if (!myBluetooth.isEnabled()) {
//            // Ask to turn the Bluetooth on
//            Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT)
//                    != PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(getApplicationContext(), "Thiết bị Bluetooth chưa bật", Toast.LENGTH_LONG).show();
//                return;
//            }
//            Toast.makeText(getApplicationContext(), "Thiết bị Bluetooth đã bật", Toast.LENGTH_LONG).show();
//            // starForResult.launch(turnBTon);
//            startActivityForResult(turnBTon, REQUEST_BLUETOOTH);
//        }
//
//// Kết thúc kiểm tra thiết bị có bluetooth
//// Thực hiện tìm thiết bị
//        btnPaired.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pairedDevicesList(); // Gọi hàm tìm thiết bị
//            }
//        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}