package http.ning;

/**
 * HTTP Cookie
 * <p/>
 * <br>==========================
 * <br> 公司：优视科技
 * <br> 开发：梁文刚
 * <br> 版本：1.0
 * <br> 创建时间：2012-9-17
 * <br>==========================
 */
public class Cookie {

    private com.ning.http.client.Cookie cookie;
    private boolean secure;

    public com.ning.http.client.Cookie getClientCookie() {
        return cookie;
    }

    public Cookie(com.ning.http.client.Cookie cookie) {
        this.cookie = cookie;
    }

    public Cookie(String domain, String name, String value, String path, int maxAge, boolean secure) {
        cookie = new com.ning.http.client.Cookie(domain, name, value, path, maxAge, secure);
        this.secure = secure;
    }

    @Override
    public String toString() {
        if (cookie == null) {
            return "Cookie: null";
        }
        return String.format("Cookie: domain=%s, name=%s, value=%s, path=%s, maxAge=%d, secure=%s",
                cookie.getDomain(),
                cookie.getName(),
                cookie.getValue(),
                cookie.getPath(),
                cookie.getMaxAge(),
                secure);
    }
}
