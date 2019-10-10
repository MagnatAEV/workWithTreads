package albul.matirealdesign.android.ru.workwithtreads.acynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import albul.matirealdesign.android.ru.workwithtreads.R;
import albul.matirealdesign.android.ru.workwithtreads.acynctask.observer.GeneratorOfSpam;
import albul.matirealdesign.android.ru.workwithtreads.acynctask.observer.Subscriber;

public class ObserverActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSign;
    Button btnUnsign;
    Button btnSpam;
    GeneratorOfSpam generatorOfSpam;
    Subscriber subscriber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        generatorOfSpam = new GeneratorOfSpam();
        subscriber = new Subscriber();

        btnSign = findViewById(R.id.btn_sign);
        btnUnsign = findViewById(R.id.btn_unsign);
        btnSpam = findViewById(R.id.btn_spam);
        btnSign.setOnClickListener(this);
        btnUnsign.setOnClickListener(this);
        btnSpam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign:
                generatorOfSpam.attach(subscriber);
                break;
            case R.id.btn_unsign:
                generatorOfSpam.detach(subscriber);
                break;
            case R.id.btn_spam:
                generatorOfSpam.setSpam("SpamPamPam");
                break;
            default:
                break;
        }
    }
}
