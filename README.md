# gmall �����޸İ汾
���԰棺
gmall-user�û�����8080
gmall-user-service:8070
gmall-user-web:8080
gmall-manage-service:8071
gmall-manage-web:8081
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
mapperscanָ��ʵ������mapper��һ��Ҫָ����

##**�������ز��ԣ�insert����**

useGeneratedKeys����Ϊ true ʱ����ʾ�������ı�id��������Ϊ������������ JDBC ֧���Զ��������������ɽ��Զ����ɵ�����id���ء�
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 ��    <insert id="" useGeneratedKeys="true" keyColumn="id" keyProperty="id"></insert>

#��ݼ�
ctrl+e:recent file

#TIPS
parent�����pom,���ڰ汾����,ͳһ���������İ汾��

#��ȡapi����
api:service�ӿں�bean
bean�ļ�Ҫ����ͨ��mapper,����tk��ͨ��mapper��ע�⣬id��generatekey ��������jpiע�⣿��

#ͨ�ÿ��
����Ӧ�ù�����Ҫ����İ�(common-util)
springboot ,common-langs,common-beanutils
ǰ�ˣ�contorller��web-util��
jsp,thymeleaf,cookie
��ˣ�service+mapper
redis,mysql,mybatis(service-util)

#soa���������dubboΪ������
������ɽ�dubbo�ĳ�springcloud
ʹ��dubboЭ�����ע������
dubbo://
springcloud����httpЭ��rest�����consoler��ʵ�ָ��ؾ���
dubbo��һ��ע�����ĵĿͻ�����ʵʱͬ��ע�����ĵķ�����Ϣ��
dubbo-admin-x.x.war:ÿ��dubbo��ܶ�Я�������ذ���monitor�������״̬��ע����Ϣ�����ؾ��⣬
����zookeeper�ͼ�����Ŀ�������

#����Ŀ����Ϊdubbo�ֲ�ʽ���
��user��Ϊuser-service��user-web:���綩��web����Ҳ���õ�user-web,�������Խ���ֱ���controller������Ҫ��Ƚϸߣ������ܺ��������Դ
dubbo�ŵ�common-util

#������վ���ݽṹ
sku+spu
sku:stock keeping util/��׼��Ʒ���洢��Ԫ��һ����һ������Ŀ����Ʒ��
spu:standard product util/�������

sku�ṹ��pms_sku
spu�ṹ��pms_spu
��Ŀ�ṹ��pms_catalog
���Խṹ��pms_attr
ǰ��˷��룺ǰ����Ŀ�ͺ����Ŀ���Զ������С�
jsp����̬����ǰ�����ҳ�棬servlet
ǰ�˵������:node.js

#ǰ��˿�������
ǰ�ˣ�localhost:8888
��ˣ�localhost��8080
�����ˣ��˴�֮�䲻���Σ�����һ�����򣬰����˿ںŲ�ͬ������
���������������������,ʹ��springmvc�Ŀ�������ע��@CrossOrgain
����controller��

#ͼƬ��Ϣ��
���󱣴��ڷֲ�ʽ���ļ��洢��������
ͼƬԪ���ݴ������ݿ⡣
ѡ��ʱ���˲�������
����ѡ��ʱ���ύ����̨��

#spu������������ϵ
��Ʒ��ƽ̨�������ڵ�����վ��̨����
��Ʒ�������������ڵ����̼ҹ�������ĳһ����Ʒ
##ͼƬ��Ϣ�Ĵ���
ǰ�˴���������Ϣ
<form method ="post" enctype="multipart/Form-data">
    <input type="file"/>
</form>
��������������file ������ RequestParam("file")MultipartFile������

#�ֲ�ʽ�ļ��洢��fastdfs��
һ��洢���������ṩweb���񣬾���nginx�web�������http�����ȡ�洢������������
fdfs��springboot����