package com.cosofteck.gpiodemo;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	//private static final String TAG = "GpioDemo";
	Button mButtonSetDirect,mButtonGetDirect,mButtonSetValue,mButtonGetValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mButtonSetDirect=(Button)findViewById(R.id.button1);
        mButtonGetDirect=(Button)findViewById(R.id.button2);
        mButtonSetValue=(Button)findViewById(R.id.button3);
        mButtonGetValue=(Button)findViewById(R.id.button4);
        
        mButtonSetDirect.setOnClickListener(new ButtonClickEvent());
        mButtonGetDirect.setOnClickListener(new ButtonClickEvent());
        mButtonSetValue.setOnClickListener(new ButtonClickEvent());
        mButtonGetValue.setOnClickListener(new ButtonClickEvent());
    }
    
    class ButtonClickEvent implements View.OnClickListener {
		public void onClick(View v)
		{
			if (v == mButtonSetDirect) {
			    int Direction = GpioControl.readGpioDirection(192);	//��ȡPG0���������״̬
                if(Direction == 0) {
                    GpioControl.writeGpioDirection(192, 1); //����PG0Ϊ���
                }
				else {
                    GpioControl.writeGpioDirection(192, 0); //����PG0Ϊ����
                }
			} 
			else if (v== mButtonGetDirect){
				int nDirect = GpioControl.readGpioDirection(192);	//��ȡPG0���������״̬
                if(nDirect == 1) {
                    ShowMessage("1");
                }
                else
                {
                    ShowMessage("0");
                }
			}
			else if (v== mButtonSetValue){
			    int Value = GpioControl.readGpioValue(192);  //��ȡPG0�������ƽ
                if(Value == 0) {
                    GpioControl.writeGpioValue(192, 1);	//PG0Ϊ���ʱ������Ϊ�ߵ�ƽ
                }
				else {
                    GpioControl.writeGpioValue(192, 0);	//PG0Ϊ���ʱ������Ϊ�͵�ƽ
                }
			}
			else if (v== mButtonGetValue){
				int nValue = GpioControl.readGpioValue(192);  //��ȡPG0�������ƽ
                if(nValue == 1) {
                    ShowMessage("1");
                }
                else
                {
                    ShowMessage("0");
                }
			}
		}
    }
    private void ShowMessage(String sMsg)
    {
        Toast.makeText(this, sMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
