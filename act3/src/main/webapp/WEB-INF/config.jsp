<%@page import="java.io.FileInputStream"%>
<%@page import="javax.imageio.stream.FileImageInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>
<%
Properties prop = new Properties();
InputStream input = application.getResourceAsStream("WEB-INF/config.properties");
prop.load(input);
%>
<jsp:useBean id="empDaoBean" class="my.app.model.EmployeeDAO" scope="application"></jsp:useBean>
<jsp:setProperty property="driver" name="empDaoBean" value='<%=prop.getProperty("database.driver") %>'/>
<jsp:setProperty property="dbpw" name="empDaoBean" value='<%=prop.getProperty("database.password") %>'/>
<jsp:setProperty property="dbuser" name="empDaoBean" value='<%=prop.getProperty("database.user") %>'/>
<jsp:setProperty property="url" name="empDaoBean" value='<%=prop.getProperty("database.url") %>'/>