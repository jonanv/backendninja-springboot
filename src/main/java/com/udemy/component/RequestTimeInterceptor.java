package com.udemy.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.udemy.repository.LogRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    // Primero se ejecuta
    
    /** 
     * @param request
     * @param response
     * @param handler
     * @return 
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }
    
    // Segundo se ejecuta
    
    /** 
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return 
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        String url = request.getRequestURL().toString();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (auth != null && auth.isAuthenticated()) {
            username = auth.getName();
        }
        com.udemy.entity.Log log = new com.udemy.entity.Log(new Date(), auth.getDetails().toString(), username, url);
        logRepository.save(log);

        LOG.info("Url to: '" + url + "' in: '" + (System.currentTimeMillis() - startTime) + "ms'");
    }

}
