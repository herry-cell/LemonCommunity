## 柠檬社区

### 资料
[Spring 文档](https://spring.io/guides)<br>
[Spring Web](https://spring.io/guides/gs/serving-web-content)<br>
[es](https://elasticsearch.cn/explore)<br>
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)<br>
[Bootstrap](https://v3.bootcss.com/getting-started/)<br>
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

### 工具
[Git](https://git-scm.com/download)<br>
[Visual Paradigm](https://www.visual-paradigm.com)

#### 脚本

创建user表
```sql
create table user
(
	id INT auto_increment primary key not null,
	account_id varchar(100),
	name varchar(50),
	token char(36),
	gmt_create BIGINT,
	gmt_modified BIGINT
);
```

