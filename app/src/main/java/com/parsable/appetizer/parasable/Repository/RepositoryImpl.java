package com.parsable.appetizer.parasable.Repository;

import com.parsable.appetizer.parasable.Model.NumData;
import com.parsable.appetizer.parasable.Model.TextData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import rx.Observable;

/**
 * Created by Davix on 3/8/16.
 */
public class RepositoryImpl implements IRepository{

    @NotNull
    @Override
    public Observable<List<TextData>> getTextData(boolean errored) {
        return null;
    }

    @NotNull
    @Override
    public Observable<List<NumData>> getNumData(boolean errored) {
        return null;
    }
}
