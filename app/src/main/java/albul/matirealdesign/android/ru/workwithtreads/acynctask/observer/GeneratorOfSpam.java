package albul.matirealdesign.android.ru.workwithtreads.acynctask.observer;

import android.content.Intent;

public class GeneratorOfSpam extends Subject {

    private String spamMsg;

    public String getSpam(){
        return "spam" + Integer.toString((int)(Math.random()*10));
    }

    public void setSpam(String spamMsg){
        this.spamMsg = spamMsg;
        notify(spamMsg);
    }

}
