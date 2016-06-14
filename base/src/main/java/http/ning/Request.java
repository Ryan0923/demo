package http.ning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HTTP请求
 * <p/>
 * <br>==========================
 * <br> 公司：优视科技
 * <br> 开发：梁文刚
 * <br> 版本：1.0
 * <br> 创建时间：2012-9-17
 * <br>==========================
 */
public class Request {

    public String url = "";
    private Map<String, String> headers = new HashMap<String, String>();
    private List<com.ning.http.client.Cookie> cookies = new ArrayList<com.ning.http.client.Cookie>();
    private Map<String, String> params = new HashMap<String, String>();
    private boolean useRawUrl = false;
    private byte[] body = new byte[0];


    public Request(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public List<com.ning.http.client.Cookie> getClientCookies() {
        return cookies;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public byte[] getBody() {
        return body;
    }

    /**
     * 设置Header
     */
    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    /**
     * 设置Cookie
     */
    public void addCookie(Cookie cookie) {
        cookies.add(cookie.getClientCookie());
    }

    /**
     * 设置POST参数
     */
    public void addParam(String name, String value) {
        params.put(name, value);
    }

    /**
     * 设置url
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 替换Header容器
     *
     * @param headers
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * 替换Cookie容器
     *
     * @param cookies
     */
    public void setCookies(List<com.ning.http.client.Cookie> cookies) {
        this.cookies = cookies;
    }

    /**
     * 替换Params容器
     *
     * @param params
     */
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    /**
     * 设置字节流byte[]
     * <br>只在POST下有效
     * <br> 必须设置 addHeader("Content-Length", String.valueOf(body.length));
     * <br>使用setBody(), addParam() 和 setParams()将失效
     *
     * @param body
     */
    public void setBody(byte[] body) {
        this.body = body;
    }

    public boolean isUseRawUrl() {
        return useRawUrl;
    }

    public void setUseRawUrl(boolean useRawUrl) {
        this.useRawUrl = useRawUrl;
    }

}