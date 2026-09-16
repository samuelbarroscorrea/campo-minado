package br.com.coder.cm.visao;

import br.com.coder.cm.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);

        JLabel contador = new JLabel("Movimentos: 0");

        setLayout(new BorderLayout());

        add(contador, BorderLayout.NORTH);
        add(new PainelTabuleiro(tabuleiro, contador), BorderLayout.CENTER);

        setTitle("Campo Minado");
        setSize(680, 438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new TelaPrincipal();
    }
}
