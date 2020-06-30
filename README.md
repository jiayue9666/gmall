# gmall 本地修改版本

gmall-user用户服务：8080
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

##**主键返回策略（insert）：**
useGeneratedKeys设置为 true 时，表示如果插入的表id以自增列为主键，则允许 JDBC 支持自动生成主键，并可将自动生成的主键id返回。
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 或：    <insert id="" useGeneratedKeys="true" keyColumn="id" keyProperty="id"></insert>

#快捷键
ctrl+e:recent file

#TIPS
parent打包成pom,用于版本控制

#抽取api工程
api:service接口和bean