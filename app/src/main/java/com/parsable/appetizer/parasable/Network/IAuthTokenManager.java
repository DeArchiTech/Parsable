package com.parsable.appetizer.parasable.Network;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;

/**
 * Created by Davix on 3/10/16.
 */
//Persist AuthTokens in a way that is easy to retrieve and update
public interface IAuthTokenManager {

    public boolean writeTokenToDisk(AuthToken token);

    public AuthToken readTokenFromDisk();

    public boolean eraseTokenFromDisk();

}
