package io.github.anandpc.moviesfeed;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkClass {

    static final String KEY_TITLE = "title";
    static final String KEY_URL = "url";
    static final String KEY_DESC = "description";

    void getDataFeed() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.cinemablend.com/")
                .build();

        ApiCall apiCall = retrofit.create(ApiCall.class);

        //  Response of Responsebody type
        Call<ResponseBody> responseBody = apiCall.getResponseBody();

        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    try {
                        String dataStr = response.body().string();
                        Log.i("data", dataStr);
                       Document doc =  getDomElement(dataStr);

                        NodeList nl = doc.getElementsByTagName(KEY_TITLE);



                        for (int i = 0; i < nl.getLength(); i++) {
                            String title = getValue(e, KEY_TITLE); // name child value
                            String url = getValue(e, KEY_URL); // cost child value
                            String description = getValue(e, KEY_DESC); // description child value
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.i("Fail", "In response but failed.");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("onFailure", "In onFailure");
            }
        });

        /*

        //  Response for Item type
        Call<Item> feed = apiCall.getData();
        feed.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item data = response.body();
                Log.i("success", "Succcess");
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.i("failed", "Failure");
            }
        });
*/
    }

    public Document getDomElement(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);

        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }
        // return DOM
        return doc;
    }

    public String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }

    public final String getElementValue( Node elem ) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}
