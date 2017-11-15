package com.summ.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jygj_7500 on 17/11/13.
 */
@Component
public class AccessFilter implements Filter{

    private String encoding = null;

    public void  destroy(){
        encoding = null;
    }

    public AccessFilter() {

    }

    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String id = request.getParameter("id");

        System.out.println("进入过滤器》》》》》》》》》");

        if(id == null){
            String outJson = "{\"code\":\"101\",\"msg\":\"尚未登录\"}";
            httpResponse.getOutputStream().write(outJson.getBytes("UTF-8"));
            return;
        }

//        AdminInfo adminInfo = null;
//        try {
//            adminInfo = adminService.verify(token);
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("get admin info error by token >>>> " + e.getMessage());
//        }
//
//        if (adminInfo == null || adminInfo.isExist() == false) {
//            String outJson = "{\"code\":\"101\",\"msg\":\"尚未登录\"}";
//            httpResponse.getOutputStream().write(outJson.getBytes("UTF-8"));
//            return;
//        }
//
//        User admin = new User();
//        admin.setId(adminInfo.getId());
//        admin.setUsername(adminInfo.getName());
//        admin.setRealname(adminInfo.getRealName());
//        admin.setUserLevel(adminInfo.getUserLevel());
//        admin.setLevelName(adminInfo.getLevelName());
//
//        request.setAttribute("admin", admin);
//        logger.error("get admin info success by token >>>> " + admin);

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException{
        this.encoding = filterConfig.getInitParameter("encoding");

    }
}
