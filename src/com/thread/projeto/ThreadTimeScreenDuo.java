package com.thread.projeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadTimeScreenDuo extends JDialog{

    /** ATTRIBUTE JPANEL **/
    private JPanel jPanel = new JPanel(new GridBagLayout());

    /** ATTRIBUTE JLABEL **/
    private  JLabel descriptionTime = new JLabel("Nome: ");
    private  JLabel descriptionTimeDuo = new JLabel("email: ");

    /** ATTRIBUTE JTEXTFIELD **/
    private final JTextField showTime = new JTextField();
    private JTextField showTimeDuo = new JTextField();

    /** ATTRIBUTE BUTTON **/
    private JButton buttonStart = new JButton("Add list");
    private JButton buttonStop = new JButton("Remove");

    private ImplementationQueueThread instanceRow = new ImplementationQueueThread();

    public ThreadTimeScreenDuo(){ /** Executa o que tiver dentro no momento **/
        setTitle("Screen Thread");
        setSize(new Dimension(250, 250));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5,15,5,5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        /** FIRST "TABLE" OF COMPONENTS **/
        descriptionTime.setPreferredSize(new Dimension(200, 25));
        jPanel.add(descriptionTime, gridBagConstraints);

        showTime.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(showTime, gridBagConstraints);

        /** SECOND "TABLE" OF COMPONENTS **/
        descriptionTimeDuo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(descriptionTimeDuo, gridBagConstraints);

        showTimeDuo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(showTimeDuo, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        buttonStart.setPreferredSize(new Dimension(90,25));
        gridBagConstraints.gridy++;
        jPanel.add(buttonStart, gridBagConstraints);

        buttonStop.setPreferredSize(new Dimension(90, 25));
        gridBagConstraints.gridx++;
        jPanel.add(buttonStop, gridBagConstraints);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RowThreadObject rowThread = new RowThreadObject();

                rowThread.setName(showTime.getText());
                rowThread.setEmail(showTimeDuo.getText());

                instanceRow.add(rowThread);

            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RowThreadObject rowThreadDuo = new RowThreadObject();
                rowThreadDuo.getName();
                rowThreadDuo.getEmail();

                instanceRow.remove(rowThreadDuo);
            }
        });


        instanceRow.start();
        add(jPanel, BorderLayout.WEST);
        setVisible(true); /** TORNA A TELA VISIVEL PARA O USUARIO **/
    }

}
