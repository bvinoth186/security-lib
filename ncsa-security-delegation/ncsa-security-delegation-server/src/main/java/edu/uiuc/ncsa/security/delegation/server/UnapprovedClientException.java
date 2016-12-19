package edu.uiuc.ncsa.security.delegation.server;

import edu.uiuc.ncsa.security.core.exceptions.GeneralException;
import edu.uiuc.ncsa.security.delegation.storage.BaseClient;
import edu.uiuc.ncsa.security.delegation.storage.Client;

/**
 * Thrown when a client that has not been approved attempts a request on the server.
 * <p>Created by Jeff Gaynor<br>
 * on 3/27/12 at  3:03 PM
 */
public class UnapprovedClientException extends GeneralException {
    BaseClient client;

    public BaseClient getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public UnapprovedClientException(String message, BaseClient client) {
        super(message);
        this.client = client;
    }

}
