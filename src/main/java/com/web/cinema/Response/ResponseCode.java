package com.web.eduplatform.Response;


/**
 * Description:
 * 响应码枚举, 封装一些响应状态码, 区别于 {@link org.springframework.http.HttpStatus HttpStatus}
 *
 * @author am
 */
public enum ResponseCode {

    /**
     * 成功, 当服务器成功响应时返回, 如登录成功, 查询成功等
     */
    SUCCESS(0),
    /**
     * 未成功
     */
    NOT_SUCCESS(-10),
    /**
     * 服务器错误, 一般出现未知的, 没预料到的错误时返回
     */
    ERROR_SERVICE(-1),
    /**
     * 非法参数, 请求时传递服务器不能接受的参数是返回
     */
    ERROR_ILLEGAL_ARGUMENTS(1),
    /**
     * 登录的用户不存在
     */
    ERROR_ACCOUNT_NOT_EXIST(1000),
    /**
     * 没有授权, 当用户强行访问无权访问的页面时返回
     */
    ERROR_UNAUTHORIZED(1001),
    /**
     * 账户被锁定
     */
    ERROR_ACCOUNT_LOCKED(1002),
    /**
     * 账户被禁用
     */
    ERROR_ACCOUNT_DISABLED(1003),
    /**
     * 账户存在, 在注册过程中用户重复时返回
     * 此系统暂不开放注册, 因此暂不会返回该值
     */
    ERROR_ACCOUNT_EXIST(1004),
    /**
     * 账户密码错误尝试次数过多
     */
    ERROR_ACCOUNT_EXCESSIVE_ATTEMPTS(1005),
    /**
     * 密码错误, 在登录过程中密码错误时返回
     */
    ERROR_WRONG_PASSWORD(1006),
    /**
     * 验证码错误, 在找回密码时, 邮箱验证码填写错误时返回
     */
    ERROR_CODE_VERIFY(1007),
    /**
     * 验证码发送失败, 在找回密码时, 邮箱验证码发送失败, 可能是由于邮箱服务器原因导致
     */
    ERROR_CODE_SEND(1008),
    /**
     * 登录用户名为空
     */
    ERROR_USERNAME_FORMAT(1010),
    /**
     * 没有用户登出
     */
    ERROR_NO_USER_TO_LOGOUT(1011),

    /**
     * 学生存在
     */
    ERROR_STUDENT_EXIST(2000),
    /**
     * 教师存在
     */
    ERROR_TEACHER_EXIST(2001),
    /**
     * 班级存在
     */
    ERROR_CLASS_EXIST(2002),
    /**
     * 宿舍存在
     */
    ERROR_DORMITORY_EXIST(2003),
    /**
     * 学院存在
     */
    ERROR_ACADEMY_EXIST(2004),
    /**
     * 专业存在
     */
    ERROR_MAJOR_EXIST(2005),
    /**
     * 职务存在
     */
    ERROR_JOB_EXIST(2006),
    /**
     * 组织存在
     */
    ERROR_ORG_EXIST(2007),
    /**
     * 用户存在
     */
    ERROR_USER_EXIST(2008),
    /**
     * 创建学生失败
     */
    ERROR_CREATE_STUDENT(3001),
    /**
     * 创建学生失败
     */
    ERROR_CREATE_TEACHER(3002),
    /**
     * 创建教师失败
     */
    ERROR_CREATE_CLASS(3003),
    /**
     * 要查找的学生不存在
     */
    ERROR_STUDENT_NOT_FOUND(4000),

    ERROR_AWARD_NOT_FOUND(4001),
    ERROR_SKILL_NOT_FOUND(4002),
    ERROR_DORMITORY_NOT_FOUND(4004),
    ERROR_GRANT_NOT_FOUND(4005),
    ERROR_JOB_NOT_FOUND(4006),
    ERROR_LOAN_NOT_FOUND(4007),
    ERROR_ACADEMY_NOT_FOUND(40081),
    ERROR_MAJOR_NOT_FOUND(40082),
    ERROR_ORG_NOT_FOUND(400083),
    ERROR_PART_TIME_POST_NOT_FOUND(409),
    ERROR_TEACHER_NOT_FOUND(4010),
    ERROR_USER_NOT_FOUND(4011),
    ERROR_CHANNEL_NOT_FOUND(4012),
    ERROR_CONTENT_NOT_FOUND(4013),

    ERROR_UNKNOWN_NOT_FOUND(4099),
    /**
     * 要查找的班级不存在
     */
    ERROR_CLASS_NOT_FOUND(4003),

    /**
     * 没有合适的宿舍
     */
    ERROR_NO_SUITABLE_DORMITORY(4010),

    /**
     * 更新学生信息失败
     */
    ERROR_UPDATE_STUDENT(5001),
    /**
     * 更新教师信息失败
     */
    ERROR_UPDATE_TEACHER(5002),
    /**
     * 更新学生信息失败
     */
    ERROR_UPDATE_CLASS(5003),

    /**
     * 更新宿舍失败
     */
    ERROR_DORMITORY_UPDATE(5010),
    /**
     * 更新宿舍失败 - 宿舍已满
     */
    ERROR_DORMITORY_FULL(5011),
    /**
     * 更新宿舍失败 - 宿舍为空
     */
    ERROR_DORMITORY_EMPTY(5012),
    /**
     * 删除学生信息失败
     */
    ERROR_DELETE_STUDENT(6001),
    /**
     * 删除教师失败
     */
    ERROR_DELETE_TEACHER(6002),
    /**
     * 删除班级失败
     */
    ERROR_DELETE_CLASS(6003),
    /**
     * 上传文件为空
     */
    ERROR_UPLOAD_FILE_NULL(10086),
    /**
     * 用户类型不正确
     */
    ERROR_USER_TYPE(10087);

    private Integer code;

    ResponseCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
