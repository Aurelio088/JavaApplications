/**
 * This is a simplified version of the classic Snake game, written in Java.
 *
 * The main idea of developing this game was to practice the Java programming language.
 *
 * @author Aurelio Rodrigues
 * @version 1.0
 * @since 2023-10-10
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InitialPage extends JPanel {
    private final int WIDTH = 600; // Width of the menu
    private final int HEIGHT = 350; // Height of the menu


    public InitialPage() {
        initUI();
    }

    private void initUI() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());

        // Load the background image
        BufferedImage backgroundImage = loadImage("C:\\My Applications\\JavaApplications\\SnakeGameJava\\img\\Snake_Menu.jpg");

        if (backgroundImage != null) {
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            add(backgroundLabel);
        } else {
            add(new JLabel("Snake Game - Menu - by Aurelio Rodrigues"));
        }

        // Creating a panel to add the buttons, using JPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        add(buttonPanel, BorderLayout.SOUTH);

        // Adding the buttons to the panel
        JButton playButton = new JButton("Play");
        JButton instructionsButton = new JButton("Instructions");
        JButton developerButton = new JButton("Developer");

        buttonPanel.add(playButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(developerButton);

        // Play button action to start the game
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // Instruction button action to show the instructions
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInstructions();
            }
        });

        // Developer button action to show the developer info
        developerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeveloperInfo();
            }
        });
    }

    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void startGame() {
        // Inicie o jogo (abrir a tela do jogo)
        JFrame gameFrame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        gameFrame.add(game);
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    private void showInstructions() {
        // To be implemented
    }

    private void showDeveloperInfo() {
        // To be implemented
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Game - Menu - by Aurelio Rodrigues");
            InitialPage initialPage = new InitialPage();
            frame.add(initialPage);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
