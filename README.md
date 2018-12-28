# Code_Generator

Java代码生成器

功能：

1：普通方式：
  直接调用JavaTemplateInterface接口方法，传递FreemarkerContext上下文类创建文件，可以创建实体类、DAO接口及Mybatis XML文件。
  
2：读库方式：
  屏蔽底层数据库类型，直接读取数据库所有表，创建相应的实体类、DAO接口及Mybatis XML文件。（此种方式使用需要引入具体数据库的驱动jar包，项目中已经默认包含MySQL的驱动jar包了）

注：

1.核心代码已经齐全，使用方式详见Test。

2.添加Swagger2，可在WEB页面操作。

3.使用者可以根据自己的需求添加相应的Freemarker模板，然后实现JavaTemplateInterface接口或者AbstractJavaTemplate抽象类，描述自己的业务逻辑。
