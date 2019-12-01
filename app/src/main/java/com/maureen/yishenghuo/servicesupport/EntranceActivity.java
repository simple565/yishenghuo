package com.maureen.yishenghuo.servicesupport;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

import java.util.Set;
import java.util.UUID;

public class EntranceActivity extends AppCompatActivity {
    private boolean isOpen = false;//蓝牙是否开启标志
    private static UUID sUUID = UUID.fromString("B8:27:EB:3B:98:A9");
    private BluetoothAdapter mBluetoothAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        iniView();
        checkBluetooth();
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.entrance_titlebar);
        mTitleBar.setText("门禁系统");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btn_main = findViewById(R.id.entrance_btn_main_door);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoor(isOpen);
            }
        });
        Button btn_aside = findViewById(R.id.entrance_btn_aside_door);
        btn_aside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoor(isOpen);
            }
        });
        Button btn_north = findViewById(R.id.entrance_btn_north_door);
        btn_north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoor(isOpen);
            }
        });
        Button btn_department = findViewById(R.id.entrance_btn_department_door);
        btn_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoor(isOpen);
            }
        });

    }

    private void checkBluetooth() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "此设备不支持蓝牙", Toast.LENGTH_SHORT).show();
        } else if (!mBluetoothAdapter.isEnabled()) {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setMessage("需要开启蓝牙才能使用门禁功能")
                    .setNegativeButton("稍后", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss ();
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("开启", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mBluetoothAdapter.enable();//开启蓝牙
                            isOpen = true;
                        }
                    }).create();
            dialog.show();
        }
    }

    private void openDoor(boolean isOpen) {
        if (isOpen) {
            //新线程
            Set<BluetoothDevice> device = mBluetoothAdapter.getBondedDevices();
            Log.e("测试", device.size() + "");
        } else {
            Toast.makeText(this, "请先开启蓝牙", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBluetoothAdapter.disable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBluetoothAdapter.disable();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mBluetoothAdapter.enable();
        isOpen = true;
    }
}
