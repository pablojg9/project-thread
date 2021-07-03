package com.thread.projeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThreadTimeScreen extends JDialog {


    /** ATTRIBUTE JPANEL **/
    private JPanel jPanel = new JPanel(new GridBagLayout());

    /** ATTRIBUTE JLABEL **/
    private  JLabel descriptionTime = new JLabel("Time Thread 1");
    private  JLabel descriptionTimeDuo = new JLabel("Time Thread 2");

    /** ATTRIBUTE JTEXTFIELD **/
    private final JTextField showTime = new JTextField();
    private JTextField showTimeDuo = new JTextField();

    /** ATTRIBUTE BUTTON **/
    private JButton buttonStart = new JButton("Start");
    private JButton buttonStop = new JButton("Stop");

    public Runnable threadRun = new Runnable() {
        @Override
        public void run() {
            while (true) {
                showTime.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss")
                        .format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    public Runnable threadRunDuo = new Runnable() {
        @Override
        public void run() {
            while(true) {
                showTimeDuo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss")
                        .format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };

    private Thread threadDuoTime;
    private Thread threadOneTime;

    public ThreadTimeScreen(){ /** Executa o que tiver dentro no momento **/
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
        showTime.setEditable(false);
        jPanel.add(showTime, gridBagConstraints);

        /** SECOND "TABLE" OF COMPONENTS **/
        descriptionTimeDuo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(descriptionTimeDuo, gridBagConstraints);

        showTimeDuo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        showTimeDuo.setEditable(false);
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
                threadOneTime = new Thread(threadRun);
                threadDuoTime = new Thread(threadRunDuo);
                threadOneTime.start();
                threadDuoTime.start();

                buttonStart.setEnabled(false);
                buttonStop.setEnabled(true);
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadOneTime.stop();
                threadDuoTime.stop();

                buttonStop.setEnabled(false);
                buttonStart.setEnabled(true);
            }
        });



        add(jPanel, BorderLayout.WEST);
        setVisible(true); /** TORNA A TELA VISIVEL PARA O USUARIO **/
    }
}
