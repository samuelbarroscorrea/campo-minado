package br.com.coder.cm.visao;

import br.com.coder.cm.modelo.Campo;
import br.com.coder.cm.modelo.CampoEvento;
import br.com.coder.cm.modelo.CampoObservador;
import br.com.coder.cm.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CampoBotao extends JButton implements CampoObservador, MouseListener {

    private final Color BG_PADRAO = new Color(184, 184, 184);
    private final Color BG_MARCADO = new Color(8, 179, 247);
    private final Color BG_EXPLOSAO = new Color(189, 66, 68);
    private final Color TEXTO_VERDE = new Color(0, 100, 0);

    private Campo campo;
    private Tabuleiro tabuleiro;

    public CampoBotao(Campo campo, Tabuleiro tabuleiro) {
        this.campo = campo;
        this.tabuleiro = tabuleiro;
        setBorder(BorderFactory.createBevelBorder(0));
        setOpaque(true);
        setBackground(BG_PADRAO);

        addMouseListener(this);
        campo.registrarObservador(this);
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento) {
            case ABRIR:
                aplicarEstiloAbrir();
                break;
            case MARCAR:
                aplicarEstiloMarcar();
                break;
            case EXPLODIR:
                aplicarEstiloExplodir();
                break;
            case ATUALIZAR:
                aplicarEstiloAbrir();
                break;
            default:
                aplicarEstiloPadrao();
        }
    }

    private void aplicarEstiloPadrao() {
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }

    private void aplicarEstiloExplodir() {
        setBackground(BG_EXPLOSAO);
        setForeground(Color.white);
        setText("X");
    }

    private void aplicarEstiloMarcar() {
        setBackground(BG_MARCADO);
        setForeground(Color.BLACK);
        setText("M");

    }

    private void aplicarEstiloAbrir() {

        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if (campo.isMinado()) {
            setBackground(BG_EXPLOSAO);
            return;
        }

        setBackground(BG_PADRAO);

        switch (campo.minasNaVizinhanca()) {
            case 1:
                setForeground(TEXTO_VERDE);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.YELLOW);
                break;
            case 4:
            case 5:
            case 6:
                setForeground(Color.RED);
                break;
            default:
                setForeground(Color.PINK);


        }

        String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
        setText(valor);
    }

    //Eventos de mouse

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            tabuleiro.abrir(campo.getLinha(), campo.getColuna());
        } else {
            tabuleiro.alternarMarcacao(campo.getLinha(), campo.getColuna());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
