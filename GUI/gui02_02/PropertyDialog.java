package gui02_02;

import gui02_02.attribute.ColorEnum;
import gui02_02.attribute.FontEnum;
import gui02_02.attribute.SizeEnum;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("serial")
public class PropertyDialog extends JDialog {

    // Relationship
    private DigitalClock owner;

    // Field
    private String font            = FontEnum.ARIAL.getFont();
    private int    fontSize        = SizeEnum._36.getSize();
    private Color  fontColor       = ColorEnum.BLACK.getColor();
    private Color  backgroundColor = ColorEnum.WHITE.getColor();

    // GUI Field
    private JLabel fontLabel, fontSizeLabel, fontColorLabel, backgroundColorLabel;
    @SuppressWarnings("rawtypes")
    private JComboBox fontBox, fontSizeBox, fontColorBox, backgroundColorBox;
    private JButton okButton;

    public PropertyDialog(DigitalClock owner) {
        super(owner);
        this.owner = owner;

        initLayout();
        pack();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initLayout() {

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        DefaultComboBoxModel model;

        fontLabel = new JLabel(" Font :");
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

        fontBox = new JComboBox(FontEnum.values());
        fontBox.setSelectedItem(FontEnum.ARIAL);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontBox, c);
        add(fontBox);
        fontBox.addItemListener(new ItemEventHandler());

        fontSizeLabel = new JLabel(" Font Size :");
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

        fontSizeBox = new JComboBox(SizeEnum.values());
        fontSizeBox.setSelectedItem(SizeEnum._36);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontSizeBox, c);
        add(fontSizeBox);
        fontSizeBox.addItemListener(new ItemEventHandler());

        fontColorLabel = new JLabel(" Font Color :");
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

        model = new DefaultComboBoxModel();
        for (ColorEnum e : ColorEnum.values())
            model.addElement(e);
        fontColorBox = new JComboBox(model);
        fontColorBox.setSelectedItem(ColorEnum.BLACK);
        fontColorBox.setRenderer(new CellRenderer());
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(fontColorBox, c);
        add(fontColorBox);
        fontColorBox.addItemListener(new ItemEventHandler());

        backgroundColorLabel = new JLabel(" Background Color :");
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

        model = new DefaultComboBoxModel();
        for (ColorEnum e : ColorEnum.values())
            model.addElement(e);
        backgroundColorBox = new JComboBox(model);
        backgroundColorBox.setSelectedItem(ColorEnum.WHITE);
        backgroundColorBox.setRenderer(new CellRenderer());
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(backgroundColorBox, c);
        add(backgroundColorBox);
        backgroundColorBox.addItemListener(new ItemEventHandler());

        okButton = new JButton("OK");
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

            if (ie.getSource() == fontBox) {

                for (FontEnum e : FontEnum.values()) {
                    if (fontBox.getSelectedItem().equals(e)) {
                        font = e.getFont();
                        break;
                    }
                }

            } else if (ie.getSource() == fontSizeBox) {

                for (SizeEnum e : SizeEnum.values()) {
                    if (fontSizeBox.getSelectedItem().equals(e)) {
                        fontSize = e.getSize();
                        break;
                    }
                }

            } else if (ie.getSource() == fontColorBox) {

                for (ColorEnum e : ColorEnum.values()) {
                    if (fontColorBox.getSelectedItem().equals(e)) {
                        fontColor = e.getColor();
                        break;
                    }
                }

            } else if (ie.getSource() == backgroundColorBox) {

                for (ColorEnum e : ColorEnum.values()) {
                    if (backgroundColorBox.getSelectedItem().equals(e)) {
                        backgroundColor = e.getColor();
                        break;
                    }
                }

            }

        }

    }

    @SuppressWarnings("rawtypes")
    class CellRenderer extends JLabel implements ListCellRenderer {

        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            ColorEnum data = (ColorEnum) value;
            setText(data.toString());
            setIcon(data.getIcon());

            return this;
        }
    }

}
