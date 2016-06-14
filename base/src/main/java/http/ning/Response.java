package http.ning;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * HTTP响应
 * <p/>
 * <br>==========================
 * <br> 公司：优视科技
 * <br> 开发：梁文刚
 * <br> 版本：1.0
 * <br> 创建时间：2012-9-17
 * <br>==========================
 */
public class Response {
    private com.ning.http.client.Response response;

    public Response(com.ning.http.client.Response response) {
        this.response = response;
    }

    /**
     * 响应状态码
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * 获取内容, 采用 UTF-8 编码
     *
     * @return
     * @throws IOException
     */
    public String getContent() throws IOException {
        return getContent("UTF-8");
    }

    /**
     * 获取内容
     *
     * @Param charset 编码
     */
    public String getContent(String charset) throws IOException {
        return response.getResponseBody(charset);
    }

    /**
     * 获取内容Stream
     *
     * @return
     * @throws IOException
     */
    public InputStream getContentAsStream() throws IOException {
        return response.getResponseBodyAsStream();
    }

    /**
     * 获取Header信息
     */
    public String getHeader(String name) {
        return response.getHeader(name);
    }

    /**
     * 获取Header列表信息
     */
    public List<String> getHeaders(String name) {
        return response.getHeaders(name);
    }

    /**
     * 获取Cookie信息
     */
    public Cookie getCookie(String name) {
        List<com.ning.http.client.Cookie> cookies = response.getCookies();
        for (com.ning.http.client.Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return new Cookie(cookie);
            }
        }
        return null;
    }

    public com.ning.http.client.Response getNingResponse() {
        return response;
    }
}