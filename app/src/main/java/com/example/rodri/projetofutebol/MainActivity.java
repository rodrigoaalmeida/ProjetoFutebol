package com.example.rodri.projetofutebol;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //    instanciação e inicialização das variaveis do visor.
    int pontucaoTimeA = 0;
    int pontucaoTimeB = 0;
    int cartaoVermelhoTimeA = 0;
    int cartaoVermelhoTimeB = 0;
    int cartaoAmareloTimeA = 0;
    int cartaoAmareloTimeB = 0;
    int jogadoresTimeA = 11;
    int jogadoresTimeB = 11;
    int substituicoesTimeA = 3;
    int substituicoesTimeB = 3;
    int jogadoresExpulsosTimeA = 0;
    int jogadoresExpulsosTimeB = 0;
    //    instanciação e inicialização das variaveis de contagem para regra de expulsão.
    int contCartaoAmareloTimeA = 0;
    int contSubstituicaoTimeA = 0;
    int contCartaoAmareloTimeB = 0;
    int contSubstituicaoTimeB = 0;
    //    instanciação das variaveis relacionadas a tela que seram utizadas mais de uma vez.
    TextView empateView;
    TextView vencedorTimeAView;
    TextView vencedorTimeBView;
    Button buttonGolTimeA;
    Button buttonVermelhoTimeA;
    Button buttonAmareloTimeA;
    Button buttonSubstituicaoTimeA;
    Button buttonGolTimeB;
    Button buttonVermelhoTimeB;
    Button buttonAmareloTimeB;
    Button buttonSubstituicaoTimeB;
    Button buttonFimDeJogoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Fonte do codigo de mudança de cor da ActionBar: https://pt.stackoverflow.com/questions/45263/mudando-cor-da-actionbar-no-style
         * */
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EF6C00")));
//        mostrando as variaveis na tela com seus valores padrões setados acima.
        displayPontucaoTimeA(pontucaoTimeA);
        displayPontucaoTimeB(pontucaoTimeB);
        displayCartaoVermelhoTimeA(cartaoVermelhoTimeA);
        displayCartaoVermelhoTimeB(cartaoVermelhoTimeB);
        displayCartaoAmareloTimeA(cartaoAmareloTimeA, jogadoresTimeA, jogadoresExpulsosTimeA);
        displayCartaoAmareloTimeB(cartaoAmareloTimeB, jogadoresTimeB, jogadoresExpulsosTimeB);
        displaySubstituicoesTimeA(substituicoesTimeA);
        displaySubstituicoesTimeB(substituicoesTimeB);
//        inicialização das variaveis de tela com valores padrões.
        atribuirComponentesAsVariaveis();
        vencedorTimeAView.setVisibility(View.INVISIBLE);
        vencedorTimeBView.setVisibility(View.INVISIBLE);
        empateView.setVisibility(View.INVISIBLE);
    }

    private void atribuirComponentesAsVariaveis() {
        empateView = (TextView) findViewById(R.id.text_view_empate);
        vencedorTimeAView = (TextView) findViewById(R.id.text_view_vencedor_a);
        vencedorTimeBView = (TextView) findViewById(R.id.text_view_vencedor_b);
        buttonGolTimeA = findViewById(R.id.button_gol_time_a);
        buttonVermelhoTimeA = findViewById(R.id.button_cartao_red_time_a);
        buttonAmareloTimeA = findViewById(R.id.button_cartao_yellow_time_a);
        buttonSubstituicaoTimeA = findViewById(R.id.button_substituicao_time_a);
        buttonGolTimeB = findViewById(R.id.button_gol_time_b);
        buttonVermelhoTimeB = findViewById(R.id.button_cartao_red_time_b);
        buttonAmareloTimeB = findViewById(R.id.button_cartao_yellow_time_b);
        buttonSubstituicaoTimeB = findViewById(R.id.button_substituicao_time_b);
        buttonFimDeJogoView = findViewById(R.id.button_fim_jogo);
    }

    //    codigo do botão de reset
    public void buttonReset(View view) {
        pontucaoTimeA = 0;
        pontucaoTimeB = 0;
        cartaoVermelhoTimeA = 0;
        cartaoVermelhoTimeB = 0;
        cartaoAmareloTimeA = 0;
        cartaoAmareloTimeB = 0;
        jogadoresExpulsosTimeA = 0;
        jogadoresExpulsosTimeB = 0;
        jogadoresTimeA = 11;
        jogadoresTimeB = 11;
        substituicoesTimeA = 3;
        substituicoesTimeB = 3;
        buttonGolTimeA.setEnabled(true);
        buttonVermelhoTimeA.setEnabled(true);
        buttonAmareloTimeA.setEnabled(true);
        buttonSubstituicaoTimeA.setEnabled(true);
        buttonGolTimeA.setVisibility(View.VISIBLE);
        buttonVermelhoTimeA.setVisibility(View.VISIBLE);
        buttonAmareloTimeA.setVisibility(View.VISIBLE);
        buttonSubstituicaoTimeA.setVisibility(View.VISIBLE);
        buttonGolTimeB.setEnabled(true);
        buttonVermelhoTimeB.setEnabled(true);
        buttonAmareloTimeB.setEnabled(true);
        buttonSubstituicaoTimeB.setEnabled(true);
        buttonGolTimeB.setVisibility(View.VISIBLE);
        buttonVermelhoTimeB.setVisibility(View.VISIBLE);
        buttonAmareloTimeB.setVisibility(View.VISIBLE);
        buttonSubstituicaoTimeB.setVisibility(View.VISIBLE);
        displayPontucaoTimeA(pontucaoTimeA);
        displayPontucaoTimeB(pontucaoTimeB);
        displayCartaoVermelhoTimeA(cartaoVermelhoTimeA);
        displayCartaoAmareloTimeA(cartaoAmareloTimeA, jogadoresTimeA, jogadoresExpulsosTimeA);
        displayCartaoVermelhoTimeB(cartaoVermelhoTimeB);
        displayCartaoAmareloTimeB(cartaoAmareloTimeB, jogadoresTimeB, jogadoresExpulsosTimeB);
        displaySubstituicoesTimeA(substituicoesTimeA);
        displaySubstituicoesTimeB(substituicoesTimeB);
        vencedorTimeAView.setVisibility(View.INVISIBLE);
        vencedorTimeBView.setVisibility(View.INVISIBLE);
        empateView.setVisibility(View.INVISIBLE);
        buttonFimDeJogoView.setEnabled(true);
        buttonFimDeJogoView.setVisibility(View.VISIBLE);
    }

    //    codigo do botão de fim de jogo
    public void buttonFimDeJogo(View view) {
        if (pontucaoTimeA > pontucaoTimeB) {
            vencedorTimeAView.setVisibility(View.VISIBLE);
            situacaoButtonJogoEncerrado();
        } else if (pontucaoTimeB > pontucaoTimeA) {
            vencedorTimeBView.setVisibility(View.VISIBLE);
            situacaoButtonJogoEncerrado();
        } else {
            empateView.setVisibility(View.VISIBLE);
            situacaoButtonJogoEncerrado();
        }
    }

    //    codigo usado intenamente quando a partida é encerrada por pelo botão ou limite de expulsos.
    private void situacaoButtonJogoEncerrado() {
        buttonFimDeJogoView.setEnabled(false);
        buttonFimDeJogoView.setVisibility(View.INVISIBLE);
        buttonVermelhoTimeA.setEnabled(false);
        buttonAmareloTimeA.setEnabled(false);
        buttonGolTimeA.setEnabled(false);
        buttonGolTimeA.setVisibility(View.INVISIBLE);
        buttonVermelhoTimeA.setVisibility(View.INVISIBLE);
        buttonAmareloTimeA.setVisibility(View.INVISIBLE);
        buttonSubstituicaoTimeA.setEnabled(false);
        buttonSubstituicaoTimeA.setVisibility(View.INVISIBLE);
        buttonVermelhoTimeB.setEnabled(false);
        buttonAmareloTimeB.setEnabled(false);
        buttonGolTimeB.setEnabled(false);
        buttonVermelhoTimeB.setVisibility(View.INVISIBLE);
        buttonAmareloTimeB.setVisibility(View.INVISIBLE);
        buttonGolTimeB.setVisibility(View.INVISIBLE);
        buttonSubstituicaoTimeB.setEnabled(false);
        buttonSubstituicaoTimeB.setVisibility(View.INVISIBLE);
    }

    //    codigo para adicionar pontos ao time A.
    public void addPontosTimeA(View view) {
        pontucaoTimeA = pontucaoTimeA + 1;
        displayPontucaoTimeA(pontucaoTimeA);
    }

    //    codigo para adicionar cartão vermelho ao time A.
    public void addCartaoVermelhoTimeA(View view) {
        cartaoVermelhoTimeA = cartaoVermelhoTimeA + 1;
        jogadoresTimeA = jogadoresTimeA - 1;
        jogadoresExpulsosTimeA = jogadoresExpulsosTimeA + 1;
        jogadoresCampoTimeA(jogadoresTimeA);
        displayCartaoVermelhoTimeA(cartaoVermelhoTimeA, jogadoresTimeA, jogadoresExpulsosTimeA);
    }

    //    codigo para adicionar cartão amarelo ao time A.
    public void addCartaoAmareloTimeA(View view) {
        cartaoAmareloTimeA = cartaoAmareloTimeA + 1;
        contCartaoAmareloTimeA = contCartaoAmareloTimeA + 1;
        contSubstituicaoTimeA = 0;
        if (cartaoAmareloTimeA > 1) {
            if (contCartaoAmareloTimeA % 2 == 0 && contSubstituicaoTimeA == 0) {
                jogadoresTimeA = jogadoresTimeA - 1;
                jogadoresExpulsosTimeA = jogadoresExpulsosTimeA + 1;
            }
        }
        jogadoresCampoTimeA(jogadoresTimeA);
        displayCartaoAmareloTimeA(cartaoAmareloTimeA, jogadoresTimeA, jogadoresExpulsosTimeA);
    }

    //    codigo usado no botão de substituição do time A.
    public void substituicaoTimeA(View view) {
        substituicoesTimeA = substituicoesTimeA - 1;
        contCartaoAmareloTimeA = 0;
        contSubstituicaoTimeA = 1;
        displaySubstituicoesTimeA(substituicoesTimeA);
        if (substituicoesTimeA < 1) {
            buttonSubstituicaoTimeA.setEnabled(false);
            buttonSubstituicaoTimeA.setVisibility(View.INVISIBLE);
        }
    }

    //    codigo usado internamente para regra de fim de jogo por jogadores minimos em campo no time A.
    private void jogadoresCampoTimeA(int jogadores) {
        if (jogadores == 6) {
            situacaoButtonJogoEncerrado();
            vencedorTimeBView.setVisibility(View.VISIBLE);
        }
    }

    //    mostra a pontuação do time A.
    public void displayPontucaoTimeA(int pontos) {
        TextView pontuacaoTimeAView = (TextView) findViewById(R.id.pontuacao_time_a);
        pontuacaoTimeAView.setText(String.valueOf(pontos));
    }

    //    codigo para atualizar os cartões vermelhos, jogadores em campo e jogadores expulsos do time A.
    public void displayCartaoVermelhoTimeA(int cartaoVermelho, int jogadoresCampo, int jogadoresExpulsos) {
        TextView cartaoVermelhoTimeAView = (TextView) findViewById(R.id.cartao_vermelho_time_a);
        TextView jogadoresTimeAView = (TextView) findViewById(R.id.jogadores_campo_time_a);
        TextView jogadoresExpulsosTimeAView = (TextView) findViewById(R.id.jogadores_expulsos_time_a);
        jogadoresTimeAView.setText(String.valueOf(jogadoresCampo));
        jogadoresExpulsosTimeAView.setText(String.valueOf(jogadoresExpulsos));
        cartaoVermelhoTimeAView.setText(String.valueOf(cartaoVermelho));
    }

    //    codigo para mostrar os cartões vermelhos do time A.
    public void displayCartaoVermelhoTimeA(int cartaoVermelho) {
        TextView cartaoVermelhoTimeAView = (TextView) findViewById(R.id.cartao_vermelho_time_a);
        cartaoVermelhoTimeAView.setText(String.valueOf(cartaoVermelho));
    }

    //    codigo para mostrar e atualizar os cartões amarelos, jogadores em campo e jogadores expulsos do time A.
    public void displayCartaoAmareloTimeA(int cartaoAmarelo, int jogadoresCampo, int jogadoresExpulsos) {
        TextView cartaoAmareloTimeAView = (TextView) findViewById(R.id.cartao_amarelo_time_a);
        TextView jogadoresTimeAView = (TextView) findViewById(R.id.jogadores_campo_time_a);
        TextView jogadoresExpulsosTimeAView = (TextView) findViewById(R.id.jogadores_expulsos_time_a);
        jogadoresTimeAView.setText(String.valueOf(jogadoresCampo));
        jogadoresExpulsosTimeAView.setText(String.valueOf(jogadoresExpulsos));
        cartaoAmareloTimeAView.setText(String.valueOf(cartaoAmarelo));
    }

    //    codigo para mostrar o numero de substituições disponiveis para o time A.
    private void displaySubstituicoesTimeA(int substituicao) {
        TextView substituicaoTimeAView = (TextView) findViewById(R.id.substituicoes_time_a);
        substituicaoTimeAView.setText(String.valueOf(substituicao));
    }

    /**
     * Codigo para as funcinalidades do time B
     */
//    codigo para adicionar pontos ao time B.
    public void addPontosTimeB(View view) {
        pontucaoTimeB = pontucaoTimeB + 1;
        displayPontucaoTimeB(pontucaoTimeB);
    }

    //    codigo para adicionar cartão vermelho ao time B.
    public void addCartaoVermelhoTimeB(View view) {
        cartaoVermelhoTimeB = cartaoVermelhoTimeB + 1;
        jogadoresTimeB = jogadoresTimeB - 1;
        jogadoresExpulsosTimeB = jogadoresExpulsosTimeB + 1;
        jogadoresCampoTimeB(jogadoresTimeB);
        displayCartaoVermelhoTimeB(cartaoVermelhoTimeB, jogadoresTimeB, jogadoresExpulsosTimeB);
    }

    //    codigo para adicionar cartão amarelo ao time B.
    public void addCartaoAmareloTimeB(View view) {
        cartaoAmareloTimeB = cartaoAmareloTimeB + 1;
        contCartaoAmareloTimeB = contCartaoAmareloTimeB + 1;
        contSubstituicaoTimeB = 0;
        if (cartaoAmareloTimeB > 1) {
            if (contCartaoAmareloTimeB % 2 == 0 && contSubstituicaoTimeB == 0) {
                jogadoresTimeB = jogadoresTimeB - 1;
                jogadoresExpulsosTimeB = jogadoresExpulsosTimeB + 1;
            }
        }
        jogadoresCampoTimeB(jogadoresTimeB);
        displayCartaoAmareloTimeB(cartaoAmareloTimeB, jogadoresTimeB, jogadoresExpulsosTimeB);
    }

    //    codigo usado no botão de substituição do time B.
    public void substituicaoTimeB(View view) {
        substituicoesTimeB = substituicoesTimeB - 1;
        contCartaoAmareloTimeB = 0;
        contSubstituicaoTimeB = 1;
        displaySubstituicoesTimeB(substituicoesTimeB);
        if (substituicoesTimeB < 1) {
            buttonSubstituicaoTimeB.setEnabled(false);
            buttonSubstituicaoTimeB.setVisibility(View.INVISIBLE);
        }
    }

    //    codigo usado internamente para regra de fim de jogo por jogadores minimos em campo no time B.
    private void jogadoresCampoTimeB(int jogadores) {
        if (jogadores == 6) {
            situacaoButtonJogoEncerrado();
            vencedorTimeAView.setVisibility(View.VISIBLE);
        }
    }

    //    mostra a pontuação do time B.
    public void displayPontucaoTimeB(int pontos) {
        TextView pontuacaoTimeBView = (TextView) findViewById(R.id.pontuacao_time_b);
        pontuacaoTimeBView.setText(String.valueOf(pontos));
    }

    //    codigo para atualizar os cartões vermelhos, jogadores em campo e jogadores expulsos do time B.
    public void displayCartaoVermelhoTimeB(int cartaoVermelho, int jogadoresCampo, int jogadoresExpulsos) {
        TextView cartaoVermelhoTimeBView = (TextView) findViewById(R.id.cartao_vermelho_time_b);
        TextView jogadoresTimeBView = (TextView) findViewById(R.id.jogadores_campo_time_b);
        TextView jogadoresExpulsosTimeBView = (TextView) findViewById(R.id.jogadores_expulsos_time_b);
        jogadoresTimeBView.setText(String.valueOf(jogadoresCampo));
        jogadoresExpulsosTimeBView.setText(String.valueOf(jogadoresExpulsos));
        cartaoVermelhoTimeBView.setText(String.valueOf(cartaoVermelho));
    }

    //    codigo para mostrar os cartões vermelhos do time B.
    public void displayCartaoVermelhoTimeB(int cartaoVermelho) {
        TextView cartaoVermelhoTimeBView = (TextView) findViewById(R.id.cartao_vermelho_time_b);
        cartaoVermelhoTimeBView.setText(String.valueOf(cartaoVermelho));
    }

    //    codigo para mostrar e atualizar os cartões amarelos, jogadores em campo e jogadores expulsos do time B.
    public void displayCartaoAmareloTimeB(int cartaoAmarelo, int jogadoresCampo, int jogadoresExpulsos) {
        TextView cartaoAmareloTimeBView = (TextView) findViewById(R.id.cartao_amarelo_time_b);
        TextView jogadoresTimeBView = (TextView) findViewById(R.id.jogadores_campo_time_b);
        TextView jogadoresExpulsosTimeBView = (TextView) findViewById(R.id.jogadores_expulsos_time_b);
        jogadoresTimeBView.setText(String.valueOf(jogadoresCampo));
        jogadoresExpulsosTimeBView.setText(String.valueOf(jogadoresExpulsos));
        cartaoAmareloTimeBView.setText(String.valueOf(cartaoAmarelo));
    }

    //    codigo para mostrar o numero de substituições disponiveis para o time B.
    private void displaySubstituicoesTimeB(int substituicao) {
        TextView substituicaoTimeBView = (TextView) findViewById(R.id.substituicoes_time_b);
        substituicaoTimeBView.setText(String.valueOf(substituicao));
    }
}
