package com.example.rodri.projetofutebol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pontucaoTimeA = 0;
    int pontucaoTimeB = 0;
    int cartaoVermelhoTimeA = 0;
    int cartaoVermelhoTimeB = 0;
    int cartaoAmareloTimeA = 0;
    int cartaoAmareloTimeB = 0;
    int jogadoresTimeA;
    int jogadoresTimeB;
    int substituicoesTimeA;
    int substituicoesTimeB;
    int jogadoresExpulsosTimeA = 0;
    int jogadoresExpulsosTimeB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jogadoresTimeA = 11;
        jogadoresTimeB = 11;
        substituicoesTimeA = 3;
        substituicoesTimeB = 3;
    }

    public void buttonReset(View view){
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
        displayPontucaoTimeA(pontucaoTimeA);
        displayPontucaoTimeB(pontucaoTimeB);
        displayCartaoVermelhoTimeA(cartaoVermelhoTimeA);
        displayCartaoAmareloTimeA(cartaoAmareloTimeA, jogadoresTimeA, jogadoresExpulsosTimeA);
        displayCartaoVermelhoTimeB(cartaoVermelhoTimeB);
        displayCartaoAmareloTimeB(cartaoAmareloTimeB);
        displaySubstituicoesTimeA(substituicoesTimeA);
    }

    public void addPontosTimeA(View view){
        pontucaoTimeA = pontucaoTimeA + 1;
        displayPontucaoTimeA(pontucaoTimeA);
    }

    public void addCartaoVermelhoTimeA(View view){
        cartaoVermelhoTimeA = cartaoVermelhoTimeA + 1;
        jogadoresTimeA = jogadoresTimeA - 1;
        jogadoresExpulsosTimeA = jogadoresExpulsosTimeA + 1;
        jogadoresCampo(jogadoresTimeA);
        displayCartaoVermelhoTimeA(cartaoVermelhoTimeA, jogadoresTimeA, jogadoresExpulsosTimeA);
    }

    public void addCartaoAmareloTimeA(View view){
        cartaoAmareloTimeA = cartaoAmareloTimeA + 1;
        if (cartaoAmareloTimeA > 1){
            if (cartaoAmareloTimeA % 2 == 0 && substituicoesTimeA == 3){
                jogadoresTimeA = jogadoresTimeA - 1;
                jogadoresExpulsosTimeA = jogadoresExpulsosTimeA + 1;
            }else if(cartaoAmareloTimeA % 4 != 0){
                if (substituicoesTimeA == 2){
                    jogadoresTimeA = jogadoresTimeA - 1;
                    jogadoresExpulsosTimeA = jogadoresExpulsosTimeA + 1;
                }else if(substituicoesTimeA == 1){
                    jogadoresTimeA = jogadoresTimeA - 1;
                    jogadoresExpulsosTimeA = jogadoresExpulsosTimeA + 1;
                }
            }else if ((cartaoAmareloTimeA - 3) % 2 == 0 && substituicoesTimeA == 0){
                jogadoresTimeA = jogadoresTimeA - 1;
                jogadoresExpulsosTimeA = jogadoresExpulsosTimeA + 1;
            }
        }
        jogadoresCampo(jogadoresTimeA);
        displayCartaoAmareloTimeA(cartaoAmareloTimeA, jogadoresTimeA, jogadoresExpulsosTimeA);
    }

    public void substituicaoTimeA(View view){
        substituicoesTimeA = substituicoesTimeA - 1;
        displaySubstituicoesTimeA(substituicoesTimeA);
    }

    private void jogadoresCampo(int jogadores){
        if (jogadores == 6){
            Button buttonVermelhoTimeA = findViewById(R.id.button_cartao_red_time_a);
            Button buttonAmareloTimeA = findViewById(R.id.button_cartao_yellow_time_a);
            buttonVermelhoTimeA.setEnabled(false);
            buttonAmareloTimeA.setEnabled(false);
            buttonVermelhoTimeA.setBackground(getDrawable(R.drawable.button_invisivel));
            buttonAmareloTimeA.setBackground(getDrawable(R.drawable.button_invisivel));
        }
    }

    public void displayPontucaoTimeA(int pontos){
        TextView pontuacaoTimeAView = (TextView) findViewById(R.id.pontuacao_time_a);
        pontuacaoTimeAView.setText(String.valueOf(pontos));
    }

    public void displayCartaoVermelhoTimeA(int cartaoVermelho, int jogadoresCampo, int jogadoresExpulsos){
        TextView cartaoVermelhoTimeAView = (TextView) findViewById(R.id.cartao_vermelho_time_a);
        TextView jogadoresTimeAView = (TextView) findViewById(R.id.jogadores_campo_time_a);
        TextView jogadoresExpulsosTimeAView = (TextView) findViewById(R.id.jogadores_expulsos_time_a);
        jogadoresTimeAView.setText(String.valueOf(jogadoresCampo));
        jogadoresExpulsosTimeAView.setText(String.valueOf(jogadoresExpulsos));
        cartaoVermelhoTimeAView.setText(String.valueOf(cartaoVermelho));
    }

    public void displayCartaoVermelhoTimeA(int cartaoVermelho){
        TextView cartaoVermelhoTimeAView = (TextView) findViewById(R.id.cartao_vermelho_time_a);
        cartaoVermelhoTimeAView.setText(String.valueOf(cartaoVermelho));
    }

    public void displayCartaoAmareloTimeA(int cartaoAmarelo, int jogadoresCampo, int jogadoresExpulsos){
        TextView cartaoAmareloTimeAView = (TextView) findViewById(R.id.cartao_amarelo_time_a);
        TextView jogadoresTimeAView = (TextView) findViewById(R.id.jogadores_campo_time_a);
        TextView jogadoresExpulsosTimeAView = (TextView) findViewById(R.id.jogadores_expulsos_time_a);
        jogadoresTimeAView.setText(String.valueOf(jogadoresCampo));
        jogadoresExpulsosTimeAView.setText(String.valueOf(jogadoresExpulsos));
        cartaoAmareloTimeAView.setText(String.valueOf(cartaoAmarelo));
    }

    private void displaySubstituicoesTimeA(int substituicao){
        TextView substituicaoTimeAView = (TextView) findViewById(R.id.substituicoes_time_a);
        substituicaoTimeAView.setText(String.valueOf(substituicao));
    }

    /**
     * time b
     * */

    public void addPontosTimeB(View view){
        pontucaoTimeB = pontucaoTimeB + 1;
        displayPontucaoTimeB(pontucaoTimeB);
    }

    public void addCartaoVermelhoTimeB(View view){
        cartaoVermelhoTimeB = cartaoVermelhoTimeB + 1;
        displayCartaoVermelhoTimeB(cartaoVermelhoTimeB);
    }

    public void addCartaoAmareloTimeB(View view){
        cartaoAmareloTimeB = cartaoAmareloTimeB + 1;
        displayCartaoAmareloTimeB(cartaoAmareloTimeB);
    }

    public void displayPontucaoTimeB(int pontos){
        TextView pontuacaoTimeBView = (TextView) findViewById(R.id.pontuacao_time_b);
        pontuacaoTimeBView.setText(String.valueOf(pontos));
    }

    public void displayCartaoVermelhoTimeB(int cartaoVermelho){
        TextView cartaoVermelhoTimeBView = (TextView) findViewById(R.id.cartao_vermelho_time_b);
        cartaoVermelhoTimeBView.setText(String.valueOf(cartaoVermelho));
    }

    public void displayCartaoAmareloTimeB(int cartaoAmarelo){
        TextView cartaoAmareloTimeBView = (TextView) findViewById(R.id.cartao_amarelo_time_b);
        cartaoAmareloTimeBView.setText(String.valueOf(cartaoAmarelo));
    }
}
