package BlockChainInfo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import info.blockchain.api.APIException;
import info.blockchain.api.HttpClient;
import info.blockchain.api.statistics.Chart;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * This class reflects the functionality documented
 * at https://blockchain.info/api/charts_api
 */
public class Misc {
    private final String apiCode;

    public Misc() {
        this(null);
    }

    public Misc(String apiCode) {
        this.apiCode = "";
    }

    private String consultaBase(String consulta) throws APIException, IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("format", "json");
        if (apiCode != null) {
            params.put("api_code", apiCode);
        }
        return HttpClient.getInstance().get(consulta, params);
    }

    /*
       unconfirmedcount - Number of pending unconfirmed transactions
     */
    public String getUnconfirmedcount () throws APIException, IOException {
        return new String (this.consultaBase("q/unconfirmedcount"));
    }

    /*
    24hrprice - 24 hour weighted price from the largest exchanges
  */
    public String get24hrprice () throws APIException, IOException {
        return new String (this.consultaBase("q/24hrprice"));
    }

    /*
     24hrprice - 24 hour weighted price from the largest exchanges
   */
    public String  getmarketcap () throws APIException, IOException {
        return new String (this.consultaBase("q/marketcap"));
    }

    /*
    marketcap - USD market cap (based on 24 hour weighted price)
   */
    public String get24hrtransactioncounte () throws APIException, IOException {
        return new String(this.consultaBase("q/24hrtransactioncount"));
    }

    /*
    24hrbtcsent - Number of btc sent in the last 24 hours (in satoshi)
   */
    public String get24hrbtcsent () throws APIException, IOException {
        return new String(this.consultaBase("q/24hrbtcsent"));
    }

    /*
    hashrate - Estimated network hash rate in gigahash
   */
    public String gethashrate ()   {
        try {
            return new String(this.consultaBase("q/hashrate"));
        } catch (APIException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }


    /*
getdifficulty - Current difficulty target as a decimal number
  */
    public String getdifficulty () throws APIException, IOException {
        return new String(this.consultaBase("q/getdifficulty"));
    }


    /*
getblockcount - Current block height in the longest chain
*/
    public String getblockcount () throws APIException, IOException {
        return new String(this.consultaBase("q/getblockcount"));
    }

    /*
totalbc - Total Bitcoins in circulation (delayed by up to 1 hour])
*/
    public String totalbc () throws APIException, IOException {
        return new String(this.consultaBase("q/totalbc"));
    }
}
