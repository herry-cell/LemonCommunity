## 柠檬社区

### 资料
[Spring 文档](https://spring.io/guides)<br>
[Spring Web](https://spring.io/guides/gs/serving-web-content)<br>
[es](https://elasticsearch.cn/explore)<br>
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)<br>
[Bootstrap](https://v3.bootcss.com/getting-started/)<br>
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
[springmvc](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-handlermapping-int)

### 工具
[Git](https://git-scm.com/download)<br>
[Visual Paradigm](https://www.visual-paradigm.com)
[flyway](https://flywaydb.org/getstarted/firststeps/maven)
[h2](https://mvnrepository.com/artifact/com.h2database/h2)
[maven generator](http://mybatis.org/generator/running/runningWithMaven.html)
[jquery](https://www.jquery.com/download)
[jquery](https://www.jsdelivr.com/)

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

创建question表
```sql
create table question
(
	id int auto_increment,
	title varchar(50),
	description text,
	gmt_create BIGINT,
	gmt_modified BIGINT,
	creator INT,
	comment_count int default 0,
	view_count int default 0,
	like_count INT default 0,
	tag varchar(256),
	constraint question_pk
		primary key (id)
);
```

```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```