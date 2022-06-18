public class TimeModel {

    private long ms = 0;

    private String sh;

    private String sm;

    private String ss;

    public void init(String sm) {
        long min = Long.parseLong(sm);
        long h = min / 60;//时分秒
        h = h < 0 ? 0 : h;
        long m = min - h * 60 - 1;
        m = m < 0 ? 0 : m;
        long s = min == 0 ? 0 : 60;

        this.sh = h + "";
        this.sm = m + "";
        this.ss = s + "";
    }

    public void update(String sh, String sm, String ss) {
        long h = "".equals(sh) ? 0 : Long.parseLong(sh);
        long m = "".equals(sm) ? 0 : Long.parseLong(sm);
        long s = "".equals(ss) ? 0 : Long.parseLong(ss);
        s--;

        if ((h != 0 || m != 0) && s == 0) {
            m--;
            s = 59;
        }
        if (h != 0 && m == 0) {
            h--;
            m = 59;
        }
        h = h < 0 ? 0 : h;//? 和:相当于if和else  例(a%2==0)?a是偶数:a是奇数
        m = m < 0 ? 0 : m;
        s = s < 0 ? 0 : s;

        this.sh = h + "";
        this.sm = m + "";
        this.ss = s + "";
    }

    public String getH() {
        return sh;
    }

    public String getM() {
        return sm;
    }

    public String getS() {
        return ss;
    }

    public void incrementMs() {
        this.ms++;
    }

    public String getPH() {
        return ms / 60 / 60 + "";
    }

    public String getPM() {
        return ms / 60 + "";
    }

    public String getPS() {
        return ms % 60 + "";
    }

    public void resetMs() {
        this.ms = 0;
    }
}

