package com.example.leijianmin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestActivity extends AppCompatActivity {

    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvTime = (TextView) findViewById(R.id.tv_time);

        init();
    }




    private void init() {
        long time = (System.currentTimeMillis() - 1000 * 60 * 60 * 28) / 1000;

        tvTime.setText(getTimeString(time));
    }

    private static final int VALUE_MIN = 60;
    private static final int VALUE_HOUR = 60 * 60;
    private static final int VALUE_DAY = 24 * 60 * 60;

    /**
     * @param lastTime 单位为秒
     * @return
     *
     * /**
     *
     * 时间的显示规则
    x= 当前时间 - 对方发生动作的时间(最后离开houseparty的时间 或 上次对方打招呼的时间)

    · 当天的
    <1min 显示 Just ago
    >1min, <59min 显示   xm ago
    >59min, <24h 显示 xh ago

    · 非当天的
    显示对方发生动作的时间，显示格式   16:21 Fri ( 星期缩写，对照如下 )

    星期一： Mon.=Monday
    星期二： Tues.=Tuesday
    星期三： Wed.=Wednesday
    星期四： Thur.=Thurday
    星期五： Fri.=Friday
    星期六： Sat.=Saturday
    星期天： Sun.=Sunday
     */
    private String getTimeString(long lastTime) {
        String timeStr = "";

        long currTime = System.currentTimeMillis() / 1000;

        long delta = currTime - lastTime;

        if (delta < VALUE_MIN) {
            timeStr = "Just ago";
        } else if (delta >= VALUE_MIN && delta < VALUE_HOUR) {
            timeStr = (delta / VALUE_MIN) + " min ago";
        } else if (delta >= VALUE_HOUR && delta < VALUE_DAY) {
            timeStr = (delta / VALUE_HOUR) + " hour ago";
        } else {
            long time = lastTime * 1000;
            SimpleDateFormat myFmt = new SimpleDateFormat("HH:mm E");
            timeStr = myFmt.format(new Date(time));
        }

        return timeStr;
    }

}
