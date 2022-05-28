package com.njupt.community.config;

import com.njupt.community.quartz.AlphaJob;
import com.njupt.community.quartz.PostScoreRefreshJob;
import com.njupt.community.quartz.WKImageDeleteJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

// 配置 -> 数据库 -> 调用
@Configuration
public class QuartzConfig {


    // 刷新帖子分数任务
    @Bean
    public JobDetailFactoryBean postScoreRefreshJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(PostScoreRefreshJob.class);
        factoryBean.setName("postScoreRefreshJob");
        factoryBean.setGroup("communityJobGroup");
        factoryBean.setDurability(true);//是否持久保存
        factoryBean.setRequestsRecovery(true);//是否可以被恢复
        return factoryBean;
    }

    // 刷新帖子分数trigger
    @Bean
    public SimpleTriggerFactoryBean postScoreRefreshTrigger(JobDetail postScoreRefreshJobDetail){ // 尽量传入参数与Bean名对应，避免实例多有冲突，优先传名字相同的
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(postScoreRefreshJobDetail);
        factoryBean.setName("postScoreRefreshTrigger");
        factoryBean.setGroup("communityTriggerGroup");
        factoryBean.setRepeatInterval(1000 * 60 * 5);// 频率
        factoryBean.setJobDataMap(new JobDataMap());// 存储Job状态
        return factoryBean;
    }

    // 删除WK图片任务
    @Bean
    public JobDetailFactoryBean wkImageDeleteJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(WKImageDeleteJob.class);
        factoryBean.setName("wkImageDeleteJob");
        factoryBean.setGroup("communityJobGroup");
        factoryBean.setDurability(true);//是否持久保存
        factoryBean.setRequestsRecovery(true);//是否可以被恢复
        return factoryBean;
    }

    // 删除WK图片触发器
    @Bean
    public SimpleTriggerFactoryBean wkImageDeleteTrigger(JobDetail wkImageDeleteJobDetail){ // 尽量传入参数与Bean名对应，避免实例多有冲突，优先传名字相同的
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(wkImageDeleteJobDetail);
        factoryBean.setName("wkImageDeleteTrigger");
        factoryBean.setGroup("communityTriggerGroup");
        factoryBean.setRepeatInterval(1000 * 60 * 4);// 频率
        factoryBean.setJobDataMap(new JobDataMap());// 存储Job状态
        return factoryBean;
    }


    // FactoryBean和BeanFactory是两回事
    // FactoryBean可简化Bean的实例化过程
    // 1.Spring通过FactoryBean封装了某些Bean的实例化过程
    // 2.将FactoryBean装配到Spring容器里
    // 3.将FactoryBean注入给其他的Bean
    // 4.该Bean得到的是FactoryBean所管理的对象实例

    // 配置JobDetail
////    @Bean
//    public JobDetailFactoryBean alphaJobDetail(){
//        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
//        factoryBean.setJobClass(AlphaJob.class);
//        factoryBean.setName("alphaJob");
//        factoryBean.setGroup("alphaJobGroup");
//        factoryBean.setDurability(true);//是否持久保存
//        factoryBean.setRequestsRecovery(true);//是否可以被恢复
//        return factoryBean;
//    }

    // 配置Trigger（SimpleTriggerFactoryBean(简易)，CronTriggerFactoryBean(复杂)）
//    @Bean
//    public SimpleTriggerFactoryBean alphaTrigger(JobDetail alphaJobDetail){ // 尽量传入参数与Bean名对应，避免实例多有冲突，优先传名字相同的
//        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
//        factoryBean.setJobDetail(alphaJobDetail);
//        factoryBean.setName("alphaTrigger");
//        factoryBean.setGroup("alphaTriggerGroup");
//        factoryBean.setRepeatInterval(3000);// 频率
//        factoryBean.setJobDataMap(new JobDataMap());// 存储Job状态
//        return factoryBean;
//    }

}
