package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String result = "";
    private TextView value;
    private char operator = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = findViewById(R.id.textView);

        Button btn0 = findViewById(R.id.button_0);
        Button btn1 = findViewById(R.id.button_1);
        Button btn2 = findViewById(R.id.button_2);
        Button btn3 = findViewById(R.id.button_3);
        Button btn4 = findViewById(R.id.button_4);
        Button btn5 = findViewById(R.id.button_5);
        Button btn6 = findViewById(R.id.button_6);
        Button btn7 = findViewById(R.id.button_7);
        Button btn8 = findViewById(R.id.button_8);
        Button btn9 = findViewById(R.id.button_9);
        Button btnDot = findViewById(R.id.button_dot);

        Button btnPlus = findViewById(R.id.button_plus);
        Button btnMinus = findViewById(R.id.button_minus);
        Button btnMult = findViewById(R.id.button_mult);
        Button btnDiv = findViewById(R.id.button_div);
        Button btnPercentage = findViewById(R.id.button_percentage);

        Button btnEquals = findViewById(R.id.button_equals);
        Button btnDel = findViewById(R.id.button_del);
        Button btnClear = findViewById(R.id.button_clear);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('0', true);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('1', true);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('2', true);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('3', true);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('4', true);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('5', true);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('6', true);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('7', true);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('8', true);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('9', true);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!value.getText().toString().contains(".")) {
                    addContent('.', true);
                }
            }
        });

        // Operator Buttons event setters

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('+', false);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('-', false);
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('*', false);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('/', false);
            }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContent('%', false);
            }
        });

        // Actions buttons event setters

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double doubleValue = (
                        value.getText().toString().equals(""))
                            ? 0
                            : Double.parseDouble(value.getText().toString()
                );
                Double doubleResult = Double.valueOf(result);

                if(operator != ' '){
                    double resultValue;

                    switch (operator) {
                        case ('+'):
                            resultValue = (doubleResult + doubleValue);
                            break;
                        case ('-'):
                            resultValue = (doubleResult - doubleValue);
                            break;
                        case ('*'):
                            resultValue = (doubleResult * doubleValue);
                            break;
                        case ('/'):
                            resultValue = (doubleResult / doubleValue);
                            break;
                        case ('%'):
                            resultValue = (doubleResult / doubleValue * 100);
                            break;
                        default:
                            resultValue = doubleValue;
                    }
                    result = "";
                    operator = ' ';
                    value.setText(String.valueOf(resultValue));
                } else {
                    value.setText(String.valueOf(doubleValue));
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtValue = value.getText().toString();
                if(txtValue.length() > 1) {
                    value.setText(txtValue.substring(0, txtValue.length() - 1));
                } else {
                    value.setText("0");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.setText("0");
                operator = ' ';
                result = "";
            }
        });
    }

    private void addContent(char content, boolean isNumber){
        if(isNumber) {
            System.out.println(value.getText().toString());
            System.out.println("Pressed Number " + content);
            if(value.getText().toString().equals("0")){
                value.setText(String.valueOf(content));
            } else {
                value.append(String.valueOf(content));
            }
        } else {
            System.out.println("Pressed Button " + content);
            if(operator != ' ' && value.getText().toString().equals("0")){
                System.out.println("Changing Operator from (" + operator + ") to (" + content + ").");
                operator = content;
            } else {
                if (result.equals("")) {
                    result = value.getText().toString();
                    operator = content;
                    value.setText("0");
                } else {
                    double resultValue;
                    Double doubleValue = (value.getText().toString().equals("")) ? 0 : Double.parseDouble(value.getText().toString());
                    Double doubleResult = Double.valueOf(result);
                    switch (operator) {
                        case ('+'):
                            resultValue = (doubleResult + doubleValue);
                            break;
                        case ('-'):
                            resultValue = (doubleResult - doubleValue);
                            break;
                        case ('*'):
                            resultValue = (doubleResult * doubleValue);
                            break;
                        case ('/'):
                            resultValue = (doubleResult / doubleValue);
                            break;
                        case ('%'):
                            resultValue = (doubleValue / doubleResult * 100);
                            break;
                        default:
                            resultValue = doubleValue;
                    }
                    result = "";
                    operator = ' ';
                    value.setText(String.valueOf(resultValue));
                }
            }
        }
    }
}