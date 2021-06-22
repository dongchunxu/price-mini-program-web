//package com.dianwoyin.price;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//@SpringBootTest
//class PriceMiniProgramServiceApplicationTests {
//
//    @Test
//    void contextLoads() {
//        //用来获取Mybatis-Plus.properties文件的配置信息
//        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");
//
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir(rb.getString("OutputDir"));
//        gc.setOpen(false);PriceListServiceImpl.java
//        gc.setBaseResultMap(true);
//        gc.setBaseColumnList(true);
//        gc.setAuthor(rb.getString("author"));
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
////        gc.setServiceName("%sService");
////        gc.setServiceImplName("%sServiceImpl");
////        gc.setControllerName("%sController");
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setUrl(rb.getString("url"));
//        dsc.setDriverName(rb.getString("driver"));
//        dsc.setUsername(rb.getString("userName"));
//        dsc.setPassword(rb.getString("password"));
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent(rb.getString("parent"));
//        pc.setController("controller");
//        pc.setService("service");
//        pc.setServiceImpl("service.impl");
//        pc.setEntity("com/dianwoyin/price/model");
//        pc.setMapper("com/dianwoyin/price/mapper");
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return rb.getString("OutputDirXml") + "/com/dianwoyin/price/mapper/" + tableInfo.getEntityName() + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(true);
//        strategy.setInclude("account", "activity", "category_dict", "category_property","category_property_value",
//                "district_dict", "merchant", "merchant_tag", "order", "price_list_ask", "price_list_reply", "tag_dict");
//        strategy.setTablePrefix("sys_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//}
