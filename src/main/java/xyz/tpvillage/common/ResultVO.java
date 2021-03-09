package xyz.tpvillage.common;

import lombok.Data;

/**
 * @author: 朱兴平
 * @date: 2020/11/8
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String message;
    private T data;

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVO(T data) {
        this(1, "success", data);
    }

    /**
     * 响应成功数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultVO ok(T data) {
        ResultVO<T> resultVO = new ResultVO<>(data);
        return resultVO;
    }

    /**
     * 响应失败数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultVO failed(T data) {
        ResultVO<T> resultVO = new ResultVO<>(0, "failed", data);
        return resultVO;
    }
}