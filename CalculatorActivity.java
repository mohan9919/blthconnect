package com.tm.bltuth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editTextScreen;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnPlus;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnMinus;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnMultiply;
    private Button btnClear;
    private Button btnZero;
    private Button btnEqual;
    private Button btnDevided;

    private float mValueOne, mValueTwo;
    boolean mAddition, mSubtruction, mMultiplication, mDevition;
    private String str="";
    private Character op='q';
    private int i, num, tempnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextScreen=(EditText) findViewById(R.id.et_screen);
        btnOne=(Button)findViewById(R.id.btn_one);
        btnTwo=(Button)findViewById(R.id.btn_two);
        btnThree=(Button)findViewById(R.id.btn_three);
        btnPlus=(Button)findViewById(R.id.btn_plus);
        btnFour=(Button)findViewById(R.id.btn_four);
        btnFive=(Button)findViewById(R.id.btn_five);
        btnSix=(Button)findViewById(R.id.btn_six);
        btnMinus=(Button)findViewById(R.id.btn_minus);
        btnSeven=(Button)findViewById(R.id.btn_seven);
        btnEight=(Button)findViewById(R.id.btn_eight);
        btnNine=(Button)findViewById(R.id.btn_nine);
        btnMultiply=(Button)findViewById(R.id.btn_multiply);
        btnClear=(Button)findViewById(R.id.btn_clear);
        btnZero=(Button)findViewById(R.id.btn_zero);
        btnEqual=(Button)findViewById(R.id.btn_equal);
        btnDevided=(Button)findViewById(R.id.btn_devided);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(1);
                editTextScreen.setText(editTextScreen.getText()+"1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(2);
                editTextScreen.setText(editTextScreen.getText()+"2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(3);
                editTextScreen.setText(editTextScreen.getText()+"3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(4);
                editTextScreen.setText(editTextScreen.getText()+"4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(5);
                editTextScreen.setText(editTextScreen.getText()+"5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(6);
                editTextScreen.setText(editTextScreen.getText()+"6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(7);
                editTextScreen.setText(editTextScreen.getText()+"7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(8);
                editTextScreen.setText(editTextScreen.getText()+"8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(9);
                editTextScreen.setText(editTextScreen.getText()+"9");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert(0);
                editTextScreen.setText(editTextScreen.getText()+"0");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform();
                //op='+';
                if(editTextScreen==null){
                    editTextScreen.setText("");
                }else{
                    mValueOne=Float.parseFloat(editTextScreen.getText()+"");
                    mAddition=true;
                    editTextScreen.setText(null);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform();
                //op='-';
                if(editTextScreen==null){
                    editTextScreen.setText("");
                }else{
                    mValueOne=Float.parseFloat(editTextScreen.getText()+"");
                    mSubtruction=true;
                    editTextScreen.setText(null);
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform();
                //op='*';
                if(editTextScreen==null){
                    editTextScreen.setText("");
                }else{
                    mValueOne=Float.parseFloat(editTextScreen.getText()+"");
                    mMultiplication=true;
                    editTextScreen.setText(null);
                }
            }
        });

        btnDevided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform();
                //op='/';
                if(editTextScreen==null){
                    editTextScreen.setText("");
                }else{
                    mValueOne=Float.parseFloat(editTextScreen.getText()+"");
                    mDevition=true;
                    editTextScreen.setText(null);
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calculate();
                mValueTwo=Float.parseFloat(editTextScreen.getText()+"");

                if(mAddition==true){
                    editTextScreen.setText(mValueOne+mValueTwo + "");
                    mAddition=false;
                }else if(mSubtruction==true){
                    editTextScreen.setText(mValueOne-mValueTwo +"");
                    mSubtruction=false;
                }else if(mMultiplication==true){
                    editTextScreen.setText(mValueOne*mValueTwo +"");
                    mMultiplication=false;
                }else if(mDevition==true){
                    editTextScreen.setText(mValueOne/mValueTwo +"");
                    mDevition=false;
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    public void reset(){
        str="";
        op='q';
        num=0;
        tempnum=0;
        editTextScreen.setText("");
    }

    public void perform(){
        str="";
        tempnum=num;
    }

    public void calculate(){
        if(op=='+'){
            num=tempnum+num;
        }else if(op=='-'){
            num=tempnum-num;
        }else if(op=='*'){
            num=tempnum*num;
        }else if (op=='/'){
            num=tempnum/num;
        }

        editTextScreen.setText("" +num);
    }

    public void insert(int i){
        str=str+Integer.toString(i);
        num=Integer.valueOf(str).intValue();
        editTextScreen.setText(str);
    }

}
