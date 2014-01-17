package ch22.ex22_15.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class AppCalculator extends JFrame {

    private static final String METAL = "javax.swing.plaf.metal.MetalLookAndFeel";

    /**
     * コンストラクタ。
     */
    public AppCalculator(){

        try {
            UIManager.setLookAndFeel(METAL);            // 外観を設定
            SwingUtilities.updateComponentTreeUI(this); // 外観を変更
        } catch (Exception e) {
            e.printStackTrace();
        }

        ViewPanel panel = new ViewPanel();
        getContentPane().add(panel); // ContentPaneに載せる

        setTitle("電卓");                               // JFrameのタイトルを設定
        pack();                                         // JFrameを必要最小の大きさにする
        setLocationRelativeTo(null);                    // JFrameをデスクトップの中央に表示
        setResizable(false);                            // JFrameのサイズを固定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrameに終了処理を設定
    }

}
