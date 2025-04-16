package MorseCode.SwingGUI;

import MorseCode.domain.MorseTranslator;
import MorseCode.domain.StringTranslator;

import javax.swing.*;
import java.awt.*;

public class MorseTranslatorGUI {
    public static void main(String[] args) {
        // Criar janela principal
        JFrame frame = new JFrame("Morse Code Translator");
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal com layout vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // margem

        // Campo de entrada
        JTextField inputField = new JTextField(30);
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Rótulo do campo de entrada
        JLabel inputLabel = new JLabel("Digite o texto ou código Morse:");
        inputLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Painel dos botões
        JPanel buttonPanel = new JPanel();
        JButton stringToMorseButton = new JButton("String → Morse");
        JButton morseToStringButton = new JButton("Morse → String");
        buttonPanel.add(stringToMorseButton);
        buttonPanel.add(morseToStringButton);

        // Resultado
        JLabel resultLabel = new JLabel("Resultado: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultLabel.setForeground(Color.BLUE);

        // Adiciona componentes ao painel principal
        mainPanel.add(inputLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5))); // espaço
        mainPanel.add(inputField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(resultLabel);

        // Adiciona painel à janela
        frame.add(mainPanel);
        frame.setVisible(true);

        // Ações dos botões
        morseToStringButton.addActionListener(e -> {
            String morseCode = inputField.getText();
            if (morseCode.isEmpty()) {
                resultLabel.setText("⚠️ Digite algo para traduzir.");
            } else {
                String text = new StringTranslator().translateToString(morseCode);
                resultLabel.setText("Resultado: " + text);
            }
        });

        stringToMorseButton.addActionListener(e -> {
            String inputText = inputField.getText();
            if (inputText.isEmpty()) {
                resultLabel.setText("⚠️ Digite algo para traduzir.");
            } else {
                String morseCode = new MorseTranslator().translateToMorse(inputText);
                resultLabel.setText("Resultado: " + morseCode);
            }
        });
    }
}
