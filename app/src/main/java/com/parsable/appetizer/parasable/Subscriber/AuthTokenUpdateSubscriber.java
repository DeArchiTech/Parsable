package com.parsable.appetizer.parasable.Subscriber;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.User;
import com.parsable.appetizer.parasable.Repository.IRepository;

import rx.Subscriber;

/**
 * Created by Davix on 3/11/16.
 */
public class AuthTokenUpdateSubscriber extends Subscriber<AuthToken>{

    IRepository repository;

    public AuthTokenUpdateSubscriber(IRepository repository) {
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

        this.repository.updateAuthToken(authToken);
    }
}
