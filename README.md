## 介绍
使用spring+spring mvc+mybatis搭建的一个RESTFUL数据服务,数据来源是我另外一个[爬虫项目]()爬取的。因为刚接触java web不久，这个程序算是比较简单。但是，麻雀虽小，五脏俱全,还是把整个web请求的该有的都有了的。列举一下实现的点。  
1. 开发环境的配置。gradle构建的基本认识，同时了解各个框架应该导入哪些包，每个包负责是什么。还有如何在gradle集成嵌入式tomcat和构建war包。
2. 服务端的配置，nginx反向代理服务器配置和tomcat部署基本配置。https配置。
3. MVC数据流。
4. 错误处理。

因为刚学java web,所以整体比较简单，随着学习的深入，还是会不断地往这个项目添加更多的点的。
## 文档
### 获取可使用的所有模块
`GET /`
返回所有可使用模块，格式如下：
```
{
  "module_crawl":"https://api.uzpeng.top/crawl",
  "documentation_url":"https://github.com/UZPENG/REST-JAVA-WEB/wiki/Documentions"
}
```
### 获取指定模块下的可使用api
`GET /<module_name>`
返回指定模块下的可使用API，格式如下：
```
{
  "car_list_url":"https://api.uzpeng.top/crawl/car",
  "documentation_url":"https://github.com/UZPENG/REST-JAVA-WEB/wiki/Documentions"
}
```
### 获取车辆的列表
`GET /crawl/car?limit=<page size>&offset=<offset>`
参数`limit`必须是`[10,20,30]`中的一个，参数`offset`必须是`10`的倍数，默认参数是`limit=30 offset=0`
返回格式如下：
```
[
    {
        "id": "1",
        "name": "凯迪拉克ATS-L 2017款 28T 技术型",
        "mileage": "2.2",
        "year": "2016",
        "loc": "武汉",
        "origin_price": 32.4,
        "discount_price": 21.8,
        "img_url": "https://image.guazistatic.com/gz01180126/15/43/10ef065d9cae03a2589d6095fbd425f4.jpg@base@tag=imgScale&w=287&h=192&c=1&m=2&q=88"
    }
]
```
