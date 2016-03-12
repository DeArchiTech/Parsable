package com.parsable.appetizer.parasable.Subscriber;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Repository.IRepository;

import rx.Subscriber;

/**
 * Created by Davix on 3/11/16.
 */
public class AutoLoginSubscriber<T> extends Subscriber<AuthToken> {

    private AuthToken token;
    private IRepository repository;

    public AuthToken getToken() {
        return token;
    }

    public AutoLoginSubscriber(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(AuthToken authToken) {

        this.token = authToken;
        repository.updateAuthToken(this.token);
    }
}
