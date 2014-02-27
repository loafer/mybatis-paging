mybatis-paging
==============

Based on the database dialect Mybatis3 paging plug-in.    
The current support for Oracle、 MySQL .

Basic Usage
-----------
include the following in mybatis-config.xml.

    <plugins>
        <plugin interceptor="com.github.loafer.mybatis.pagination.PaginationInterceptor">
            <property name="dialect" value="oracle"/>
            <property name="stmtIdRegex" value="*.selectPaging"/>
        </plugin>
    </plugins>
or

    <plugins>
        <plugin interceptor="com.github.loafer.mybatis.pagination.PaginationInterceptor">
            <property name="dialectClass" value="com.github.loafer.mybatis.pagination.dialect.OracleDialect"/>
            <property name="stmtIdRegex" value="*.selectPaging"/>
        </plugin>
    </plugins>

* `dialect`, database type. oracle\mysql
* `dialectClass`, a subclass of `com.github.loafer.mybatis.pagination.dialect.Dialect`.
* `stmtIdRegex`, statement id regex string. example: `*.selectPaging` or `*.selectPaging*`.

SQL Mapper config
-----------------
    <select id="selectPaging" resultType="hashmap">
        select * from ent_user
    </select>


@See [config](https://github.com/loafer/mybatis-paging/blob/master/src/test/resources/applicationContext.xml)
and [Basic Usage](https://github.com/loafer/mybatis-paging/blob/master/src/test/java/com/github/loafer/mybatis/pagination/UserService.java)

Others
------
In addition, [sogyf/mybatis-pagination](https://github.com/sogyf/mybatis-pagination) maybe help you.
