package com.alirezaafkar.json.requester;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Alireza Afkar on 12/11/15 AD.
 */
public class Requester {
    private static String sEncoding;
    private static String sGeneralParam;
    private static Integer sRetry, sTimeOut;
    private static RequestQueue sRequestQueue;
    private static Map<String, String> sHeader;

    public static void init(Config config) {
        sRetry = config.getRetry();
        sHeader = config.getHeader();
        sTimeOut = config.getTimeOut();
        sEncoding = config.getEncoding();
        sGeneralParam = config.generalParam;
        sRequestQueue = config.getRequestQueue();
    }

    public static RequestQueue getRequestQueue() {
        return sRequestQueue;
    }

    public static void setRequestQueue(RequestQueue queue) {
        sRequestQueue = queue;
    }

    public static Map<String, String> getHeader() {
        return sHeader;
    }

    public static void setHeader(Map<String, String> header) {
        sHeader = header;
    }

    public static Integer getTimeOut() {
        return sTimeOut;
    }

    public static void setTimeOut(Integer timeOut) {
        sTimeOut = timeOut;
    }

    public static String getEncoding() {
        return sEncoding;
    }

    public static void setEncoding(String encoding) {
        sEncoding = encoding;
    }

    public static String getGeneralParam() {
        return isEmpty(sGeneralParam) ? null : "%s" + sGeneralParam;
    }

    public static void setGeneralParam(String generalParam) {
        sGeneralParam = generalParam;
    }

    public static Integer getRetry() {
        return sRetry;
    }

    public static void setRetry(Integer retry) {
        sRetry = retry;
    }


    public static class Config {
        private Integer retry, timeOut;
        private RequestQueue requestQueue;
        private Map<String, String> header;
        private String generalParam, encoding = "UTF-8";

        public Config(Context context) {
            this.header = new HashMap<>();
            this.requestQueue = Volley.newRequestQueue(context);
        }

        public String getGeneralParam() {
            return generalParam;
        }

        public void setGeneralParam(String generalParam) {
            this.generalParam = generalParam;
        }

        public Integer getTimeOut() {
            return timeOut;
        }

        public void setTimeOut(Integer timeOut) {
            this.timeOut = timeOut;
        }

        public String getEncoding() {
            return encoding;
        }

        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        public RequestQueue getRequestQueue() {
            return requestQueue;
        }

        public void setRequestQueue(RequestQueue requestQueue) {
            this.requestQueue = requestQueue;
        }

        public Map<String, String> getHeader() {
            return header;
        }

        public void setHeader(Map<String, String> header) {
            this.header = header;
        }

        public Integer getRetry() {
            return retry;
        }

        public void setRetry(Integer retry) {
            this.retry = retry;
        }
    }
}
