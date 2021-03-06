package org.dromara.hodor.remoting.api.message;

import java.io.Serializable;

/**
 * response body
 *
 * @author tomgs
 * @since 2020/9/15
 */
public interface ResponseBody extends Serializable {

    /**
     * 请求id
     * @return request id
     */
    Long getRequestId();

    /**
     * 请求响应code
     * @return code
     */
    int getCode();

    /**
     * 请求响应信息
     * @return msg
     */
    String getMsg();

    /**
     * 响应数据
     *
     * @return data
     */
    Object getData();

}
