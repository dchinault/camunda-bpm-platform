package com.camunda.fox.cycle.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camunda.fox.cycle.security.IdentityHolder;
import com.camunda.fox.security.UserIdentity;
import com.camunda.fox.security.web.SecurityFilter;

/**
 * Sets the user identity available from {@link IdentityHolder#getIdentity()}
 */
public class IdentityHolderFilter implements Filter {

  public void init(FilterConfig fConfig) throws ServletException {
    
  }
  
  public void destroy() {
    
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    setIdentity((HttpServletRequest) request, (HttpServletResponse) response);
    chain.doFilter(request, response);
  }


  private void setIdentity(HttpServletRequest request, HttpServletResponse response) {
    IdentityHolder.setIdentity((UserIdentity) request.getSession().getAttribute(SecurityFilter.IDENTITY_SESSION_KEY));
  }
}
