package com.summ.filter;

import com.summ.mapper.JAdminMapper;
import com.summ.model.JAdmin;
import com.summ.utils.StringUtil;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jygj_7500 on 17/11/13.
 */
@Component
public class AccessFilter implements Filter {

    @Autowired
    private JAdminMapper jAdminMapper;

    private String encoding = null;

    public void destroy() {
        encoding = null;
    }

    public AccessFilter() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        HttpServletRequest req = (HttpServletRequest) request;
//        ServletContext servletContext = req.getSession().getServletContext();
//        XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        if (cxt != null && cxt.getBean("jAdminMapper") != null && jAdminMapper == null){
//            jAdminMapper = (JAdminMapper) cxt.getBean("jAdminMapper");
//        }

        int id;
        if (request.getParameter("id") != null) {
            id = StringUtil.parseInt(request.getParameter("id"));
            JAdmin jAdmin = jAdminMapper.getAdminById(id);
            request.setAttribute("admin", jAdmin);
        } else {
            id = 0;
        }


        System.out.println("进入过滤器》》》》》》》》》");

        if (id == 0) {
            String outJson = "{\"code\":\"101\",\"msg\":\"尚未登录\"}";
            httpResponse.getOutputStream().write(outJson.getBytes("UTF-8"));
            return;
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        ServletContext context = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        jAdminMapper = ctx.getBean(JAdminMapper.class);

    }
}
