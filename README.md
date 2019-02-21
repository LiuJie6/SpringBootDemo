# 1 基本配置文件写在application.properties中
# 2 在pom.xml引入相关包
# 3 持久层（项目中的DAO层）继承JpaRepository，就可使用相关方法操作数据库
## 3.1 可以直接使用JPA操作数据库，但熟练度要求高（单表查询等简单语句实现简单，复杂语句很麻烦）
## 3.2 可以使用原生SQL语句@Query(nativeQuery = true,value="")
## 3.3 可以在启动类中引入SessionFactory Bean，使用hibernate的相关方法
# 4 spring-boot-starter-parent 是spring boot项目的父级依赖，之后的<dependency>可以不用注明<version>（视情况而定）
## 版本在2.0.0以上时，HibernateJpaSessionFactoryBean会变成已废弃，项目配置也需要改变