登录模块：
1.登录功能验证（用户名密码是否正确，失效时间，账户是否锁定，ip地址是否符合要求）
2.全局异常处理（登录异常）
3.拦截器拦截恶意登录


1.创建maven项目
2.导入依赖包
3.构建项目目录
4.创建SSM对应配置文件
    1.mybatis.xml
    2.applicationContext.xml
    3.springmvc.xml
    4.db.properties
    5.log4j.properties

5.导入原型html文件
6.设计数据库
7.编写代码

$.ajax({
				url:"",
				type:"",
				data:{

				},
				dataType:"",
				success:function () {

				}

			})

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>