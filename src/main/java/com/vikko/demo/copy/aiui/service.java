package com.vikko.demo.copy.aiui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vikko
 * @date 2020/6/18 19:15
 */
public interface service {

    HttpServletResponse aiuiGet(HttpServletRequest request, HttpServletResponse response) throws Exception;

    HttpServletResponse aiuiPost(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
