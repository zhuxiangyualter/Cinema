package com.web.eduplatform.Response;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */

import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * 创建响应体帮助类
 *
 * @author am
 */
public final class ResponseHelper {

    private ResponseHelper() {
    }

//    public static <E extends Entity, ID> ResponseEntity<ResultResponse<String>> resolveDelete(IService<E, ID> service,
//                                                                                              ID id) {
//        if (service.existsById(id)) {
//            return resolve(ResultResponse.internalError("出现未知错误，删除失败。"));
//        } else {
//            return resolve(ResultResponse.ok());
//        }
//    }
//    public static <E extends IService> ResponseEntity<ResultResponse<String>> resolveDelete(E service, Object id) {
//        if (service.getById((Serializable) id) == null) {
//            return resolve(ResultResponse.internalError("出现未知错误，删除失败。"));
//        } else {
//            return resolve(ResultResponse.ok());
//        }
//    }
    public static <T> ResponseEntity<ResultResponse<T>> resolve(ResultResponse<T> rawResponse) {
        return ResponseEntity.status(rawResponse.getStatus()).body(rawResponse);
    }

    /**
     * 无权限
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<ResultResponse<T>> noPermission() {
        return resolve(ResultResponse.internalError("您没有任何权限获取该数据！"));
    }

    /**
     * 返回错误响应
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<ResultResponse<String>> badRequest(String msg) {
        return resolve(ResultResponse.badRequest(msg));
    }

    /**
     * 直接返回ok响应
     */
    public static ResponseEntity<ResultResponse<String>> ok() {
        return resolve(ResultResponse.ok());
    }
}
