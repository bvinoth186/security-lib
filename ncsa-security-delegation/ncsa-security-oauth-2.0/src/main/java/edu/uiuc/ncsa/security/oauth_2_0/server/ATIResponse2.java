package edu.uiuc.ncsa.security.oauth_2_0.server;

import edu.uiuc.ncsa.security.delegation.server.request.ATResponse;
import edu.uiuc.ncsa.security.delegation.token.AccessToken;
import edu.uiuc.ncsa.security.delegation.token.RefreshToken;
import edu.uiuc.ncsa.security.delegation.token.Verifier;

/**
 * OIDC server response for request for access token
 * <p>Created by Jeff Gaynor<br>
 * on 6/4/13 at  5:10 PM
 */
public class ATIResponse2 extends IDTokenResponse implements ATResponse {

    public ATIResponse2(AccessToken accessToken, RefreshToken refreshToken) {
        super(accessToken,refreshToken);
    }





    Verifier verifier;


    /**
     * Getter for verifier
     * This shouldn't be called in OIDC, but it's here temporarily
     *
     * @return verifier (should be null)
     */
    public Verifier getVerifier() {
        return verifier;
    }


    /**
     * Setter for verifier
     * This needs to go away since OIDC doesn't use verifiers
     *
     * @param verifier Verifier object (probably null)
     */
    public void setVerifier(Verifier verifier) {
        this.verifier = verifier;
    }



}
