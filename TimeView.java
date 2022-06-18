import javax.swing.*;
import java.awt.*;

public class TimeView extends JFrame {

    private static final String[] NS =
            {"会议发言计时器", "时", "分", "秒",
                    "计时总分钟数:",
                    "你已用:", "时", "分", "秒", "发言剩余时间:",
                    "开始倒计时", "暂停计时", "停止计时"};

    private int index;

    private final JTextField[] ts;
    private final JButton[] bs;

    public JTextField[] getTs() {
        return ts;
    }

    public JButton[] getBs() {
        return bs;
    }

    public TimeView() {
        this.setTitle(NS[0]);

        ts = new JTextField[7];
        for (int i = 0; i < 4; i++) {//界面设计
            ts[i] = new JTextField();
            ts[i].setPreferredSize(new Dimension(55, 50));//setpreferredsize为设置最好的大小
            ts[i].setFont(new Font("宋体", Font.BOLD, 30));//高宽 font为字体显示效果
            ts[i].setHorizontalAlignment(SwingConstants.CENTER);//居中对齐
            ts[i].setOpaque(true);//设置不透明
            ts[i].setBackground(Color.CYAN);//背景颜色
            ts[i].setForeground(Color.RED);//前景颜色
            if (i != 3) {
                ts[i].setEditable(false);//设置选项不可用
            }
        }
        for (int i = 4; i < 7; i++) {
            ts[i] = new JTextField();
            ts[i].setPreferredSize(new Dimension(55, 60));
            ts[i].setFont(new Font("宋体", Font.BOLD, 30));
            ts[i].setHorizontalAlignment(SwingConstants.CENTER);//居中对齐
            ts[i].setOpaque(true);
            ts[i].setBackground(Color.BLUE);
            ts[i].setForeground(Color.RED);
        }
        JLabel[] ls = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            ls[i] = new JLabel(NS[index++]);//字体样式
            ls[i].setForeground(Color.black);
            ls[i].setFont(new Font("宋体", Font.BOLD, 30));
        }
        bs = new JButton[3];
        for (int i = 0; i < 3; i++) {
            bs[i] = new JButton(NS[index++]);
            bs[i].setBackground(Color.BLUE);//背景
            bs[i].setForeground(Color.YELLOW);//前景
        }
        JComponent[][] cs = {{ls[0]},
                {ls[4], ts[3]},
                {ls[9], ts[0], ls[1], ts[1], ls[2], ts[2], ls[3]},
                {ls[5], ts[4], ls[6], ts[5], ls[7], ts[6], ls[8]},
                {bs[0], bs[1], bs[2]}};
        JPanel[] ps = new JPanel[5];//Jpanel面板
        JPanel wrap = new JPanel();
        wrap.setLayout(new BoxLayout(wrap, BoxLayout.Y_AXIS));//边界布局 Y_AXIS为Y坐标轴
        for (int i = 0; i < 5; i++) {
            ps[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));//流式布局（从上到下、从左到右）居中
            for (int j = 0; j < cs[i].length; j++) {
                ps[i].add(cs[i][j]);
                ps[i].setBackground(Color.YELLOW);//背景颜色
            }
            wrap.add(ps[i]);
        }
        this.add(wrap);
    }

    public void init() {
        pack();
        setResizable(true);//可自由调整大小
        setLocationRelativeTo(null);//生成窗口置于屏幕中央
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit退出。使用Systemexit方法退出应用程序。仅在应用程序中使用。
        setVisible(true);//显示GUI组件
    }

}
