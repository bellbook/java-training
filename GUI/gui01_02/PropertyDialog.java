package gui01_02;

import gui01_02.attribute.ColorEnum;
import gui01_02.attribute.FontEnum;
import gui01_02.attribute.SizeEnum;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class PropertyDialog extends Dialog {

    // Relationship
    private DigitalClock owner;

    // Field
    private String font            = FontEnum.ARIAL.getFont();
    private int    fontSize        = SizeEnum._36.getSize();
    private Color  fontColor       = ColorEnum.BLACK.getColor();
    private Color  backgroundColor = ColorEnum.WHITE.getColor();

    // GUI Field
    private Label fontLabel, fontSizeLabel, fontColorLabel, backgroundColorLabel;
    private Choice fontChoice, fontSizeChoice, fontColorChoice, backgroundColorChoice;
    private Button okButton;

    public PropertyDialog(DigitalClock owner) {
        super(owner);
        this.owner = owner;

        initLayout();
        pack();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    private void initLayout() {

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        fontLabel = new Label(" Font :");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontLabel, c);
        add(fontLabel);

        fontChoice = new Choice();
        for (FontEnum e : FontEnum.values())
            fontChoice.add(e.toString());
        fontChoice.select(FontEnum.ARIAL.toString());
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontChoice, c);
        add(fontChoice);
        fontChoice.addItemListener(new ItemEventHandler());

        fontSizeLabel = new Label(" Font Size :");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontSizeLabel, c);
        add(fontSizeLabel);

        fontSizeChoice = new Choice();
        for (SizeEnum e : SizeEnum.values())
            fontSizeChoice.add(e.toString());
        fontSizeChoice.select(SizeEnum._36.toString());
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontSizeChoice, c);
        add(fontSizeChoice);
        fontSizeChoice.addItemListener(new ItemEventHandler());

        fontColorLabel = new Label(" Font Color :");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontColorLabel, c);
        add(fontColorLabel);

        fontColorChoice = new Choice();
        for (ColorEnum e : ColorEnum.values())
            fontColorChoice.add(e.toString());
        fontColorChoice.select(ColorEnum.BLACK.toString());
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontColorChoice, c);
        add(fontColorChoice);
        fontColorChoice.addItemListener(new ItemEventHandler());

        backgroundColorLabel = new Label(" Background Color :");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(backgroundColorLabel, c);
        add(backgroundColorLabel);

        backgroundColorChoice = new Choice();
        for (ColorEnum e : ColorEnum.values())
            backgroundColorChoice.add(e.toString());
        backgroundColorChoice.select(ColorEnum.WHITE.toString());
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(backgroundColorChoice, c);
        add(backgroundColorChoice);
        backgroundColorChoice.addItemListener(new ItemEventHandler());

        okButton = new Button("OK");
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.CENTER;
        gridbag.setConstraints(okButton, c);
        add(okButton);
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                owner.setFont(font);
                owner.setFontSize(fontSize);
                owner.setFontColor(fontColor);
                owner.setBackgroundColor(backgroundColor);
                owner.changeSizeEvent();
                setVisible(false);
            }

        });

        setLayout(gridbag);
    }

    class ItemEventHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {

            if (ie.getSource() == fontChoice) {

                for (FontEnum e : FontEnum.values()) {
                    if (fontChoice.getSelectedItem().equals(e.toString())) {
                        font = e.getFont();
                        break;
                    }
                }

            } else if (ie.getSource() == fontSizeChoice) {

                for (SizeEnum e : SizeEnum.values()) {
                    if (fontSizeChoice.getSelectedItem().equals(e.toString())) {
                        fontSize = e.getSize();
                        break;
                    }
                }

            } else if (ie.getSource() == fontColorChoice) {

                for (ColorEnum e : ColorEnum.values()) {
                    if (fontColorChoice.getSelectedItem().equals(e.toString())) {
                        fontColor = e.getColor();
                        break;
                    }
                }

            } else if (ie.getSource() == backgroundColorChoice) {

                for (ColorEnum e : ColorEnum.values()) {
                    if (backgroundColorChoice.getSelectedItem().equals(e.toString())) {
                        backgroundColor = e.getColor();
                        break;
                    }
                }

            }

        }

    }

}
