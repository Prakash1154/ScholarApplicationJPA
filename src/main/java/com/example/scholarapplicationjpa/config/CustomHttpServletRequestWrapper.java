package com.example.scholarapplicationjpa.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
  private String payload="";

  private static final Logger logger = LoggerFactory.getLogger(CustomHttpServletRequestWrapper.class.getName());

  public CustomHttpServletRequestWrapper(HttpServletRequest request) throws IOException
  {
    //Constructs a request object wrapping the given request.
    super(request);
    try {
      payload = request.getReader().lines()
          .collect(Collectors.joining(System.lineSeparator()));
    }
    catch (Exception e) {
      throw e;
    }
  }

  public String getBody(){
    return this.payload;
  }

  @Override
  public ServletInputStream getInputStream() throws IOException
  {
    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload.getBytes());
    return new ServletInputStream()
    {
      @Override
      public boolean isFinished() {
        return false;
      }

      @Override
      public boolean isReady() {
        return false;
      }

      @Override
      public void setReadListener(ReadListener readListener) {

      }

      public int read() throws IOException
      {
        return byteArrayInputStream.read();
      }
    };
  }
}