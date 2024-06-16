import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 
 * @author Ruvimbo Machekano 
 */

public class Quiz_Form extends JFrame {
    private String[] questions = {
        "What fruit is dried to produce raisins?",
        "I am medium-sized and round, I can be or green. What am I?",
        "Which of these ISN'T a real type of fruit?",
        "What fruit are monkeys known to enjoy?",
        "Which fruit is typically used to make wine?"
    };

    private String[][] options = {
        {"Apple", "Peaches", "Grapes", "Plums", "Grapes"},
        {"Strawberry", "Apple", "Banana", "Watermelon", "Apple"},
        {"Boogletang", "Pomegranate","Apricot", "Lychee", "Boogletang"},
        {"Bananas", "Cherries", "Apples", "Pears", "Bananas"},
        {"Red", "Green", "Maroon", "Black", "Black"}
    };

    private int index = 0, correct = 0;
    private ButtonGroup bg = new ButtonGroup();
    private JLabel Lbl_Question = new JLabel();
    private JRadioButton jRadioButton1_ = new JRadioButton();
    private JRadioButton jRadioButton2_ = new JRadioButton();
    private JRadioButton jRadioButton3_ = new JRadioButton();
    private JRadioButton jRadioButton4_ = new JRadioButton();
    private JButton jButton_Next_Q = new JButton("Next");
    private JPanel jPanel_Q_Container = new JPanel();

    public Quiz_Form() {
        initComponents();

        bg.add(jRadioButton1_);
        bg.add(jRadioButton2_);
        bg.add(jRadioButton3_);
        bg.add(jRadioButton4_);

        jButton_Next_QActionPerformed(null);
    }

    private void initComponents() {
        setTitle("Fun Fruit Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        jPanel_Q_Container.setLayout(new GridLayout(6, 1));
        jPanel_Q_Container.add(Lbl_Question);
        jPanel_Q_Container.add(jRadioButton1_);
        jPanel_Q_Container.add(jRadioButton2_);
        jPanel_Q_Container.add(jRadioButton3_);
        jPanel_Q_Container.add(jRadioButton4_);
        jPanel_Q_Container.add(jButton_Next_Q);

        add(jPanel_Q_Container, BorderLayout.CENTER);

        jRadioButton1_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                getSelectedOption(jRadioButton1_);
            }
        });

        jRadioButton2_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                getSelectedOption(jRadioButton2_);
            }
        });

        jRadioButton3_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                getSelectedOption(jRadioButton3_);
            }
        });

        jRadioButton4_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                getSelectedOption(jRadioButton4_);
            }
        });

        jButton_Next_Q.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_Next_QActionPerformed(evt);
            }
        });
    }

    public void getSelectedOption(JRadioButton rbtn) {
        
        System.out.println(rbtn.getText());
        System.out.println(options[index][4]);

        if (rbtn.getText().equals(options[index][4])) {
            correct++;
        }
        index++;
        enableRbuttons(false);
    }

    public void enableRbuttons(boolean yes_or_no) {
        jRadioButton1_.setEnabled(yes_or_no);
        jRadioButton2_.setEnabled(yes_or_no);
        jRadioButton3_.setEnabled(yes_or_no);
        jRadioButton4_.setEnabled(yes_or_no);
    }

    private void jButton_Next_QActionPerformed(ActionEvent evt) {
        if (jButton_Next_Q.getText().equals("Restart Quiz")) {
            // Restart quiz
            jButton_Next_Q.setText("Next");
            jPanel_Q_Container.setBackground(new java.awt.Color(204, 204, 204));
            index = 0;
            correct = 0;
        }

        if (index == questions.length) {
            // Display score
            Lbl_Question.setText("You Scored: " + correct + " / " + questions.length);
            if (correct >= (float) questions.length / 2) {
                jPanel_Q_Container.setBackground(Color.green);
            } else {
                jPanel_Q_Container.setBackground(Color.pink);
            }

            jButton_Next_Q.setText("Restart Quiz");
        } else {
            enableRbuttons(true);

            Lbl_Question.setText(questions[index]);
            jRadioButton1_.setText(options[index][0]);
            jRadioButton2_.setText(options[index][1]);
            jRadioButton3_.setText(options[index][2]);
            jRadioButton4_.setText(options[index][3]);

            if (index == questions.length - 1) {
                jButton_Next_Q.setText("Finish and See The Result");
            }
        }

        bg.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Quiz_Form().setVisible(true);
            }
        });
    }
}