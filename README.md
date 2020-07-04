# gmall 本地修改版本
测试版：
gmall-user用户服务：8080
gmall-user-service:8070
gmall-user-web:8080
gmall-manage-service:8071
gmall-manage-web:8081
nginx.conf代理端口号
`upstream user.gmall.com{
server 127.0.0.1:8080;
}
server{
listen 80;
server_name user.gmall.com;
location/{
proxy_pass http://user.gmall.com;
proxy_set_header X-forwarded-for $proxy_add_x_forwarded_for;
}
}`
#通用mapper
通用mapper：extend Mapper 之后，自动带有增删改操作~神奇！
public interface UserMapper extends Mapper<UmsMember> 
mapperscan要用tk.mybatis包里的注解
mapperscan指定实例化的mapper，一定要指定！

##**主键返回策略（insert）：**

useGeneratedKeys设置为 true 时，表示如果插入的表id以自增列为主键，则允许 JDBC 支持自动生成主键，并可将自动生成的主键id返回。
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 或：    <insert id="" useGeneratedKeys="true" keyColumn="id" keyProperty="id"></insert>

#快捷键
ctrl+e:recent file

#TIPS
parent打包成pom,用于版本控制,统一管理依赖的版本号

#抽取api工程
api:service接口和bean
bean文件要引入通用mapper,用了tk的通用mapper的注解，id，generatekey 或者引入jpi注解？？

#通用框架
所有应用工程需要引入的包(common-util)
springboot ,common-langs,common-beanutils
前端：contorller（web-util）
jsp,thymeleaf,cookie
后端：service+mapper
redis,mysql,mybatis(service-util)

#soa面向服务（以dubbo为基础）
结束后可将dubbo改成springcloud
使用dubbo协议访问注册中心
dubbo://
springcloud是用http协议rest风格，在consoler中实现负载均衡
dubbo有一个注册中心的客户端在实时同步注册中心的服务信息。
dubbo-admin-x.x.war:每个dubbo框架都携带这个监控包（monitor）：监控状态，注册信息，负载均衡，
设置zookeeper和监控中心开机自启

#将项目改造为dubbo分布式框架
将user分为user-service和user-web:比如订单web可能也会用到user-web,这样可以解耦，又比如controller处理并发要求比较高，这样能合理分配资源
dubbo放到common-util

#电商网站数据结构
sku+spu
sku:stock keeping util/标准商品库存存储单元（一般有一个具体的库存商品）
spu:standard product util/抽象概念

sku结构：pms_sku
spu结构：pms_spu
类目结构：pms_catalog
属性结构：pms_attr
前后端分离：前端项目和后端项目可以独立运行。
jsp：动态地向前端输出页面，servlet
前端的虚拟机:node.js

#前后端跨域问题
前端：localhost:8888
后端：localhost：8080
跨域了，彼此之间不信任，不在一个网域，包括端口号不同都跨了
浏览器连接了两个服务器,使用springmvc的跨域请求注解@CrossOrgain
加在controller上

#图片信息：
对象保存在分布式的文件存储服务器中
图片元数据存在数据库。
选择时与后端不交互；
或者选择时就提交到后台。

#spu的销售属性星系
商品的平台属性属于电商网站后台管理，
商品的销售属性属于电商商家管理。属于某一件商品
##图片信息的处理
前端传过来的信息
<form method ="post" enctype="multipart/Form-data">
    <input type="file"/>
</form>
传过来的类型是file 我们用 RequestParam("file")MultipartFile来接收

#分布式文件存储（fastdfs）
一般存储服务器不提供web服务，就用nginx搭建web服务接受http请求获取存储服务器的内容
fdfs和springboot整合