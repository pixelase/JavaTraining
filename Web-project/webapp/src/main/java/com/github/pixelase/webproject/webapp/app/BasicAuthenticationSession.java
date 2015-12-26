package com.github.pixelase.webproject.webapp.app;

import com.github.pixelase.webproject.dataaccess.model.Account;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class BasicAuthenticationSession extends AuthenticatedWebSession {

    public static final MetaDataKey<Account> KEY = new MetaDataKey<Account>() {
    };

    public BasicAuthenticationSession(Request request) {
        super(request);
    }

    @Override
    protected boolean authenticate(String login, String cryptedPassword) {
        Account account = getMetaData(KEY);

        return login.equals(account.getLogin()) && cryptedPassword.equals(account.getCryptedPassword());
    }

    @Override
    public Roles getRoles() {
        return new Roles(getMetaData(KEY).getRoles().toArray(new String[0]));
    }

}