package standard.calculator.com.standard_calculator;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Stack;


public class MainActivity extends Activity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button mclear;
    private Button mrecall;
    private Button mplus;
    private Button mminus;
    private Button percent;
    private Button allclear;
    private Button div;
    private Button mul;
    private Button add;
    private Button sub;
    private Button equal;
    private Button answer;
    private Button point;
    private Button close_bracket;
    private Button open_bracket;
    private TextView display;
    private TextView result;
    private TextView store;
    private String ch = "%";
    private int z;
    private EditText val1;
    private EditText val2;
    private Boolean abc;
    public int brac_count=0;
    private Vibrator mvibrate;
    public int button_vib_len=30;


    public void setupUIViews(){

        zero = (Button)findViewById(R.id.btn0);
        answer = (Button)findViewById(R.id.btnans);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        allclear = (Button)findViewById(R.id.btn_ac);
        mclear = (Button)findViewById(R.id.btnmc);
        mrecall = (Button)findViewById(R.id.btnmr);
        mplus = (Button)findViewById(R.id.btn_mplus);
        mminus = (Button)findViewById(R.id.btn_mminus);
        percent = (Button)findViewById(R.id.btnper);
        div = (Button)findViewById(R.id.btndiv);
        mul = (Button)findViewById(R.id.btnmul);
        add = (Button)findViewById(R.id.btnplus);
        sub = (Button)findViewById(R.id.btnminus);
        equal = (Button)findViewById(R.id.btneql);
        point = (Button)findViewById(R.id.btnpoint);
        display = (TextView)findViewById(R.id.display);
        result = (TextView)findViewById(R.id.result);
        close_bracket= (Button)findViewById(R.id.btn_cbrac);
        open_bracket = (Button)findViewById(R.id.btn_obrac);
        store = (TextView)findViewById(R.id.memory_display);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        setupUIViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("0");
            }
        });

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Form_calculate_Expression("0");
                btn_vibrate(button_vib_len);
                if(result.getText().length()!=0) {
                    brac_count = 0;
                    if (result.getText().toString().charAt(0)=='-'){
                        display.setText(null);
                        Form_calculate_Expression("(");
                        display.setText(display.getText().toString() + result.getText().toString());
                        return;
                    }
                    display.setText(result.getText().toString());
                    result.setText(null);
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("9");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression(".");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("-");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("/");
            }
        });

        close_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression(")");
            }
        });

        open_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("(");
            }
        });


        allclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                if(display.getText().length() > 0){
                    CharSequence name = display.getText().toString();
                    if(name.charAt(name.length()-1)=='(') {
                        brac_count--;
                    }
                    else if(name.charAt(name.length()-1)==')') {
                        brac_count++;
                    }
                    display.setText(name.subSequence(0,name.length()-1));
                    if(display.getText().length() == 0)
                    {
                        result.setText(null);
                    }
                }
            }
        });

        allclear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                btn_vibrate(button_vib_len);
                display.setText(null);
                result.setText(null);
                brac_count=0;
                return false;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                try{
                    String input = display.getText().toString();
                    char last_ch=input.charAt(input.length()-1);
                    if (display.getText().toString().contains(ch)) {
                        if(brac_count!=0)
                        {
                            Toast.makeText(getApplicationContext(), "Braces () added improperly", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(last_ch=='+' || last_ch=='-' || last_ch=='*'|| last_ch=='/' || last_ch=='%' || last_ch=='.')
                        {
                            Toast.makeText(getApplicationContext(), "Incomplete Expression", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        input = input.replace(getString(R.string.ch), "*.01*");
                        EvaluateString evaluateString = new EvaluateString();
                        float temp = evaluateString.evaluate(input.toString());
                        display.setText(display.getText().toString());
                        result.setText(String.valueOf(temp));

                    }
                    else {
                        if(brac_count!=0)
                        {
                            Toast.makeText(getApplicationContext(), "Braces () added improperly", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(last_ch=='+' || last_ch=='-' || last_ch=='*'|| last_ch=='/' || last_ch=='%' || last_ch=='.')
                        {
                            Toast.makeText(getApplicationContext(), "Incomplete Expression", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        EvaluateString evaluateString = new EvaluateString();
                        float temp = evaluateString.evaluate(display.getText().toString());
                        result.setText(String.valueOf(temp));
                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Invalid Expression", Toast.LENGTH_SHORT).show();

                }
            }
        });


        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                Form_calculate_Expression("%");
            }
        });


        mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                com("+");
            }
        });

        mminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                com("-");
            }
        });

        mrecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                if (store.getText().toString().charAt(0)=='-') {
                    display.setText(null);
                    Form_calculate_Expression("(");
                    display.setText(display.getText().toString() + store.getText().toString());
                    return;
                }

                display.setText(store.getText().toString());
            }
        });

        mclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_vibrate(button_vib_len);
                store.setText("0.0");
            }
        });


    }

    public class EvaluateString
    {
        public float evaluate(String expression)
        {
            char[] tokens = expression.toCharArray();

            // Stack for numbers: 'values'
            Stack<Float> values = new Stack<Float>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new Stack<Character>();


            for (int i = 0; i < tokens.length; i++)
            {
                // Current token is a whitespace, skip it
                if (tokens[i] == ' ')
                    continue;

                // Current token is a number, push it to stack for numbers
                if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.'||(tokens[i]=='-'&&tokens[i-1]=='('))
                {
                    StringBuffer sbuf = new StringBuffer();
                    // There may be more than one digits in number
                    while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9'|| tokens[i] == '.' || (tokens[i]=='-'&&tokens[i-1]=='(') ||(tokens[i]=='E')))
                    {
                        sbuf.append(tokens[i++]);
                        if((tokens[i-1]=='E')&&(tokens[i]=='-')) {
                            sbuf.append(tokens[i++]);
                        }
                    }
                    values.push(Float.parseFloat(sbuf.toString()));
                    i--;
                }
                // Current token is an opening brace, push it to 'ops'
                else if (tokens[i] == '(')
                    ops.push(tokens[i]);

                    // Closing brace encountered, solve entire brace
                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.pop();
                }

                // Current token is an operator.
                else if (tokens[i] == '+' || tokens[i] == '-' ||
                        tokens[i] == '*' || tokens[i] == '/')
                {
                    // While top of 'ops' has same or greater precedence to current
                    // token, which is an operator. Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                    // Push current token to 'ops'.
                    ops.push(tokens[i]);
                }
            }

            // Entire expression has been parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            // Top of 'values' contains result, return it
            return values.pop();
        }

        // Returns true if 'op2' has higher or same precedence as 'op1',
        // otherwise returns false.
        public boolean hasPrecedence(char op1, char op2)
        {
            if (op2 == '(' || op2 == ')')
                return false;
            if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }

        // A utility method to apply an operator 'op' on operands 'a'
        // and 'b'. Return the result.
        public float applyOp(char op, float b, float a)
        {
            switch (op)
            {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0) {
                        Toast.makeText(getApplicationContext(), "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    }
                    return a / b;
            }
            return 0;
        }
    }

    private void Form_calculate_Expression(String ACTION) {

        char[] input = display.getText().toString().toCharArray();
        int len = display.getText().toString().length();
        if(len==30)
        {
            Toast.makeText(getApplicationContext(), "Expression Length Exceeded", Toast.LENGTH_SHORT).show();
            return;
        }
        if(brac_count<0)
        {
            Toast.makeText(getApplicationContext(), "Braces() added improperly", Toast.LENGTH_SHORT).show();
        }
        if(len<=0)
        {
            if(ACTION.charAt(0)=='(' || ACTION.charAt(0)=='.' || (ACTION.charAt(0)>='0' && ACTION.charAt(0)<='9'))
            {
                if(ACTION.charAt(0)=='.')
                {
                    display.setText(display.getText()+ "0");
                }
                if(ACTION.charAt(0)=='(')
                {
                    brac_count++;
                }
                display.setText(display.getText()+ ACTION);
                return;
            }
            Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }
        if(ACTION.charAt(0)=='(')
        {
            if(input[len-1]!='.')
            {
                if(input[len-1]=='+' || input[len-1]=='-' || input[len-1]=='*' || input[len-1]=='/' || input[len-1]=='%'|| input[len-1]=='(') {
                    display.setText(display.getText() + ACTION);
                    brac_count++;
                    return;
                }
                else
                {
                    display.setText(display.getText()+ "*" +ACTION);
                    brac_count++;
                    return;
                }
            }
        }
        if(ACTION.charAt(0)==')')
        {
            if(input[len-1]!='.' && input[len-1]!='+' && input[len-1]!='-' && input[len-1]!='*' && input[len-1]!='/' && input[len-1]!='%' && input[len-1]!='(')
            {
                if(brac_count-1<0)
                {
                    Toast.makeText(getApplicationContext(), "Braces() added improperly", Toast.LENGTH_SHORT).show();
                    return;
                }
                display.setText(display.getText()+ ACTION);
                brac_count--;
                return;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if(ACTION.charAt(0)=='+' || ACTION.charAt(0)=='-' || ACTION.charAt(0)=='*' || ACTION.charAt(0)=='/' || ACTION.charAt(0)=='%')
        {
            if(input[len-1]!='.' && input[len-1]!='(') {
                if (input[len - 1] == '+' || input[len - 1] == '-' || input[len - 1] == '*' || input[len - 1] == '/' || input[len - 1]=='%') {
                    input[len - 1] = ACTION.charAt(0);
                    display.setText(String.valueOf(input));
                    return;
                }

                else
                {
                    display.setText(display.getText()+ ACTION);
                    return;
                }
            }
            else if (input[len-1]=='('&& ACTION.charAt(0)=='-'){
                display.setText(display.getText().toString() + ACTION);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if(ACTION.charAt(0)>='0' && ACTION.charAt(0)<='9')
        {
            if(input[len-1]==')')
            {
                display.setText(display.getText()+ "*");
            }
            display.setText(display.getText()+ ACTION);
            return;
        }
        if(ACTION.charAt(0)=='.')
        {
            if(!(input[len-1]>='0' && input[len-1]<='9')) {
                display.setText(display.getText()+ "0");
            }
            display.setText(display.getText()+ ACTION);
        }
    }

    private void com(String action){
        int len = result.getText().toString().length();
        if (len<=0){
            return;
        }
        if (action == "+"){
            float val1 = Float.parseFloat(result.getText().toString());
            float val2 = Float.parseFloat(store.getText().toString());
            float sum = val1 + val2;
            store.setText(Float.toString(sum));
        }
        if (action=="-"){
            float val1 = Float.parseFloat(result.getText().toString());
            float val2 = Float.parseFloat(store.getText().toString());
            float diff = val2 - val1;
            store.setText(Float.toString(diff));
        }

    }

    private void btn_vibrate(int vibe_len){
        mvibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mvibrate.vibrate(vibe_len);
    }


}

