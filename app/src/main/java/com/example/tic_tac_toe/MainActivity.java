package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView txt, txt1;
    String[][] field = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    String x = "X";
    String o = "O";
    int r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        txt = findViewById(R.id.textView1);
        txt1 = findViewById(R.id.textView0);
        txt1.setText("Сыграем?\nЧур, я ноликами!!!");
    //            firstCompMove();
    }

    public void firstCompMove() {// первый ход компьютера
        field[1][1] = o;
        btn1.setEnabled(false);
        reDraw(); //перерисовываем поле

    }

    //human's move
    public void k1(View v) {
        field[0][0] = x;
        btn1.setText(x);
        btn1.setEnabled(false);
        compPart();
    }

    public void k2(View v) {
        field[0][1] = x;
        btn2.setText(x);
        btn2.setEnabled(false);
        compPart();
    }

    public void k3(View v) {
        field[0][2] = x;
        btn3.setText(x);
        btn3.setEnabled(false);
        compPart();
    }

    public void k4(View v) {
        field[1][0] = x;
        btn4.setText(x);
        btn4.setEnabled(false);
        compPart();
    }

    public void k5(View v) {
        field[1][1] = x;
        btn5.setText(x);
        btn5.setEnabled(false);
        compPart();
    }

    public void k6(View v) {
        field[1][2] = x;
        btn6.setText(x);
        btn6.setEnabled(false);
        compPart();
    }

    public void k7(View v) {
        field[2][0] = x;
        btn7.setText(x);
        btn7.setEnabled(false);
        compPart();
    }

    public void k8(View v) {
        field[2][1] = x;
        btn8.setText(x);
        btn8.setEnabled(false);
        compPart();
    }

    public void k9(View v) {
        field[2][2] = x;
        btn9.setText(x);
        btn9.setEnabled(false);
        compPart();
    }

    ///computer's move
    public void compPart() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (winChecking(x))
        {
            txt.setText("НЕОЖИДАННО....\nЭТО ПОБЕДА!\nПОЗДРАВЛЯЮ!!!");
            stopGame();
        }
//        if (noFreeField()) {
//            txt.setText("Похоже, ничья???");
//            stopGame();
//        }

        compMove(); //ход компьютера
        reDraw(); //перерисовка поля

        if (winChecking(o))
        {
            txt.setText("Я выиграл!\nСНОВА :)\nКак всегда");
            stopGame();
        }
//        if (noFreeField()) {
//            txt.setText("Похоже, ничья???");
//            stopGame();
//        }
    }

    public void compMove() {
        randomField(); //генерируем случайную пару [0-2]
        //пока случайный ход в свободное поле
        while (!field[r1][r2].equals("")) randomField(); //повторяем, пока не найдём свободное поле
        field[r1][r2] = o; //ставим "О" в свободную ячейку
    }

    public void randomField() {
        r1 = ((int) (0 + Math.random() * 3));
        r2 = ((int) (0 + Math.random() * 3));
    }

    public void reDraw() {
        btn1.setText(field[0][0]);
        if (!field[0][0].equals("")) btn1.setEnabled(false);
        btn2.setText(field[0][1]);
        if (!field[0][1].equals("")) btn2.setEnabled(false);
        btn3.setText(field[0][2]);
        if (!field[0][2].equals("")) btn3.setEnabled(false);
        btn4.setText(field[1][0]);
        if (!field[1][0].equals("")) btn4.setEnabled(false);
        btn5.setText(field[1][1]);
        if (!field[1][1].equals("")) btn5.setEnabled(false);
        btn6.setText(field[1][2]);
        if (!field[1][2].equals("")) btn6.setEnabled(false);
        btn7.setText(field[2][0]);
        if (!field[2][0].equals("")) btn7.setEnabled(false);
        btn8.setText(field[2][1]);
        if (!field[2][1].equals("")) btn8.setEnabled(false);
        btn9.setText(field[2][2]);
        if (!field[2][2].equals("")) btn9.setEnabled(false);
    }

    public boolean winChecking(String s) {
        boolean isFinish = false;
        if (field[0][0].equals(s) && (field[0][1].equals(s) && field[0][2].equals(s)))
            isFinish = true; //верхняя строка
        if (field[1][0].equals(s) && (field[1][1].equals(s) && field[1][2].equals(s)))
            isFinish = true; //средняя строка
        if (field[2][0].equals(s) && (field[2][1].equals(s) && field[2][2].equals(s)))
            isFinish = true; //нижняя строка
        if (field[0][0].equals(s) && (field[1][0].equals(s) && field[2][0].equals(s)))
            isFinish = true; //левый столбец
        if (field[0][1].equals(s) && (field[1][1].equals(s) && field[2][1].equals(s)))
            isFinish = true; //средний столбец
        if (field[0][2].equals(s) && (field[1][2].equals(s) && field[2][2].equals(s)))
            isFinish = true; //правый столбец
        if (field[0][0].equals(s) && (field[1][1].equals(s) && field[2][2].equals(s)))
            isFinish = true; //главная диагональ
        if (field[0][2].equals(s) && (field[1][1].equals(s) && field[2][0].equals(s)))
        {isFinish = true;} //обратная диагональ

            return isFinish;
    }
    public void stopGame(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        txt1.setText("Game Over");
//        txt1.setTextColor(ContextCompat.getColor(this, R.color.white));
//        txt.setTextColor(ContextCompat.getColor(this, R.color.white));
    }
//    public boolean noFreeField(){
//        boolean isFreeField = false;
//        if (!field[0][0].equals("")&&!field[0][1].equals("")&&!field[0][2].equals("")&&!field[1][0].equals("")&&!field[1][1].equals("")&&!field[1][2].equals("")&&!field[2][0].equals("")&&!field[2][1].equals("")&&!field[2][2].equals(""))
//            isFreeField = true; //все поля заняты
//        return isFreeField;
//    }
}