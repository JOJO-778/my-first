import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class TimeController {
    //控制器需要交互模型和视图。
    private final TimeModel model;
    private final TimeView view;

    private Timer timer;

    private boolean isPaused = false;

    private final JTextField[] ts;
    private final JButton[] bs;

    public TimeController(TimeView view, TimeModel timeModel) {
        this.view = view;
        this.model = timeModel;
        this.ts = view.getTs();
        this.bs = view.getBs();

        bs[0].addActionListener(new ButtonListenerOne());
        bs[1].addActionListener(new ButtonListenerTwo());
        bs[2].addActionListener(new ButtonListenerThree());
    }

    public void run() {
        view.init();
    }

    class ButtonListenerOne implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)//actionprformed为如果你要求这个button做一些事情，你就可以在actionPerformed方法中写你要做的事情
        {
            try {
                if (!isPaused) {
                    model.init(ts[3].getText());
                    ts[0].setText(model.getH());//发言剩余时间 输入框背景前景颜色设置
                    ts[0].setBackground(Color.BLUE);
                    ts[0].setForeground(Color.YELLOW);
                    ts[1].setText(model.getM());
                    ts[1].setBackground(Color.BLUE);
                    ts[1].setForeground(Color.YELLOW);
                    ts[2].setText(model.getS());
                    ts[2].setBackground(Color.BLUE);
                    ts[2].setForeground(Color.YELLOW);
                }
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        long h = Long.parseLong(ts[0].getText());//字符串转数字
                        long m = Long.parseLong(ts[1].getText());//字符串转数字
                        long s = Long.parseLong(ts[2].getText());//字符串转数字

                        model.update(ts[0].getText(), ts[1].getText(), ts[2].getText());
                        ts[0].setText(model.getH());
                        ts[1].setText(model.getM());
                        ts[2].setText(model.getS());
                        model.incrementMs();
                        ts[4].setText(model.getPH());
                        ts[5].setText(model.getPM());
                        ts[6].setText(model.getPS());
                        if (h == 0 && m == 0 && s == 0) {
                            bs[2].doClick();
                        }
                    }
                }, 0, 1000);
                bs[0].setEnabled(false);//设置为false，按钮就不可点击
            } catch (NumberFormatException nfe)//捕捉异常
            {
                JOptionPane.showConfirmDialog(view,//输入错误字符时，弹出“输入错误，请重新输入分钟的整数”
                        "输入错误，请重新输入分钟的整数。",
                        "友情提示",
                        JOptionPane.DEFAULT_OPTION,//对话框组件
                        //Java消息提示框JOptionPane的使用方法
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    class ButtonListenerTwo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)//actionprformed为如果你要求这个button做一些事情，你就可以在actionPerformed方法中写你要做的事情
        {
            if (null != timer) {
                timer.cancel();
                timer = null;
            }
            bs[0].setEnabled(true);
            isPaused = true;//暂停
        }
    }

    class ButtonListenerThree implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)//actionprformed为如果你要求这个button做一些事情，你就可以在actionPerformed方法中写你要做的事情
        {
            if (null != timer) {
                timer.cancel();
                timer = null;
            }
            bs[0].setEnabled(true);
            isPaused = false;//停止
            model.resetMs();
        }
    }
}
