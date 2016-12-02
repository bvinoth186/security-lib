package edu.uiuc.ncsa.security.oauth_2_0;

import edu.uiuc.ncsa.security.core.Identifier;
import edu.uiuc.ncsa.security.delegation.storage.Client;
import edu.uiuc.ncsa.security.oauth_2_0.server.LDAPConfiguration;

import java.util.Collection;

/**
 * OAuth2 Open ID connect protocol requires that sites register callback uris and that incoming requests
 * must include a callback that matches one of the registered ones.
 * <p>Created by Jeff Gaynor<br>
 * on 3/14/14 at  11:04 AM
 */
public class OA2Client extends Client {
    @Override
    public OA2Client clone() {
        OA2Client client = new OA2Client(getIdentifier());
        client.setName(getName());
        client.setHomeUri(getHomeUri());
        client.setErrorUri(getErrorUri());
        client.setEmail(getEmail());
        client.setProxyLimited(isProxyLimited());
        client.setRtLifetime(getRtLifetime());
        client.setCallbackURIs(getCallbackURIs());
        client.setCreationTS(getCreationTS());
        client.setSecret(getSecret());
        return client;
    }

    public OA2Client(Identifier identifier) {
        super(identifier);
    }

    public Collection<String> getCallbackURIs() {
        return callbackURIs;
    }

    public void setCallbackURIs(Collection<String> callbackURIs) {
        this.callbackURIs = callbackURIs;
    }

    Collection<String> callbackURIs;

    long rtLifetime = 0L;

    public long getRtLifetime() {
        return rtLifetime;
    }

    public void setRtLifetime(long rtLifetime) {
        this.rtLifetime = rtLifetime;
    }

    public boolean isRTLifetimeEnabled() {
        return rtLifetime != Long.MIN_VALUE;
    }

    public Collection<String> getScopes() {
        return scopes;
    }

    public void setScopes(Collection<String> scopes) {
        this.scopes = scopes;
    }

    Collection<String> scopes;

    public Collection<LDAPConfiguration> getLdaps() {
        return ldaps;
    }

    public void setLdaps(Collection<LDAPConfiguration> ldaps) {
        this.ldaps = ldaps;
    }

    Collection<LDAPConfiguration> ldaps;

    @Override
    public String toString(){
        String x = super.toString();
        x = x.substring(0,x.lastIndexOf("]"));
        x=x+"scopes="+ ((getScopes()==null)?"[]":getScopes().toString()) + ",";
         x=x+"callbacks=" + (getCallbackURIs()==null?"[]":getCallbackURIs().toString()) + ",";
        x=x+"refresh token lifetime=" + getRtLifetime();
        return x + "]";
    }
}
