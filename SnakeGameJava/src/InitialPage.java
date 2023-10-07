import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InitialPage extends JPanel {
    private final int WIDTH = 600;
    private final int HEIGHT = 350;

    public InitialPage() {
        initUI();
    }

    private void initUI() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());

        // Carregue a imagem de fundo do menu
        BufferedImage backgroundImage = loadImage("C:\\My Applications\\JavaApplications\\SnakeGameJava\\img\\Snake_Menu.jpg");

        if (backgroundImage != null) {
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            add(backgroundLabel);
        } else {
            // Imagem não encontrada, adicione um painel simples como backup
            add(new JLabel("Snake Game - Menu"));
        }

        // Crie um painel para os botões de menu
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        add(buttonPanel, BorderLayout.SOUTH);

        // Adicione os botões de menu
        JButton playButton = new JButton("Play");
        JButton instructionsButton = new JButton("Instructions");
        JButton developerButton = new JButton("Developer");

        buttonPanel.add(playButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(developerButton);

        // Ação do botão Play para iniciar o jogo
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // Ação do botão Instructions para mostrar as instruções
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInstructions();
            }
        });

        // Ação do botão Developer para mostrar informações sobre você
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
        // Implemente a lógica para mostrar as instruções aqui
        // Você pode criar uma nova janela ou substituir o conteúdo na mesma janela.
        // Por exemplo, você pode usar um JOptionPane para mostrar as instruções em uma caixa de diálogo.
    }

    private void showDeveloperInfo() {
        // Implemente a lógica para mostrar informações sobre você aqui
        // Você pode criar uma nova janela ou substituir o conteúdo na mesma janela.
        // Por exemplo, você pode usar um JOptionPane para mostrar informações sobre você em uma caixa de diálogo.
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Game - Menu");
            InitialPage initialPage = new InitialPage();
            frame.add(initialPage);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
