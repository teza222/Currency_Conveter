import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Console;
import java.io.File;
import java.io.IOException;


/**Group Members
 * Everton Richards
 * Asheka Quallo
 * Adrian Williams
 * Andre Mcmillon
 */


public class Main {
    public static void main(String[] args) {

        double usdValue = 129.02;
        double canValue = 97.50;
        double euroValue = 164.33;
        final double[] convertedAmount = {0};

        final String[] initCurrency = {"US"};

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

        JComboBox currencyBox = new JComboBox(currencyCode);
        currencyBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    initCurrency[0] = (String)currencyBox.getSelectedItem();

                    System.out.print(initCurrency[0]);

                }
            }
        });
        currencyBox.setBounds(120,50,165,35);
        panel.add(currencyBox);

        JLabel outputLabel = new JLabel("JMD Amount $:");
        outputLabel.setBounds(10,80,165,35);
        panel.add(outputLabel);

        JTextField outPutTextField = new JTextField();
        outPutTextField.setBounds(120,80,165,35);
        outPutTextField.setEditable(false);
        panel.add(outPutTextField);


        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(60, 120,100,30);
        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getAmount = inputTextField.getText();
                double inputCurrency2Double = 0;
                try {
                    inputCurrency2Double = Double.parseDouble(getAmount);
                }catch (NumberFormatException ignored){
                    System.out.println("Cannot convert a null value");
                    //catches if string is empty or non-numerical value entered
                    JOptionPane.showMessageDialog(null,"Please input a valid numerical value!");
                }



                switch (initCurrency[0]){
                    case "US": convertedAmount[0] = inputCurrency2Double * usdValue;
                        break;
                    case "CAN": convertedAmount[0] = inputCurrency2Double * canValue;
                        break;
                    case "Euro": convertedAmount[0] = inputCurrency2Double * euroValue;
                        break;
                }

                if (convertedAmount[0] > 0){
                    outPutTextField.setText(String.format( "%.2f", convertedAmount[0] ));
                }

            }
        });
        panel.add(convertBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(160, 120,100,30);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputTextField.setText("");
                outPutTextField.setText("");
                currencyBox.setSelectedIndex(0);
                initCurrency[0] = "US";

            }
        });
        panel.add(clearBtn);




        frame.setVisible(true);


    }

}