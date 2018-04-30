package edu.uiuc.ncsa.security.oauth_2_0.server.config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * This will read the configuration. It is meant to be used by the {@link ClientConfigurationFactory}
 * to modularize operations on the JSON.
 *
 * <p>Created by Jeff Gaynor<br>
 * on 8/30/17 at  3:37 PM
 */
public class ClientConfigurationUtil {
    public static final String RUNTIME_LOGIC_KEY = "runtime";
    public static void setRuntime(JSONObject config, JSONArray runtime){
             config.put(RUNTIME_LOGIC_KEY, runtime);
      }

      public static JSONArray getRuntime(JSONObject config){
          if(config.containsKey(RUNTIME_LOGIC_KEY)){
              Object obj = config.get(RUNTIME_LOGIC_KEY);
              if(obj instanceof JSONArray){
                  return (JSONArray) obj;
              }
          }
          return new JSONArray();
      }


}
