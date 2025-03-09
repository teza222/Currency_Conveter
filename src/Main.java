import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(300,200);
        frame.setTitle("Currency Converter");
        try {
            frame.setIconImage(ImageIO.read(new File("res/icon.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Input $:");
        inputLabel.setBounds(10,20,165,35);
        panel.add(inputLabel);

        JTextField inputTextField = new JTextField();
        inputTextField.setBounds(120,20,165,35);
        panel.add(inputTextField);

        JLabel currencyLabel = new JLabel("Currency Type:");
        currencyLabel.setBounds(10,50,120,35);
        panel.add(currencyLabel);

        String[] currencyCode = {"US","CAN","Euro"};

        JComboBox currencyTextField = new JComboBox(currencyCode);
        currencyTextField.setSelectedIndex(2);
        currencyTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        currencyTextField.setBounds(120,50,165,35);
        panel.add(currencyTextField);

        JLabel outputLabel = new JLabel("JMD Amount $:");
        outputLabel.setBounds(10,80,165,35);
        panel.add(outputLabel);

        JTextField outPutTextField = new JTextField();
        outPutTextField.setBounds(120,80,165,35);
        outPutTextField.setEditable(false);
        panel.add(outPutTextField);


        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(60, 120,100,35);
        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(convertBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(160, 120,100,35);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(clearBtn);




        frame.setVisible(true);


    }

}