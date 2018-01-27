package com.example.yukimakura.btdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by yukimakura on 2017/03/09.
 */

public class BTcontroller extends Activity {
    BluetoothCommunicatorListener BLC;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.controllerlayout);

        //遷移元のインテントを格納
        Intent beforeintent = getIntent();
        String BTname = beforeintent.getStringExtra("btname");
        TextView BTnameview = (TextView)findViewById(R.id.infotext);
        final BluetoothCommunicator BTcom = new BluetoothCommunicator(this,BLC,BTname);

        BTcom.getBtname(BTname);
        BTnameview.setText(BTname);

        Button up = (Button)findViewById(R.id.up);
        Button left = (Button)findViewById(R.id.left);
        Button back = (Button)findViewById(R.id.back);
        Button right = (Button)findViewById(R.id.right);

        //シリアル通信のためマイコン側はasciiコードに対応させる

        View.OnClickListener onClickListener_up = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BTcom.writeMessage("a");
                //ASCIIで97
            }
        };
        View.OnClickListener onClickListener_left = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BTcom.writeMessage("b");
                //ASCIIで98
            }
        };
        View.OnClickListener onClickListener_back = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BTcom.writeMessage("c");
                //ASCIIで99
            }
        };
        View.OnClickListener onClickListener_right = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BTcom.writeMessage("d");
                //ASCIIで100
            }
        };

        up.setOnClickListener(onClickListener_up);
        left.setOnClickListener(onClickListener_left);
        back.setOnClickListener(onClickListener_back);
        right.setOnClickListener(onClickListener_right);
    }


}
