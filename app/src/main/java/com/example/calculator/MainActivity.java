package com.example.calculator;

//import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.AppComponentFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.P)
public class MainActivity extends AppComponentFactory implements View.OnClickListener {
    TextView tv,tv2;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bmul, bdiv, bplus, bminus, bdot, bequal,bCE,bDEL;
    String op1, op2,g, op,i;
    int y,k,w,a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = b2.findViewById();
        tv2 = findViewById(R.id.t2);
        b1 = b1.findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = b1.findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bplus = findViewById(R.id.bplus);
        bminus = findViewById(R.id.bminus);
        bdot = findViewById(R.id.bdot);
        bdiv = findViewById(R.id.bdiv);
        bmul = findViewById(R.id.bmul);
        bequal = findViewById(R.id.bequal);
        bCE = findViewById(R.id.bCE);
        bDEL = findViewById(R.id.bDEL);

        bCE.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bplus.setOnClickListener(this);
        bminus.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bequal.setOnClickListener(this);
        bDEL.setOnClickListener(this);


    }

    private void setContentView(int activity_main) {
    }


    void calc() {
        float x, y, z;
        x = Float.parseFloat(op1);
        y = Float.parseFloat(op2);
        if(op.equals("+"))
            z = x + y;
        else if (op.equals("-"))
            z = x - y;
        else if (op.equals("*"))
            z = x * y;
        else
            z = x / y;
        tv.setText(""+z);
    }
    void calc2() {
        float l,n,m;
        l = Float.parseFloat(op1);
        n = Float.parseFloat(g);
        if(op.equals("+"))
            m = l + n;
        else if (op.equals("-"))
            m = l - n;
        else if (op.equals("*"))
            m = l * n;
        else
            m =  l / n;
        tv2.setText(""+m);
    }

    @Override
    public void onClick(View view) {
        Button b = (Button)view;
        if (b == b9 || b == b8 || b == b7 || b == b6 || b == b5 || b == b4 || b == b3 || b == b2 || b == b1 || b == b0 || b== bdot || b==bDEL ) {


            if (k == 0) {

                tv.setText(b.getText().toString());
                k = 1;


                            }
                else if(b==bdot)
                {
                    if(w==0)
                    tv.setText(tv.getText().toString() + b.getText().toString());
                    w=1;
                }
            else if(b == bDEL)
            {

                i=tv.getText().toString();

               String str1 =  i.substring(0,i.length()-1);
                Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();
                tv.setText(""+str1);

            }
                 else {

                    tv.setText(tv.getText().toString() + b.getText().toString());
                    if(y==1)
                    {
                         g=tv.getText().toString();

                        calc2();
                        y=1;
                    }
                 }
        }


          if(b == bplus || b == bminus || b == bmul || b == bdiv) {
              op1 = tv.getText().toString();
              tv.setText(b.getText().toString());
              op = b.getText().toString();
              k = 0;
              w = 0;
              y = 1;

        }

          if (b == bequal)
        {
            op2 = tv.getText().toString();
            calc();
            tv2.setText("");

        }
          if(b == bCE)
          {
              tv.setText("0");
              k=0;
          }

    }
}