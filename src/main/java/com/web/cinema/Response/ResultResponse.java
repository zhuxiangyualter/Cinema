package com.web.eduplatform.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * Description:
 * 响应实体
 *
 * @author am
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ResultResponse<T> implements Serializable {

    /**
     * 时间戳
     */
    protected final Instant timestamp = Instant.now();

    /**
     * 数据
     */
    protected T data;

    /**
     * 响应码
     */
    protected Integer code;

    /**
     * http响应状态码
     */
    protected Integer status;

    /**
     * 信息
     */
    protected String message;
    /**
     * 是否执行成功
     */
    protected boolean success;

    public static <T> ResultResponse<T> internalError(String message) {
        return internalError(null, message);
    }

    public static <T> ResultResponse<T> internalError(T data, String message) {
        return internalError(data,ResponseCode.ERROR_SERVICE, message);
    }


    /**
     * 创建一个OK的响应实体
     *
     * @param data 数据
     * @return ResultResponse
     */
    public static <T> ResultResponse<T> ok(T data) {
        return ok(data, "ResponseStr.SUCCESS_DEFAULT");
    }

    /**
     * 创建一个OK的响应实体
     *
     * @param data    数据
     * @param message 消息
     * @return ResultResponse
     */
    public static <T> ResultResponse<T> ok(T data, String message) {
        return ok(data, ResponseCode.SUCCESS, message);
    }

    /**
     * 创建一个OK的响应实体
     *
     * @param data    数据
     * @param code    自定义状态码
     * @param message 信息
     * @return 响应
     */
    public static <T> ResultResponse<T> ok(T data, ResponseCode code, String message) {
        return new ResultResponse<>(data, code.getCode(), HttpStatus.OK.value(), message, true);
    }

    /**
     * 创建一个OK的响应实体
     *
     * @param message 消息
     * @return ResultResponse
     */
    public static <T> ResultResponse<T> ok(String message) {
        return ok(null, message);
    }

    /**
     * 创建一个notOk响应实体
     */
    public static <T> ResultResponse<T> notOk() {
        return notOk(null," ResponseStr.NOT_SUCCESS_DEFAULT");
    }

    /**
     * 创建一个notOk响应实体
     *
     * @param message 消息
     */
    public static <T> ResultResponse<T> notOk(String message) {
        return notOk(null, message);
    }

    /**
     * 创建一个notOk响应实体
     *
     * @param data 数据
     */
    public static <T> ResultResponse<T> notOk(T data) {
        return notOk(data, "ResponseStr.NOT_SUCCESS_DEFAULT");
    }

    /**
     * 创建一个notOk响应实体
     *
     * @param data 数据
     */
    public static <T> ResultResponse<T> notOk(T data, String message) {
        return new ResultResponse<>(data, ResponseCode.NOT_SUCCESS.getCode(), HttpStatus.NO_CONTENT.value(), message, false);
    }

    /**
     * 创建一个OK的响应实体
     *
     * @return ResultResponse
     */
    public static <T> ResultResponse<T> ok() {
        return ok(null, "ResponseStr.SUCCESS_DEFAULT");
    }

    public static <T> ResultResponse<T> internalError(T data, ResponseCode code, String message) {
        return error(data, code, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public boolean isOk() {
        return Objects.equals(this.code, ResponseCode.SUCCESS.getCode());
    }

    public boolean isNotOk() {
        return !isOk();
    }

    /**
     * 创建一个错误响应实体
     *
     * @param data    数据
     * @param message 信息
     * @param code    响应码
     * @param status  http响应状态码
     * @return ResultResponse
     */
    public static <T> ResultResponse<T> error(T data, ResponseCode code, HttpStatus status, String message) {
        return new ResultResponse<>(data, code.getCode(), status.value(), message, false);
    }

    public static <T> ResultResponse<T> badRequest(String message) {
        return badRequest(null, ResponseCode.ERROR_ILLEGAL_ARGUMENTS, message);
    }

    public static <T> ResultResponse<T> badRequest(T data, ResponseCode code, String message) {
        return error(data, code, HttpStatus.BAD_REQUEST, message);
    }

    public static <T> ResultResponse<T> badRequest(T data, String message) {
        return badRequest(data, ResponseCode.ERROR_ILLEGAL_ARGUMENTS, message);
    }

    public static <T> ResultResponse<T> badRequest(ResponseCode code, String message) {
        return badRequest(null, code, message);
    }

    public static <T> ResultResponse<T> unauthorized() {
        return error(null, ResponseCode.ERROR_UNAUTHORIZED, HttpStatus.UNAUTHORIZED, "ResponseStr.ERROR_UNAUTHORIZED");
    }

    public static <E> ResultResponse<String> resolveEntitySave(E entity) {
        if (entity == null) {
            return badRequest("出现未知错误，保存失败");
        } else {
            return ok();
        }
    }

    public static ResultResponse<String> unsupportedHttpMethod(String method) {
        return badRequest("不支持的HTTP请求方法: " + method);
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
