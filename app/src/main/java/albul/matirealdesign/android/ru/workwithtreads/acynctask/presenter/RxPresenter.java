package albul.matirealdesign.android.ru.workwithtreads.acynctask.presenter;

import android.util.Log;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public class RxPresenter {

    private String TAG = "Presenter";

    public Observable<String> getData(){

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i = 0; i < 100; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        String data = "pakage: " + i;
                        Log.d(TAG, "subscribe: ");
                        emitter.onNext(data);
                    } catch (Exception e){
                        Log.d(TAG, "subscribe: " + e);
                    }
                }
            }
        }).subscribeOn(Schedulers.io());

        return observable;
    }

}
