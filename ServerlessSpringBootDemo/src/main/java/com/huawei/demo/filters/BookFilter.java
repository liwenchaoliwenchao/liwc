package com.huawei.demo.filters;

import com.huawei.fgs.ext.context.filter.FGSFilter;

import com.huawei.services.runtime.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;


@Order(2)
@Component
@WebFilter("/*")
public class BookFilter implements FGSFilter {
    private static Logger logger = LoggerFactory.getLogger(BookFilter.class);

    @Override
    public boolean doFilter(APIGTriggerEvent apigTriggerEvent, com.huawei.services.runtime.Context context, APIGTriggerResponse apigTriggerResponse) {
        logger.warn("entering book filter");
        return true;
    }


}
