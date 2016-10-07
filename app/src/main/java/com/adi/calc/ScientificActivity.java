package com.adi.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.udojava.evalex.Expression;

public class ScientificActivity extends MainActivity
{
    String eq1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

        Intent intent = getIntent();
        eq1 = intent.getStringExtra("equation");
        TextView t1 = (TextView)findViewById(R.id.displayBox);
        t1.setText(eq1);

    }

    public void eqGen1(View view)
    {
        TextView t = (TextView)findViewById(R.id.displayBox);
        Button num = (Button)findViewById(view.getId());
        String b= String.valueOf(num.getText());
        eq1=eq1+b;
        t.setText(eq1);
    }

    public void calcFunc1(View view)
    {
        TextView t = (TextView) findViewById(R.id.displayBox);
        if (eq1 == "")
        {
            t.setText("Enter Values");
        } else
        {
            Expression exp = new Expression(eq1);
            eq1 = String.valueOf(exp.eval().doubleValue());
            t.setText(eq1);
        }
    }

    public void clearFunc1(View view)
    {
        eq1="";
        TextView t = (TextView) findViewById(R.id.displayBox);
        t.setText(eq1);
    }

    public void launchSimple(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("equation1",eq1);
        startActivity(intent);
    }

    public void printFunc(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Solved using MathMachine by Adi:"+eq1);
        startActivity(intent);
    }
}
