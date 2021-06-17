package com.thread.projeto;

import javax.swing.JDialog;
import java.awt.*;

public class ThreadTimeScreen extends JDialog {
    public ThreadTimeScreen(){ /** Executa o que tiver dentro no momento **/
        setTitle("Screen Thread");
        setSize(new Dimension(550, 550));
        setLocationRelativeTo(null);
        setResizable(false);



        setVisible(true); /** TORNA A TELA VISIVEL PARA O USUARIO **/
    }
}
