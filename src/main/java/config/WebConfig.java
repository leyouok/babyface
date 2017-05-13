package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import javax.sql.DataSource;
import java.io.File;
import java.io.InputStream;

/**
 * Created by lenovo on 2017/5/12.
 */

@Configuration
@EnableWebMvc
public class WebConfig {
    /*连接数据库 使用阿里巴巴的Driver*/
    @Bean
    public DataSource getDateSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bland");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        return druidDataSource;
    }
    /*创建mybatis工厂*/
    @Bean(name = "factory")
    public SqlSessionFactoryBean getMybatisFactory(){
        String resource = "classpath*:mapper/*.xml";
        Resource classpath = new ClassPathResource(resource);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDateSource());
        sqlSessionFactoryBean.setMapperLocations(new Resource[]{classpath});
        return sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer getDao(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("factory");
        mapperScannerConfigurer.setBasePackage("model.dao");
        return  mapperScannerConfigurer;
    }

}
