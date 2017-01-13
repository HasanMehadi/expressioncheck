package com.example.user.expressioncheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etExpression = (EditText)findViewById(R.id.etExpression);
        final EditText etResult = (EditText)findViewById(R.id.etResult);

        final Button btnCheck = (Button)findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                try {
                        String foo = etExpression.getText().toString();
                        String string = engine.eval(foo).toString();
                        etResult.setText(foo);

                }catch (ScriptException e){
                   etResult.setText(e.getCause().toString());
                }

            }
        });

    }
}
