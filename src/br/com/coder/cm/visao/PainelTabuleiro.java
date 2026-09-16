package br.com.coder.cm.visao;

import br.com.coder.cm.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro, JLabel contador) {
        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCada(c -> add(new CampoBotao(c, tabuleiro)));

        tabuleiro.registrarObservador(resultado -> {
            SwingUtilities.invokeLater(() -> {
                if (tabuleiro.objetiboAlcancado()) {
                    JOptionPane.showMessageDialog(this, "Ganhou !!");
                } else {
                    JOptionPane.showMessageDialog(this, "PERDEU");
                }

                tabuleiro.reiniciar();
                contador.setText("Movimentos: 0");
            });
        });

        tabuleiro.registrarObservadorMovimento(movimentos -> {
            SwingUtilities.invokeLater(() -> {
                contador.setText("Movimentos: " + movimentos);
            });
        });
    }
}
