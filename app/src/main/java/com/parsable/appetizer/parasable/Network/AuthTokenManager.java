package com.parsable.appetizer.parasable.Network;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;

/**
 * Created by Davix on 3/10/16.
 */
public class AuthTokenManager implements IAuthTokenManager {

    @Override
    public boolean writeTokenToDisk(AuthToken token) {
        return false;
    }

    @Override
    public AuthToken readTokenFromDisk() {
        return null;
    }

    @Override
    public boolean eraseTokenFromDisk() {
        return false;
    }
}
