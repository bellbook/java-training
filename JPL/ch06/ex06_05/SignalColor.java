package ch06.ex06_05;

import java.awt.Color;

public enum SignalColor {

    // 今回の場合、定数固有のメソッドを使用することは
    // 共通化できる処理をわざわざ個別の処理で書くことに他ならない。
    // コードが冗長になり、バグが発生しやすくなるので推奨しない。

    GREEN {
        @Override
        public Color getColor() {
            return Color.GREEN;
        }
    },

    YELLOW {
        @Override
        public Color getColor() {
            return Color.YELLOW;
        }
    },

    RED {
        @Override
        public Color getColor() {
            return Color.RED;
        }
    };

    public abstract Color getColor();

}
