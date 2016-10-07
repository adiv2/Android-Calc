package com.adi.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

import com.udojava.evalex.Expression;

public class MainActivity extends AppCompatActivity
{
    String eq="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        eq = intent.getStringExtra("equation1");
        if(eq==null)
        {
        eq="";
        }

        TextView t = (TextView) findViewById(R.id.displayBox);
        t.setText(eq);

    }

    public void eqGen(View view)
    {
        TextView t = (TextView)findViewById(R.id.displayBox);
        Button num = (Button)findViewById(view.getId());
        String b= String.valueOf(num.getText());
        eq=eq+b;
        t.setText(eq);
    }

    public void calcFunc(View view)
    {
        TextView t = (TextView) findViewById(R.id.displayBox);
        if (eq == "")
        {
            t.setText("Enter Values");
        } else
        {
            Expression exp = new Expression(eq);
            eq = String.valueOf(exp.eval().doubleValue());
            t.setText(eq);
        }
    }

    public void clearFunc(View view)
    {
        eq="";
        TextView t = (TextView) findViewById(R.id.displayBox);
        t.setText(eq);
    }

    public void launchSci(View view)
    {
        Intent intent = new Intent(this,ScientificActivity.class);
        intent.putExtra("equation",eq);
        startActivity(intent);
    }

}
