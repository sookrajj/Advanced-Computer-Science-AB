package Q1.chatgpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class snake extends JPanel implements ActionListener {

    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int BLOCK_SIZE = 10;
    private final int NUM_BLOCKS_X = WIDTH / BLOCK_SIZE;
    private final int NUM_BLOCKS_Y = HEIGHT / BLOCK_SIZE;

    private LinkedList<Point> snake;
    private Point food;
    private char direction;
    private boolean gameOver;
    private Timer timer;

    public snake() {
        snake = new LinkedList<>();
        snake.add(new Point(NUM_BLOCKS_X / 2, NUM_BLOCKS_Y / 2));
        direction = 'R';
        spawnFood();
        gameOver = false;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLUE);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (direction != 'D') direction = 'U';
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 'U') direction = 'D';
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direction != 'R') direction = 'L';
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 'L') direction = 'R';
                        break;
                }
            }
        });

        timer = new Timer(100, this);
        timer.start();
    }

    private void spawnFood() {
        Random rand = new Random();
        int x = rand.nextInt(NUM_BLOCKS_X);
        int y = rand.nextInt(NUM_BLOCKS_Y);
        food = new Point(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over! Press R to Restart", WIDTH / 4, HEIGHT / 2);
            return;
        }

        g.setColor(Color.GREEN);
        for (Point point : snake) {
            g.fillRect(point.x * BLOCK_SIZE, point.y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        }

        g.setColor(Color.YELLOW);
        g.fillRect(food.x * BLOCK_SIZE, food.y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case 'U': newHead.y--; break;
            case 'D': newHead.y++; break;
            case 'L': newHead.x--; break;
            case 'R': newHead.x++; break;
        }

        if (newHead.x < 0 || newHead.x >= NUM_BLOCKS_X || newHead.y < 0 || newHead.y >= NUM_BLOCKS_Y || snake.contains(newHead)) {
            gameOver = true;
            timer.stop();
        } else {
            snake.addFirst(newHead);
            if (newHead.equals(food)) {
                spawnFood();
            } else {
                snake.removeLast();
            }
        }

        repaint();
    }

    public void restart() {
        snake.clear();
        snake.add(new Point(NUM_BLOCKS_X / 2, NUM_BLOCKS_Y / 2));
        direction = 'R';
        spawnFood();
        gameOver = false;
        timer.start();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        snake game = new snake();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    game.restart();
                }
            }
        });
    }
}

