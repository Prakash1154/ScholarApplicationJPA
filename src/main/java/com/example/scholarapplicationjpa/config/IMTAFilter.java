package com.example.scholarapplicationjpa.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class IMTAFilter implements Filter {

  private static final Logger logger = LoggerFactory.getLogger(IMTAFilter.class);

  @SneakyThrows
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    if(logger.isDebugEnabled()) {
      servletRequest = new CustomHttpServletRequestWrapper((HttpServletRequest) servletRequest);

      String payload = ((CustomHttpServletRequestWrapper) servletRequest).getBody();
      if (payload != null && !StringUtils.isEmpty(payload)) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(payload, Map.class);
        Map<String, Object> resultPayload = new HashMap<>();
        List<String> response = Arrays.asList("id", "number", "email", "abc");
        for (String s : response) {
          if (map.containsKey(s)) {
            resultPayload.put(s, map.get(s));
          }
        }
        servletRequest.setAttribute("payload", resultPayload);
      }
      filterChain.doFilter(servletRequest, servletResponse);
    }
    else {
      filterChain.doFilter(servletRequest,servletResponse);
    }
  }
}
