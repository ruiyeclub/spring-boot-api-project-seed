package com.company.project.common.result;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 平台通用返回结果
 * @author LErry.li
 * Date: 2018-06-15
 * Time: 14:41
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result implements Serializable{
    private static final long serialVersionUID = 874200365941306385L;

    private Integer code;

    private String message;

    private Object data;

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static Result failure(String message) {
        Result result = new Result();
        result.setCode(ResultCode.PARAM_IS_INVALID.code());
        result.setMessage(message);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.message = code.message();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
