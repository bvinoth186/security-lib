package edu.uiuc.ncsa.security.oauth_2_0.server.claims;

import edu.uiuc.ncsa.security.delegation.server.ServiceTransaction;
import edu.uiuc.ncsa.security.oauth_2_0.UserInfo;
import edu.uiuc.ncsa.security.oauth_2_0.server.UnsupportedScopeException;
import edu.uiuc.ncsa.security.util.functor.parser.Script;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * This is charged with modelling the source for sets of claims. Note that the contract
 * of the standard implementation is to
 * have a no argument constructor that has a JSON object injected as the configuration.
 * <p>Created by Jeff Gaynor<br>
 * on 8/17/15 at  2:28 PM
 */
public interface ClaimSource {
    /**
     * This passes in a {@link JSONObject} that is in turn used to configure the source. It is up to the implementaton
     * to make sense of this.
     *
     * @param configuration
     */
    public void setConfiguration(ClaimSourceConfiguration configuration);
    public ClaimSourceConfiguration  getConfiguration();
    public boolean hasConfiguration();

    /**
     * A {@link UserInfo} object and the current service transaction are supplied. The contract is that
     * this handler will receive a claims object with standard information in place for
     * the request, but may then populate a claims object and return it. It is up to the source to
     * run the pre and post processors before actually invoking the claims.
     *
     * @param claims
     * @param transaction
     * @return
     * @throws UnsupportedScopeException
     */
    public JSONObject process(JSONObject claims, ServiceTransaction transaction) throws UnsupportedScopeException;

    // Resolves OAUTH-199, pass in servlet request to the claim source.
    public JSONObject process(JSONObject claims, HttpServletRequest request, ServiceTransaction transaction) throws UnsupportedScopeException;

    /**
     * Set the scopes for this source.
     * @param scopes
     */
    public void setScopes(Collection<String> scopes);

    /**
     * A list of scopes that this source supports. Any scope that is not recognized by this source should
     * be rejected.
     *
     * @return
     */
    public Collection<String> getScopes();

    /**
     * in order to support server discovery, every plugin must enumerate whatever claims it may
     * serve. This is not a guarantee that all of these claims will be delivered, just that they
     * might be.
     *
     * @return
     */
    public Collection<String> getClaims();

    public boolean isEnabled();

    /**
     * Whether to run this during the authorization phase or not. That means it will either run in the authorization servlet
     * or, if there is an external authorization application (e.g. Shibboleth) it will be invoked when the transaction has been created.
     * The other option is to be invoked immediately before the access token is issued.
     *
     * @return
     */
    public boolean isRunAtAuthorization();

    /**
     * This is the preprocessor <b>after</b> it has run. It is not available until execution time since it has to be
     * constructed on the fly from the current state of the claims.
     * @return
     */
   public Script getPreProcessor();

    /**
     * See comment in {@link #getPreProcessor()}.
     * @return
     */
    public Script getPostProcessor();

}
