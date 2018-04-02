package com.example.marcosvinicius.requisition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.btnSearch);
        editText =(EditText) findViewById(R.id.edtCep);
        textView= (TextView) findViewById(R.id.txtDados);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pesquisar os dados do cep
                try{
                    CEP retorno= new HttpService(editText.getText().toString()).execute().get();
                    textView.setText(retorno.toString());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }catch (ExecutionException ex){
                    ex.printStackTrace();

                }
            }
        });
    }
}
