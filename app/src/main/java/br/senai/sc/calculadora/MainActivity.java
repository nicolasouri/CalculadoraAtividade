package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String primeiroNumero = "";
    private String segundoNumero = "";
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculadora :p");
        display = findViewById(R.id.textView);
    }

    public void onClickBotao1(View v){
        atualizarNumeroDigitado("1");
        atualizarDisplay("1");
    }

    public void onClickBotao2(View v){
        atualizarNumeroDigitado("2");
        atualizarDisplay("2");
    }

    public void onClickBotao3(View v){
        atualizarNumeroDigitado("3");
        atualizarDisplay("3");
    }

    public void onClickBotao4(View v){
        atualizarNumeroDigitado("4");
        atualizarDisplay("4");
    }

    public void onClickBotao5(View v){
        atualizarNumeroDigitado("5");
        atualizarDisplay("5");
    }

    public void onClickBotao6(View v){
        atualizarNumeroDigitado("6");
        atualizarDisplay("6");
    }

    public void onClickBotao7(View v){
        atualizarNumeroDigitado("7");
        atualizarDisplay("7");
    }

    public void onClickBotao8(View v){
        atualizarNumeroDigitado("8");
        atualizarDisplay("8");
    }

    public void onClickBotao9(View v){
        atualizarNumeroDigitado("9");
        atualizarDisplay("9");
    }

    public void onClickBotao0(View v){
        atualizarNumeroDigitado("0");
        atualizarDisplay("0");
    }

    public void onClickAdicao(View v){
        proibirRepetiçoesOperacao("+");
    }

    public void onClickDivisao(View v){
        proibirRepetiçoesOperacao("÷");
    }

    public void onClickMultiplicacao(View v){
        proibirRepetiçoesOperacao("*");
    }

    public void onClickSubracao(View v){
        proibirRepetiçoesOperacao("-");
    }

    public void onClickIgual(View v){
        if(!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()){
            int numero1 = Integer.parseInt(primeiroNumero);
            int numero2 = Integer.parseInt(segundoNumero);
            String resultado = "";

            if(operacao.equals("÷")){
                resultado = divisao(numero1, numero2);

            }else if(operacao.equals("+")){
                resultado = adicao(numero1, numero2);

            }else if(operacao.equals("-")){
                resultado = subtracao(numero1, numero2);

            }else if(operacao.equals("*")){
                resultado = multiplicacao(numero1, numero2);
            }

            display.setText(resultado);
            this.primeiroNumero = resultado;
            this.segundoNumero = "";
            this.operacao = "";

        }else{
            Toast.makeText(MainActivity.this, "Nenhuma operação foi solicitada", Toast.LENGTH_LONG).show();
        }

    }

    public void onClickBotaoClear(View v){
        this.primeiroNumero = "";
        this.segundoNumero = "";
        this.operacao = "";
        display.setText("");
    }

    public String multiplicacao(int numero1, int numero2) {
        int resultado = numero1 * numero2;
        return toString(resultado);
    }

    public String subtracao(int numero1, int numero2) {
        int resultado = numero1 - numero2;
        return toString(resultado);
    }

    public String adicao(int numero1, int numero2){
        int resultado = numero1 + numero2;
        return toString(resultado);
    }

    public String divisao(int numero1, int numero2){
        if(segundoNumero.equals("0")){
            Toast.makeText(MainActivity.this, "Não divida por zero", Toast.LENGTH_LONG).show();
            return "";
        }else{
           int resultado = numero1/numero2;
           return toString(resultado);
        }
    }

    public void proibirRepetiçoesOperacao(String operacao){
        if(this.operacao.isEmpty()){
            this.operacao = operacao;
            String displayText = display.getText() + " " + operacao;
            display.setText(displayText);
        }else{
            Toast.makeText(MainActivity.this, "Apenas uma operação por vez", Toast.LENGTH_LONG).show();
        }
    }

    public void atualizarNumeroDigitado(String nmr){
        if(operacao.isEmpty()){
            primeiroNumero = primeiroNumero + nmr;
        }else{
            segundoNumero = segundoNumero + nmr;
        }
    }

    public void atualizarDisplay (String text) {
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + " " + text;
        display.setText(textoDisplay);
    }

    public String toString(int resultado){
        return "" + resultado + "";
    }
}
