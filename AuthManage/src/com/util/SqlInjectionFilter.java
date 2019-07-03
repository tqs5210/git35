package com.util;
import java.io.IOException;  
import java.util.Enumeration;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
public class SqlInjectionFilter  implements Filter{
    public void destroy() {  
   
    }  
      
    public void init(FilterConfig arg0) throws ServletException {  
       
    }  
      
    public void doFilter(ServletRequest args0, ServletResponse args1,  
            FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest request=(HttpServletRequest)args0;  
        ServletResponse response=(ServletResponse)args1;  
         //获得所有请求参数名  
        Enumeration params = request.getParameterNames();  
        String sql = "";  
        while (params.hasMoreElements()) {  
            //得到参数名  
            String name = params.nextElement().toString();  
            //得到参数对应值  
            String[] value = request.getParameterValues(name);  
            for (int i = 0; i < value.length; i++) {  
                sql = sql + value[i];  
                if (sql_inj(sql)) {  //找到非法参数
	               	 response.setContentType("text/html;charset=UTF-8");
	               	 response.getWriter().println("<script>alert('参数中包含非法字符！');location.href='"+request.getContextPath()+"/';</script>");
	       			 return; 
               } 
            }  
        }  
         //正常请求
         chain.doFilter(args0,args1);           
    }  
   
    /**
     * sql校验方法，过滤常用命令
     * @param str
     * @return
     */
    protected static boolean sql_inj(String str) {
    	 str = str.toLowerCase();//统一转为小写  
		String inj_str = "': and: or:exec:insert:select:delete:update: count: sum: avg: max: min: group: order:merger:*:%: chr:mid:master:truncate: char:declare:;:-:+:,:!:^:&:#:$:|:=:/:\\:.:~:@";
		String inj_stra[] = inj_str.split(":");
		if (str != null && str != "") {
			for (int i = 0; i < inj_stra.length; i++) {
				if (str.indexOf(inj_stra[i]) >= 0) {
					return true;
				}
			}
		}
		return false;
	}
    
    /**
     * sql校验方法，过滤常用命令
     * @param str
     * @return
     */
    protected static boolean sqlValidate(String str) {  
        str = str.toLowerCase();//统一转为小写  
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +  
                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +  
                "table|from|grant|use|group_concat|column_name|" +  
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +  
                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";//过滤掉的sql关键字，可以手动添加  
        String[] badStrs = badStr.split("\\|");  
        for (int i = 0; i < badStrs.length; i++) {  
            if (str.indexOf(badStrs[i]) >= 0) {  
                return true;  
            }  
        }  
        return false;  
    }  
    
    

}  
  
