package com.thread.projeto;

import javax.swing.*;
import java.awt.*;

public class ThreadTimeScreen extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout());
    private JLabel descriptionTime = new JLabel("Time Thread 1");
    private JTextField showTime = new JTextField();

    private JLabel descriptionTimeDuo = new JLabel("Time Thread 1");
    private JTextField showTimeDuo = new JTextField();

    public ThreadTimeScreen(){ /** Executa o que tiver dentro no momento **/
        setTitle("Screen Thread");
        setSize(new Dimension(550, 550));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        /** PRIMEIRA "TABELA" DE COMPONENTES **/
        descriptionTime.setPreferredSize(new Dimension(200, 25));
        jPanel.add(descriptionTime, gridBagConstraints);

        showTime.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(showTime, gridBagConstraints);

        /** SEGUNDA "TABELA" DE COMPONENTES **/
        descriptionTimeDuo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(descriptionTimeDuo, gridBagConstraints);

        showTimeDuo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(showTimeDuo, gridBagConstraints);



        add(jPanel, BorderLayout.WEST);
        setVisible(true); /** TORNA A TELA VISIVEL PARA O USUARIO **/
    }
}
