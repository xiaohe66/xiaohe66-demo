package com.xiaohe66.demo.mybatis.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.Properties;

/**
 * 该插件会被所有的 update、insert、delete方法执行（注意不是sql中的，而是xml或注解的，如：@Update）
 *
 * @author xiaohe
 * @since 2022.03.23 16:38
 */
@Intercepts({
        /*
        该注解用于指定拦截的方法，有以下4类，每个类中又有不同的方法
        Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
        ParameterHandler (getParameterObject, setParameters)
        ResultSetHandler (handleResultSets, handleOutputParameters)
        StatementHandler (prepare, parameterize, batch, update, query)
         */
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class})
})
@Slf4j
public class UpdateLogPlugin implements Interceptor {


    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("执行插件逻辑 : {}", properties);

        // 拦截不同的方法时，通过 Invocation 拿到的参数也是不一样的
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        String sql = handler.getBoundSql().getSql();

        Object params = handler.getParameterHandler().getParameterObject();
        log.info("打印执行 - sql : {}, params : {}", sql, params);

        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
