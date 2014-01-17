package gui01_04;

import gui01_04.attribute.ColorEnum;
import gui01_04.attribute.FontEnum;
import gui01_04.attribute.SizeEnum;

import java.awt.Button;
import java.awt.Choice;
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
    private FontEnum  font            = FontEnum.ARIAL;
    private SizeEnum  fontSize        = SizeEnum._36;
    private ColorEnum fontColor       = ColorEnum.BLACK;
    private ColorEnum backgroundColor = ColorEnum.WHITE;

    private FontEnum  currentFont            = font;
    private SizeEnum  currentFontSize        = fontSize;
    private ColorEnum currentFontColor       = fontColor;
    private ColorEnum currentBackgroundColor = backgroundColor;

    // GUI Field
    private Label fontLabel, fontSizeLabel, fontColorLabel, backgroundColorLabel;
    private Choice fontChoice, fontSizeChoice, fontColorChoice, backgroundColorChoice;
    private Button okButton, cancelButton;

    public PropertyDialog(DigitalClock owner) {
        super(owner);
        this.owner = owner;

        initLayout();
        pack();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                terminate();
            }
        });
    }

    public void init(FontEnum font, SizeEnum fontSize, ColorEnum fontColor, ColorEnum backgroundColor) {
        this.font            = font;
        this.fontSize        = fontSize;
        this.fontColor       = fontColor;
        this.backgroundColor = backgroundColor;

        currentFont            = font;
        currentFontSize        = fontSize;
        currentFontColor       = fontColor;
        currentBackgroundColor = backgroundColor;

        fontChoice.select(currentFont.toString());
        fontSizeChoice.select(currentFontSize.toString());
        fontColorChoice.select(currentFontColor.toString());
        backgroundColorChoice.select(currentBackgroundColor.toString());
    }

    private void initLayout() {

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        fontLabel = new Label(" Font :");
        c.gridx      = 0;
        c.gridy      = 0;
        c.gridwidth  = 1;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.EAST;
        gridbag.setConstraints(fontLabel, c);
        add(fontLabel);

        fontChoice = new Choice();
        for(FontEnum e : FontEnum.values())
            fontChoice.add(e.toString());
        fontChoice.select(currentFont.toString());
        c.gridx      = 1;
        c.gridy      = 0;
        c.gridwidth  = 2;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.WEST;
        gridbag.setConstraints(fontChoice, c);
        add(fontChoice);
        fontChoice.addItemListener(new ItemEventHandler());


        fontSizeLabel = new Label(" Font Size :");
        c.gridx      = 0;
        c.gridy      = 1;
        c.gridwidth  = 1;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.EAST;
        gridbag.setConstraints(fontSizeLabel, c);
        add(fontSizeLabel);


        fontSizeChoice = new Choice();
        for(SizeEnum e : SizeEnum.values())
            fontSizeChoice.add(e.toString());
        fontSizeChoice.select(currentFontSize.toString());
        c.gridx      = 1;
        c.gridy      = 1;
        c.gridwidth  = 2;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.WEST;
        gridbag.setConstraints(fontSizeChoice, c);
        add(fontSizeChoice);
        fontSizeChoice.addItemListener(new ItemEventHandler());


        fontColorLabel = new Label(" Font Color :");
        c.gridx      = 0;
        c.gridy      = 2;
        c.gridwidth  = 1;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.EAST;
        gridbag.setConstraints(fontColorLabel, c);
        add(fontColorLabel);


        fontColorChoice = new Choice();
        for(ColorEnum e : ColorEnum.values())
            fontColorChoice.add(e.toString());
        fontColorChoice.select(currentFontColor.toString());
        c.gridx      = 1;
        c.gridy      = 2;
        c.gridwidth  = 2;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.WEST;
        gridbag.setConstraints(fontColorChoice, c);
        add(fontColorChoice);
        fontColorChoice.addItemListener(new ItemEventHandler());


        backgroundColorLabel = new Label(" Background Color :");
        c.gridx      = 0;
        c.gridy      = 3;
        c.gridwidth  = 1;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.EAST;
        gridbag.setConstraints(backgroundColorLabel, c);
        add(backgroundColorLabel);


        backgroundColorChoice = new Choice();
        for(ColorEnum e : ColorEnum.values())
            backgroundColorChoice.add(e.toString());
        backgroundColorChoice.select(currentBackgroundColor.toString());
        c.gridx      = 1;
        c.gridy      = 3;
        c.gridwidth  = 2;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.NONE;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.WEST;
        gridbag.setConstraints(backgroundColorChoice, c);
        add(backgroundColorChoice);
        backgroundColorChoice.addItemListener(new ItemEventHandler());


        okButton = new Button("OK");
        c.gridx      = 1;
        c.gridy      = 4;
        c.gridwidth  = 1;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.BOTH;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.CENTER;
        gridbag.setConstraints(okButton, c);
        add(okButton);
        okButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                currentFont            = font;
                currentFontSize        = fontSize;
                currentFontColor       = fontColor;
                currentBackgroundColor = backgroundColor;

                owner.setFontEnum(currentFont);
                owner.setFontSizeEnum(currentFontSize);
                owner.setFontColorEnum(currentFontColor);
                owner.setBackgroundColorEnum(currentBackgroundColor);

                owner.changeSizeEvent();

                setVisible(false);
            }

        });

        cancelButton = new Button("Cancel");
        c.gridx      = 2;
        c.gridy      = 4;
        c.gridwidth  = 1;
        c.gridheight = 1;
        c.fill       = GridBagConstraints.BOTH;
        c.weightx    = 100.0;
        c.weighty    = 100.0;
        c.anchor     = GridBagConstraints.CENTER;
        gridbag.setConstraints(cancelButton, c);
        add(cancelButton);
        cancelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                terminate();
            }

        });

        setLayout(gridbag);
    }

    private void terminate() {

        dispose();

        fontChoice.select(currentFont.toString());
        fontSizeChoice.select(currentFontSize.toString());
        fontColorChoice.select(currentFontColor.toString());
        backgroundColorChoice.select(currentBackgroundColor.toString());
    }

    class ItemEventHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {

            if (ie.getSource() == fontChoice) {

                for (FontEnum e : FontEnum.values()) {
                    if (fontChoice.getSelectedItem().equals(e.toString())) {
                        font = e;
                        break;
                    }
                }

            } else if (ie.getSource() == fontSizeChoice) {

                for (SizeEnum e : SizeEnum.values()) {
                    if (fontSizeChoice.getSelectedItem().equals(e.toString())) {
                        fontSize = e;
                        break;
                    }
                }

            } else if (ie.getSource() == fontColorChoice) {

                for (ColorEnum e : ColorEnum.values()) {
                    if (fontColorChoice.getSelectedItem().equals(e.toString())) {
                        fontColor = e;
                        break;
                    }
                }

            } else if (ie.getSource() == backgroundColorChoice) {

                for (ColorEnum e : ColorEnum.values()) {
                    if (backgroundColorChoice.getSelectedItem().equals(e.toString())) {
                        backgroundColor = e;
                        break;
                    }
                }

            }

        }

    }

}
