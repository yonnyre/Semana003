package com.example.yonny.semana3;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.media.RingtoneManager;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    private Spinner spinner1;
    private RadioGroup radioGroup;
    private CheckBox checkBox;
    int N,M,B,suma,resta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        // Setting check to specific checkbox
        //checkBox.setChecked(true);
        //if (checkBox.isChecked())
        //   Toast.makeText(this, "First checkbox is checked!", Toast.LENGTH_LONG).show();

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String i=parent.getItemAtPosition(pos).toString();


               if(i.equals("Americana")) {N=15;
                   //   Toast.makeText(parent.getContext(),
                   //   "You have selected : " + i,
                   //   Toast.LENGTH_SHORT).show();
               }else if(i.equals("Pepperoni")){ N=16;
               }else if(i.equals("Hawaina")){N=17;
               }else if(i.equals("Continental")){N=18;
               }else if(i.equals("Vegetariana")){N=19;
               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg) {

            }

        });
    }

    public void showvalue(View view) {
        String item = (String) spinner1.getSelectedItem();
        //Toast.makeText(this, "You have selected : " + item, Toast.LENGTH_SHORT).show();
    }

    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // This check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
             M=6;
                    //Do something when radio button is clicked
                    break;

            case R.id.radioButton2:
                //Do something when radio button is clicked
                //Toast.makeText(getApplicationContext(), "It seems like you feel LinearLayout easy", Toast.LENGTH_SHORT).show();
              M=8;
                break;

            case R.id.radioButton3:
                //Do something when radio button is clicked
                //Toast.makeText(getApplicationContext(), "It seems like you feel FrameLayout easy", Toast.LENGTH_SHORT).show();
                M=9;
                break;

        }

    }

    public void androidCheckBoxClicked(View view) {
        // action for checkbox click

        switch (view.getId()) {
            case R.id.checkBox:
                CheckBox checkBox = (CheckBox) view;
                if (checkBox.isChecked())
                 B=7;
                    //  Toast.makeText(this, checkBox.getText() + " selected!", Toast.LENGTH_LONG).show();
                    break;
            case R.id.checkBox2:
                //DO something when user check the box[Completar cada caso]
                B=8;
                break;
        }
    }




    public void showDialog(View view) {

         int suma=M+B;

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Confirmacion de pedido");
        dialogo1.setMessage("Su pedido Hawaina con masa" +suma+
                "gruesa y extra jamon esta a S/.65.00 + IGV esta enproceso de envio");
        dialogo1.setCancelable(false);

        dialogo1.show();







        final Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Confirmado")
                .setContentText("Su pizza llegara aproximadamente dentro de 1h")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true)
                .build();

        // Notification manager
        final NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);


        new CountDownTimer(10000, 1000) {
            public void onFinish() {
                // Notification manager
                notificationManager.notify(15, notification);

            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        }.start();

    }


}




