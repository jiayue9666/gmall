# gmall �����޸İ汾

gmall-user�û�����8080
nginx.conf����˿ں�
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
#ͨ��mapper
ͨ��mapper��extend Mapper ֮���Զ�������ɾ�Ĳ���~���棡
public interface UserMapper extends Mapper<UmsMember> 
mapperscanҪ��tk.mybatis�����ע��

##**�������ز��ԣ�insert����**
useGeneratedKeys����Ϊ true ʱ����ʾ�������ı�id��������Ϊ������������ JDBC ֧���Զ��������������ɽ��Զ����ɵ�����id���ء�
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 ��    <insert id="" useGeneratedKeys="true" keyColumn="id" keyProperty="id"></insert>

#��ݼ�
ctrl+e:recent file

#TIPS
parent�����pom,���ڰ汾����

#��ȡapi����
api:service�ӿں�bean