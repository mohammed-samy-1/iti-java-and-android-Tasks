package com.iti_task.finalproject.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iti_task.finalproject.R;
import com.iti_task.finalproject.databinding.ActivityCaculatorBinding;

import java.util.Objects;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn0, btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9, add, sub,
            div, mul, clear, equal, point, sq, oneOver;
    private TextView tv, ans;
    private String op = "";
    private ActivityCaculatorBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCaculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
        initAction();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    private void initViews() {
        btn0 = binding.button0;
        btn1 = binding.button1;
        btn2 = binding.button2;
        btn3 = binding.button3;
        btn4 = binding.button4;
        btn5 = binding.button5;
        btn6 = binding.button6;
        btn7 = binding.button7;
        btn8 = binding.button8;
        btn9 = binding.button9;
        point = binding.buttonPoint;

        add = binding.buttonAdd;
        sub = binding.buttonSub;
        div = binding.div;
        mul = binding.buttonMul;
        sq = binding.buttonPower;
        oneOver = binding.button1Over;

        clear = binding.buttonClear;
        equal = binding.buttonEqual;

        tv = binding.resultTextView;
        ans = binding.ans;
    }
    private void initAction() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        point.setOnClickListener(this);
        sq.setOnClickListener(this);
        oneOver.setOnClickListener(this);

        clear.setOnClickListener(v -> {
            tv.setText("0");
            ans.setText("");
            op = "";
        });

        equal.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_equal: {
                Toast.makeText(this, op, Toast.LENGTH_SHORT).show();
                String s = ans.getText().toString() + tv.getText().toString();
                op += tv.getText().toString();
                String s2 = op.replace("×", "*");
                s2 = s2.replace("÷", "/");
                try {
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByName("rhino");
                    Object a = engine.eval(s2);
                    String r = s + "=";
                    tv.setText(a.toString());
                    ans.setText(r);
                    op = "";
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }
            break;
            case R.id.button_sub:
            case R.id.button_add:
            case R.id.button_mul:
            case R.id.div: {
                if (validate())
                    return;

                String s = ans.getText().toString()
                        + tv.getText().toString()
                        + ((Button) v).getText().toString();
                op += tv.getText().toString()
                        + ((Button) v).getText().toString();
                tv.setText("0");
                ans.setText(s);
            }
            break;
            case R.id.button_power:
                if (tv.getText().toString().equals("0"))
                    return;
                String s = ans.getText().toString()
                        + "(" + tv.getText().toString() + "^2)";
                op += "Math.pow(" + tv.getText().toString() + ",2)";
                tv.setText("");
                ans.setText(s);
                break;
            case R.id.button_1_over:
                if (validate())
                    return;
                s = "1/"+tv.getText().toString();
                op += s;
                s= ans.getText().toString() +s;
                ans.setText(s);
                tv.setText("");
                break;
            default: {
                if (op.isBlank())
                    ans.setText("");
                s = (tv.getText().toString().equals("0") ? "" : tv.getText().toString())
                        + ((Button) v).getText().toString();
                tv.setText(s);
            }
            break;
        }
    }

    public boolean validate() {
        int len = ans.getText().toString().length();
        char last = ' ';
        if (len > 0) {
            last = ans.getText().toString().charAt(len - 1);
        }
        return tv.getText().toString().equals("0")
                &&
                (last == '+'
                        || last == '-'
                        || last == '÷'
                        || last == '×');

    }

}