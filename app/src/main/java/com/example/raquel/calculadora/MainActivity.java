package com.example.raquel.calculadora;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    Double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = (EditText) findViewById(R.id.editTextNuber1);
        number2 = (EditText) findViewById(R.id.editTextNuber2);
        Button soma= (Button) findViewById(R.id.buttonSoma);
        Button subtrair = (Button) findViewById(R.id.buttonSubtracao);
        Button multiplicar = (Button) findViewById(R.id.buttonMultiplicacao);
        Button dividir = (Button) findViewById(R.id.buttonDivisao);

        soma.setOnClickListener(listenerSommar);
        subtrair.setOnClickListener(listenerSubtrair);
        multiplicar.setOnClickListener(listenerMultiplicar);
        dividir.setOnClickListener(listenerDividir);
    }

   private View.OnClickListener listenerSommar = new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if((number1.getText() !=null && !number1.getText().toString().trim().equals("")) &&
                   (number2.getText() !=null && !number2.getText().toString().trim().equals(""))){
               resultado= Double.parseDouble(number1.getText().toString()) + Double.parseDouble(number2.getText().toString());
               Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
               intent.putExtra("RESULTADO",resultado);
               startActivity(intent);
           }
       }
   };

    private View.OnClickListener listenerSubtrair = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if((number1.getText() !=null && !number1.getText().toString().trim().equals("")) &&
                    (number2.getText() !=null && !number2.getText().toString().trim().equals(""))){
                resultado= Double.parseDouble(number1.getText().toString()) - Double.parseDouble(number2.getText().toString());
                Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
                intent.putExtra("RESULTADO",resultado);
                startActivity(intent);

            }
        }
    };

    private View.OnClickListener listenerMultiplicar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if((number1.getText() !=null && !number1.getText().toString().trim().equals("")) &&
                    (number2.getText() !=null && !number2.getText().toString().trim().equals(""))){
                resultado= Double.parseDouble(number1.getText().toString()) * Double.parseDouble(number2.getText().toString());
                Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
                intent.putExtra("RESULTADO",resultado);
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener listenerDividir = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if((number1.getText() !=null && !number1.getText().toString().trim().equals("")) &&
                    (number2.getText() !=null && !number2.getText().toString().trim().equals(""))){
                if(number2.getText().toString().trim().equals("0")){
                    AlertDialog.Builder builder =  new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Voce nao pode dividir por 0").setTitle("Atencao!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            number2.setText("");
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }else{
                    resultado= Double.parseDouble(number1.getText().toString()) / Double.parseDouble(number2.getText().toString());
                    Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
                    intent.putExtra("RESULTADO",resultado);
                    startActivity(intent);
                }

            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        number2.setText("");
        number1.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
