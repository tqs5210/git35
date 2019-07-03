﻿<%@ page  import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %> 
<%@ page contentType="text/Html;charset=UTF-8" %>
<!-- 数字验证码 -->
<%
//设置页面不缓存
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

// 在内存中创建图象  每字15像素
int width=15*4, height=20;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

// 获取图形上下文
Graphics g = image.getGraphics();

//生成随机类
Random random = new Random();

// 设定背景色
//g.setColor(getRandColor(200,250));
//g.setColor(new Color(216,216,216));
g.setColor(Color.black);
g.fillRect(0, 0, width, height);

//设定字体
g.setFont(new Font("Franklin Gothic Medium",Font.ITALIC,17));
//画边框
//g.setColor(new Color());
//g.drawRect(0,0,width-1,height-1);


// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
g.setColor(Color.white);

for (int i=0;i<7;i++){
 int x = random.nextInt(width);
 int y = random.nextInt(height);
        int xl = random.nextInt(width-x);
        int yl = random.nextInt(height-y);
 g.drawLine(x,y,x+xl,y+yl);
}

// 取随机产生的认证码(4位数字)
String sRand="";
for (int i=0;i<4;i++){
    String rand=String.valueOf(random.nextInt(10));
    sRand+=rand;
    // 将认证码显示到图象中
    g.setColor(Color.white);//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
    g.drawString(rand,13*i+6,18);
}

// 将认证码存入SESSION
session.setAttribute("rand01",sRand);
// 图象生效
g.dispose();

// 输出图象到页面
ImageIO.write(image, "JPEG", response.getOutputStream());

out.clear();
out = pageContext.pushBody();
%> 

