package com.njupt.community.actuator;

import com.njupt.community.aspect.ServiceLogAspect;
import com.njupt.community.util.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// 查看数据库链接是否正常
@Component
@Endpoint(id = "database")// 给自定义端点起名
public class DatabaseEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseEndpoint.class);

    @Autowired
    private DataSource dataSource;

    // 尝试获取链接
    @ReadOperation// 通过GET请求访问, WriteOperation是通过POST
    public String checkConnection(){
        try (
                Connection conn = dataSource.getConnection();
                ){
            return CommunityUtil.getJSONString(0, "获取连接成功！");
        }catch (SQLException e){
            logger.error("获取连接失败: " + e.getMessage());
            return CommunityUtil.getJSONString(1, "获取连接失败！");
        }
    }

}
