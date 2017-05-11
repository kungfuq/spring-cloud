package com.sky.cloud.commons;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhoushengqiang on 17/5/11.
 */
public class CommonUtil {

    /**
     * 获取客户端IP地址.
     *
     * @param request request请求
     * @return ip地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("Cdn-Src-Ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (StringUtils.hasText(ip)) {
            return StringUtils.tokenizeToStringArray(ip, ",")[0];
        }
        return "";
    }

}
