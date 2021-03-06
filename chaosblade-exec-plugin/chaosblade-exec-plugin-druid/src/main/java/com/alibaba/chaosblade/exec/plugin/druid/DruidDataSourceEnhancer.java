package com.alibaba.chaosblade.exec.plugin.druid;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import com.alibaba.chaosblade.exec.common.aop.BeforeEnhancer;
import com.alibaba.chaosblade.exec.common.aop.EnhancerModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Changjun Xiao
 */
public class DruidDataSourceEnhancer extends BeforeEnhancer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DruidDataSourceEnhancer.class);

    @Override
    public EnhancerModel doBeforeAdvice(ClassLoader classLoader, String className, Object object, Method method,
                                        Object[] methodArguments) throws Exception {
        if (object != null && DataSource.class.isInstance(object)) {
            DruidConnectionPoolFullExecutor.INSTANCE.setDataSource(object);
        }
        return null;
    }
}
