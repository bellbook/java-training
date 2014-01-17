package ch22.ex22_15.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import ch22.ex22_15.logic.calculator.Calculator;
import ch22.ex22_15.logic.parser.SyntaxException;

/**
 * 表示用パネル。<br>
 * 計算式表示欄 + ボタンパネル を配置する。
 */
@SuppressWarnings("serial")
public class ViewPanel extends JPanel {

    private JTextField text = new JTextField(""); // 計算式表示欄
    private JPanel buttonPanel = new JPanel(); // ボタンパネル

    /**
     * コンストラクタ。
     */
    public ViewPanel() {

        setLayout(new BorderLayout());

        // 計算式表示欄
        text.setMargin(new Insets(2, 2, 2, 2));
        text.setHorizontalAlignment(JTextField.RIGHT); // 右寄せ
        text.setEditable(false); // 編集不可
        text.setBackground(Color.white);
        add(text, BorderLayout.NORTH);

        // ボタンパネル
        layoutButtonPanel(buttonPanel);
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        buttonPanel.setPreferredSize(new Dimension(240, 200));
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        revalidate();
    }

    /**
     * ボタンパネルを配置する。
     *
     * @param p
     */
    private void layoutButtonPanel(JPanel p) {

        JButton button;
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        // GridBagConstraints の初期値
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;

        // "C"
        button = new ClearButton("C");
        setGridBag(p, button, layout, constraints, 4, 0, 1, 1);

        // "DEL"
        button = new ClearButton("DEL");
        setGridBag(p, button, layout, constraints, 3, 0, 1, 1);

        // "0"
        button = new NumberButton("0");
        setGridBag(p, button, layout, constraints, 0, 4, 1, 1);

        // "1"
        button = new NumberButton("1");
        setGridBag(p, button, layout, constraints, 0, 3, 1, 1);

        // "2"
        button = new NumberButton("2");
        setGridBag(p, button, layout, constraints, 1, 3, 1, 1);

        // "3"
        button = new NumberButton("3");
        setGridBag(p, button, layout, constraints, 2, 3, 1, 1);

        // "4"
        button = new NumberButton("4");
        setGridBag(p, button, layout, constraints, 0, 2, 1, 1);

        // "5"
        button = new NumberButton("5");
        setGridBag(p, button, layout, constraints, 1, 2, 1, 1);

        // "6"
        button = new NumberButton("6");
        setGridBag(p, button, layout, constraints, 2, 2, 1, 1);

        // "7"
        button = new NumberButton("7");
        setGridBag(p, button, layout, constraints, 0, 1, 1, 1);

        // "8"
        button = new NumberButton("8");
        setGridBag(p, button, layout, constraints, 1, 1, 1, 1);

        // "9"
        button = new NumberButton("9");
        setGridBag(p, button, layout, constraints, 2, 1, 1, 1);

        // "."
        button = new NumberButton(".");
        setGridBag(p, button, layout, constraints, 1, 4, 1, 1);

        // "+"
        button = new OperatorButton("+");
        setGridBag(p, button, layout, constraints, 3, 1, 1, 1);

        // "-"
        button = new OperatorButton("-");
        setGridBag(p, button, layout, constraints, 4, 1, 1, 1);

        // "*"
        button = new OperatorButton("*");
        setGridBag(p, button, layout, constraints, 3, 2, 1, 1);

        // "/"
        button = new OperatorButton("/");
        setGridBag(p, button, layout, constraints, 4, 2, 1, 1);

        // "%"
        button = new OperatorButton("%");
        setGridBag(p, button, layout, constraints, 3, 3, 1, 1);

        // "^"
        button = new OperatorButton("^");
        setGridBag(p, button, layout, constraints, 4, 3, 1, 1);

        // "("
        button = new OperatorButton("(");
        setGridBag(p, button, layout, constraints, 3, 4, 1, 1);

        // ")"
        button = new OperatorButton(")");
        setGridBag(p, button, layout, constraints, 4, 4, 1, 1);

        // "="
        button = new EqualButton("=");
        setGridBag(p, button, layout, constraints, 2, 4, 1, 1);

        p.setLayout(layout);
    }

    /**
     * GridBagLayout の補助用メソッド。
     *
     * @param container
     * @param component
     * @param layout
     * @param constraints
     * @param gx
     * @param gy
     * @param gw
     * @param gh
     */
    private void setGridBag(Container container, Component component,
            GridBagLayout layout, GridBagConstraints constraints, int gx,
            int gy, int gw, int gh) {
        constraints.gridx = gx;
        constraints.gridy = gy;
        constraints.gridwidth = gw;
        constraints.gridheight = gh;
        layout.setConstraints(component, constraints);
        container.add(component);
    }

    /**
     * TextField に文字列を繋げる。
     *
     * @param s
     *            文字列
     */
    private void append(String s, JTextField textField) {
        textField.setText(textField.getText() + s);
    }

    /**
     * TextField の文字列を１字削除する。
     */
    private void delete(JTextField textField) {

        if (textField.getText().length() != 0) {
            StringBuilder sb = new StringBuilder(textField.getText());
            sb.deleteCharAt(sb.length() - 1);
            textField.setText(sb.toString());
        }
    }

    /**
     * 共通のデフォルトボタン。
     */
    private abstract class DefaultButton extends JButton implements
            ActionListener {

        public DefaultButton(String name) {
            super(name);
            setPreferredSize(new Dimension(45, 30));
            setFont(new Font("Arial", Font.BOLD, 16));
            setBorder(new BevelBorder(BevelBorder.RAISED));
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            append(getText(), text);
        }

    }

    /**
     * クリアボタン。
     */
    private class ClearButton extends DefaultButton {

        public ClearButton(String name) {
            super(name);
            setForeground(Color.WHITE);
            setBackground(Color.RED);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand() == "C")
                text.setText("");
            else if (ae.getActionCommand() == "DEL")
                delete(text);
            else
                ;
        }

    }

    /**
     * 数字ボタン。
     */
    private class NumberButton extends DefaultButton {

        public NumberButton(String name) {
            super(name);
        }

    }

    /**
     * 演算ボタン。
     */
    private class OperatorButton extends DefaultButton {

        public OperatorButton(String name) {
            super(name);
            setForeground(Color.BLUE);
        }

    }

    /**
     * "=" ボタン。
     */
    private class EqualButton extends DefaultButton {

        public EqualButton(String name) {
            super(name);
            setForeground(Color.WHITE);
            setBackground(Color.ORANGE);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                BigDecimal calc = Calculator.calculate(text.getText());
                text.setText(calc.toString());
            } catch (SyntaxException e) {
                e.printStackTrace();
                text.setText("Syntax ERROR");
            }
        }
    }

}