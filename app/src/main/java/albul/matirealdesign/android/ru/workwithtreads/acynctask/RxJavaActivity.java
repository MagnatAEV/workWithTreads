package albul.matirealdesign.android.ru.workwithtreads.acynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import albul.matirealdesign.android.ru.workwithtreads.R;
import albul.matirealdesign.android.ru.workwithtreads.acynctask.presenter.RxPresenter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RxJavaActivity extends AppCompatActivity {

    private String TAG = "RX_PRESENTER";
    private RxPresenter rxPresenter;
    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        rxPresenter = new RxPresenter();
        observable = rxPresenter.getData();
    }

    public void subscribe(View v){

        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
                RxJavaActivity.this.disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: " + Thread.currentThread().getName());
            }
        });

    }

    public void unsubscribe(View v){
        disposable.dispose();
    }

}
