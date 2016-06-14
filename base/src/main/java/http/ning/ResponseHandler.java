package http.ning;

/**
*
* 异步请求的Response回调处理
*
* <br>==========================
* <br> 公司：优视科技
* <br> 开发：梁文刚
* <br> 版本：1.0
* <br> 创建时间：2012-10-25
* <br>==========================
*/
public abstract class ResponseHandler {
	public abstract  void handle(Response response) throws Exception;
}
