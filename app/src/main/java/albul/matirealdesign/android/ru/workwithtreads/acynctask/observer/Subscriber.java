package albul.matirealdesign.android.ru.workwithtreads.acynctask.observer;


import android.util.Log;

import java.util.PriorityQueue;

import static android.content.ContentValues.TAG;

public class Subscriber implements Observer {

    String msg;

    public String getMsg() {
        return msg;
    }

    @Override
    public void update(Subject subject, Object arg) {
        msg = (String) arg;
        Log.d(TAG, "From: " + subject.toString() + "msg - " + msg);
    }
}
