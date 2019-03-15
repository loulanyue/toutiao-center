业务字段设计

数据库创建

CRUD操作

MyBatis集成

注解和XML定义

ViewObject和DateTool

首页开发

数据库字段设计


用户（User）

    id
    name
    password
    salt
    head_url

站内信（Message）

    id
    fromid
    toid
    content
    conversation_id
    created_date

资讯（News）

    id
    title
    link
    image
    like_count
    comment_count
    user_id
    created_date

评论（Comment）

    id
    content
    user_id
    create_date
    news_id


数据库创建

    GUI转SQL（推荐）
    Sequel Pro
    MySQL Navica
    MySQL Front
    MySQL Workbench

SQL脚本

    DROP TABLE IF EXISTS `news`;
    CREATE TABLE `news`(
      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
      `title` varchar(128) NOT NULL DEFAULT",
      `link` varchar(256)NOT NULL dEFALUT",
      `image` varchar(256)NOT NULL dEFALUT",
      `like_count` int(11)NOT NULL,
      `create_date` datetime NOT NULL,
      `user_id` int(11) NOT NULL,
      PRIMARY KEY(`id`)
    )ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT
    CHARSET=utf8;

常用数据类型

    int
    varchar(n)
    datetime
    float(m,d)
    text,65535


数据库操作（CRUD）

    INSERT INTO table_name(列1,列2,...)VALUES(值1,值2,...)
    SELECT */列名称FROM 表名称
    UPDATE 表名称 SET 列名称 =新值 WHERE 列名称 = 某值
    DELETE FROM 表名称 WHERE 列名称=值

    SELECT {COLA,COLB,*}FROM{TABLE}
    WHERE{CONDITION}
    ORDER BY{COL} DESC
    LIMIT{OFF},{COUNT}

MyBatis集成

    1.application.properties增加spring配置数据库链接地址
    2.pom.xml引入mybatis-spring-boot-starter和mysql-connector-java

JDBC数据库操作

    1.加载驱动
    2.创建数据链接
    3.创建Statement对象
    4.执行SQL获取数据
    5.数据转换
    6.资源释放

注解配置

    @Mapper
    public interface UserDAO{
      String TABLE_NAME='user';
      String INSERT_FIELDS='name,password,salt,head_url';
      String SELECT_FIELDS='id,name,password,salt,head_url';
      @Insert("insert into",TABLE_NAME,"(",INSERT_FIELDS,")VALUES(#{name},#{password},#{salt},#{headUrl})") int addUser(User user);
      @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where id=#{id}"}) User selectById(int id);
      @Update({"update",TABLE_NAME,"set password=#{password}where id=#{id}"}) void updatePassword(User user);
      @Delete({"delete from ",TABLE_NAME,"where id=#{id}"}) void deleteById(int id);
    }

XML配置：在相同的包目录下定义的同名XML

    <mapper namespace="com.coder.dao.NewsDAO">
      <sql id="table">news</sql>
      <sql id="selectFileds">id,title,image,like_count,comment_count,created_date,user_id</sql>
      <select id="selectByUserIdAndOffset"resultType="com.coder.model.News">
        SELECT
        <include refid="selectFields"/>
        FROM
        <include refid="table"/>

        <if test="userId!=0">
          WHERE user_id=#{userId}
        </if>
        ORDER BY id DESC
        LIMIT #{offset},#{limit}
      </select>
    </mapper>

ViewObject和DateTool

    ViewObject：方便传递任何数据到Velocity
    DateTool:velocity自带工具类导入
