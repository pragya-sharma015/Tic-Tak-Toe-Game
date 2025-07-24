import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
    JButton[] buttons = new JButton[9];
    boolean isXturn = true;

    public TicTacToe() {
        setTitle("Tic Tac Toe - Swing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        initializeButtons();
        setVisible(true);
    }

    public void initializeButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();

        if (!btnClicked.getText().equals("")) {
            return; // already clicked
        }

        btnClicked.setText(isXturn ? "X" : "O");

        if (checkWinner()) {
            JOptionPane.showMessageDialog(this, (isXturn ? "X" : "O") + " Wins!");
            resetGame();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a Draw!");
            resetGame();
        }

        isXturn = !isXturn;
    }

    public boolean isBoardFull() {
        for (JButton btn : buttons) {
            if (btn.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWinner() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = buttons[i].getText();
        }

        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals("") &&
                    board[i][0].equals(board[i][1]) &&
                    board[i][0].equals(board[i][2])) {
                return true;
            }

            if (!board[0][i].equals("") &&
                    board[0][i].equals(board[1][i]) &&
                    board[0][i].equals(board[2][i])) {
                return true;
            }
        }

        // Diagonals
        if (!board[0][0].equals("") &&
                board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2])) {
            return true;
        }

        if (!board[0][2].equals("") &&
                board[0][2].equals(board[1][1]) &&
                board[0][2].equals(board[2][0])) {
            return true;
        }

        return false;
    }

    public void resetGame() {
        for (JButton btn : buttons) {
            btn.setText("");
        }
        isXturn = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
