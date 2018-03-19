package com.kgcorner.Demo.BDD;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by admin on 3/16/2018.
 */
public class HttpUtilForTest {
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 400;

    public static Response sendGetRequest(String url, Map<String, String> header) throws NetworkException {
        HttpURLConnection connection = null;
        String response = null;
        URL restUrl = null;
        Response r = new Response();
        InputStream is = null;
        try {
            if (url.contains("\"")) {
                url = url.replace("\"", "");
            }
            restUrl = new URL(url);
            connection = (HttpURLConnection) restUrl.openConnection();
            connection.setRequestMethod("GET");
            if (header != null) {
                for (String key : header.keySet()) {
                    connection.setRequestProperty(key, header.get(key));
                }
            }
            is = new BufferedInputStream(connection.getInputStream());
            response = convertStreamToString(is);
            int code = connection.getResponseCode();
            r.setResponseCode(code);
            if (code >= ERROR_CODE) {
                throw new NetworkException(response);
            }
        } catch (MalformedURLException e) {
            throw new NetworkException(e.getLocalizedMessage());
        } catch (IOException e) {
            is = new BufferedInputStream(connection.getErrorStream());
            try {
                response = convertStreamToString(is);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            throw new NetworkException(e.getLocalizedMessage());
        }

        r.setResponseData(response);
        return r;
    }

    private static String convertStreamToString(InputStream is) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw e;
            }
        }

        return sb.toString();
    }

}



