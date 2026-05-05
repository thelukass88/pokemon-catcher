import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pokemon Catcher!");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        Random rand = new Random();
        String[] pokemonName = {JOptionPane.showInputDialog("Which Pokemon are you trying to catch?")};
        int[] pokeballNeeded = {rand.nextInt(10) + 1};
        
        JLabel label = new JLabel("You're trying to catch: " + pokemonName[0] + "!");
        label.setBounds(50, 50, 300, 30); // x, y, width, height
        frame.add(label);
        
        JLabel instructionLabel = new JLabel("Click the button to throw a pokeball!");
        instructionLabel.setBounds(50, 100, 300, 30);
        frame.add(instructionLabel);
        
        JLabel counterLabel = new JLabel("Pokeballs thrown: 0");
        counterLabel.setBounds(50, 150, 300, 30);
        frame.add(counterLabel);
        
        JButton throwButton = new JButton("ThrowPokeball!");
        throwButton.setBounds(50, 200, 200, 40);
        frame.add(throwButton);
        
        int[] pokeballsThrown = {0};
        
        throwButton.addActionListener(e -> {
            pokeballsThrown[0]++;
            counterLabel.setText("Pokeballs thrown: " + pokeballsThrown[0]);
            
            if (pokeballsThrown[0] >= pokeballNeeded[0]) {
                if (pokeballsThrown[0] <= 2) {
                    JOptionPane.showMessageDialog (null, "Congratulations! You caught " + pokemonName[0] + " in " + pokeballsThrown[0] + " throws! Wow! That's below average, you're a great trainer!");
                } else if (pokeballsThrown[0] >= 8) {
                    JOptionPane.showMessageDialog (null, "You caught " + pokemonName[0] + "! It took you " + pokeballsThrown[0] + " pokeballs! Yikes! I hope you've got some more at home.");
                } else { 
                    JOptionPane.showMessageDialog (null, "Congratulations! You caught " + pokemonName[0] + "! It took you " + pokeballsThrown[0] + " pokeballs!");
                }
            
                        pokeballsThrown[0] = 0;
                        counterLabel.setText("Pokeballs thrown: 0");
                        pokemonName[0] = JOptionPane.showInputDialog("Which Pokemon are you trying to catch next?");
                        label.setText("You're trying to catch: " + pokemonName[0] + "!");
                        pokeballNeeded[0] = rand.nextInt(10) + 1;
            }
        });
        
    
        frame.setVisible(true);        
        
    }
}