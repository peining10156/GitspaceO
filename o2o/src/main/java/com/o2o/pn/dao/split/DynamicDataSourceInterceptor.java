//package com.o2o.pn.dao.split;
//
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.mapping.SqlCommandType;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//import org.slf4j.LoggerFactory;
//import org.springframework.transaction.support.TransactionSynchronizationManager;
//
//import java.util.Locale;
//import java.util.Properties;
//
///*
//*
//* Mybatis 拦截器 拦截SQL语句
//* */
//@Intercepts({@Signature(type =Executor.class,method = "update",args = {MappedStatement.class,Object.class}),
//@Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})
//public class DynamicDataSourceInterceptor implements Interceptor {
//    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
//    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";
//    @Override
//    /*
//    * 主要拦截方法
//    * */
//    public Object intercept(Invocation invocation) throws Throwable {
//
//
//        boolean synchronizationActive =TransactionSynchronizationManager.isActualTransactionActive();
//        Object[] objects = invocation.getArgs();
//        MappedStatement ms = (MappedStatement) objects[0];
//        String lookUpKEY= DynamicDataSourceHolder.DB_MASTER;
//        if (synchronizationActive !=true){
//
//            //读方法
//            if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)){
//                //selectKey为自增ID查询主键（SELECT LAST_INSERT_ID())方法，使用主库
//                if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
//                    lookUpKEY = DynamicDataSourceHolder.DB_MASTER;
//                }else{
//                    BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
//                    String sql = boundSql.getSql().toLowerCase(Locale.CANADA).replaceAll("[\\t\\n\\r]"," ");
//                    if (sql.matches(REGEX)){
//                        lookUpKEY = DynamicDataSourceHolder.DB_MASTER;
//                    }else{
//                        lookUpKEY = DynamicDataSourceHolder.DB_SLAVE;
//                    }
//                }
//            }
//        }else {
//            lookUpKEY = DynamicDataSourceHolder.DB_MASTER;
//        }
//        logger.debug("设置方法[{}]use[{}]Strategy,SqlCommanType[{}]..",ms.getId(),lookUpKEY,
//                ms.getSqlCommandType().name());
//        DynamicDataSourceHolder.setDbType(lookUpKEY);
//        return  invocation.proceed();
//    }
//    /*
//    * 返回封装对象
//    * Executor判断接收的sql操作类型。增删改查
//    * */
//    @Override
//    public Object plugin(Object target) {
//        if (target instanceof Executor){
//            return Plugin.wrap(target,this);
//        }else{
//            return target;
//        }
//
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//}
