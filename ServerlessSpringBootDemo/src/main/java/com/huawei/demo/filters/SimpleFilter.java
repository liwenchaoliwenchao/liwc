package com.huawei.demo.filters;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;

@Order(1)
@Component
@WebFilter("/*")
public class SimpleFilter{
    private static Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

    public boolean doFilter() {
        logger.warn("entering simple filter");
        return true;
    }
}
