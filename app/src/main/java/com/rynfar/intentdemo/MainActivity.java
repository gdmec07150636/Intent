package com.rynfar.intentdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private EditText editText1,editText2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.url);
        editText2 = (EditText) findViewById(R.id.phone);
        textView = (TextView) findViewById(R.id.textView1);

    }

    public void componentname(View v){
        ComponentName componentName = new ComponentName(this,IntentDemo3.class);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        startActivity(intent);
    }

    public void intentfilter(View v){
        String action = "com.rynfar.i";
        Intent intent = new Intent();
        intent.setAction(action);
        startActivity(intent);
    }

    public void view(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(editText1.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }

    public void dial(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:"+editText2.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }

    public void startAFS(View v){
        Bundle bundle = new Bundle();
        bundle.putString("value",editText1.getText().toString());
        Intent intent = new Intent(MainActivity.this,IntentDemo2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 10:
                Bundle bundle = data.getExtras();
                textView.setText(bundle.getString("result"));
                break;
        }
    }
}
