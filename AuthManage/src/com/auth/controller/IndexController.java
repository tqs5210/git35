package com.auth.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.auth.entity.AuthInfo;
@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mov=new ModelAndView("index");
		return mov;
	}

	
    /*** 
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile 
     *  
     * @param file 
     * @return 
     */  
    @RequestMapping("/fileUpload")  
    public String fileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {       
            try {  
                // 文件保存路径  
            	//file.getOriginalFilename() 获取上传文件的原始名称
                String filePath = request.getSession().getServletContext()
                		.getRealPath("/")+"upload/"+file.getOriginalFilename();  
               // 转存文件  
                file.transferTo(new File(filePath));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        // 重定向  
        return "redirect:/index.jsp";  
    } 
    
    @RequestMapping("/filesUploads")  
    public String filesUpload(@RequestParam("files") MultipartFile[] files,HttpServletRequest request) {  
        //判断file数组不能为空并且长度大于0 
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i]; 
                // 判断文件是否为空  
                if (!file.isEmpty()) {  
                    try {  // 文件保存路径  
                        String filePath = request.getSession().getServletContext()
                        		.getRealPath("/")+"upload/"+file.getOriginalFilename();  
                        file.transferTo(new File(filePath)); // 转存文件 
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                }
            }  
        }  
        // 重定向  
        return "redirect:/index.jsp";  
    }  
    
	    /**  
	     * 文件上传功能  
	     * @param file  
	     * @return  
	     * @throws IOException   
	     */  
	 	@RequestMapping("/upload")
	    public String upload(MultipartFile file,HttpServletRequest request) throws IOException{  
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();    
	        File dir = new File(path,fileName);          
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //MultipartFile自带的解析方法 ,文件转移到。。 
	        file.transferTo(dir);  
	        return "ok!";  
	    }  
	    	 	
	 	
	 	@RequestMapping("/uploads")
	    public String edit(@RequestParam("file") CommonsMultipartFile[] pic, HttpServletRequest request) throws Exception {	       
		 	String path = request.getSession().getServletContext().getRealPath("upload");  
		 	for (int i=0;i<pic.length;i++){
	           String fileName =  pic[i].getOriginalFilename();    
		        File dir = new File(path,fileName);          
		        if(!dir.exists()){  
		            dir.mkdirs();  
		        }  
		        //MultipartFile自带的解析方法 ,文件转移到。。 
		        pic[i].transferTo(dir); 
		     }
	        System.out.println("file=====================");
	        return "gouwuche/edit";
	    }
	 	
	 
	 	/** 
	     * 方法一上传文件 
	     */  
	    @RequestMapping("/onefile")  
	    public String oneFileUpload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) {  	  
	        // 获得原始文件名  
	        String fileName = file.getOriginalFilename();  
	        System.out.println("原始文件名:" + fileName);  
	        // 新文件名  
	        String newFileName = UUID.randomUUID() + fileName;  	  
	        // 获得项目的路径  
	        ServletContext sc = request.getSession().getServletContext();  
	        // 上传位置  
	        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  	  
	        File f = new File(path);  
	        if (!f.exists()){
	        	 f.mkdirs();  
	        }
	        if (!file.isEmpty()) {  
	            try {  
	                FileOutputStream fos = new FileOutputStream(path + newFileName);  
	                InputStream in = file.getInputStream();  
	                int b = 0;  
	                while ((b = in.read()) != -1) {  
	                    fos.write(b);  
	                }  
	                fos.close();  
	                in.close();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  	  
	        System.out.println("上传图片到:" + path + newFileName);  
	        // 保存文件地址，用于JSP页面回显  
	        request.setAttribute("fileUrl", path + newFileName);  
	        return "fileUpload";  
	    }  
	  
	    /** 
	     * 方法二上传文件，一次一张 
	     */  
	    @RequestMapping("/onefile2")  
	    public String oneFileUpload2(HttpServletRequest request, HttpServletResponse response) throws Exception {  
	        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());  
	        if (cmr.isMultipart(request)) {  
	            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);  
	            Iterator<String> files = mRequest.getFileNames();  
	            while (files.hasNext()) {  
	                MultipartFile mFile = mRequest.getFile(files.next());  
	                if (mFile != null) {  
	                    String fileName = UUID.randomUUID()+ mFile.getOriginalFilename();  
	                    String path = "d:/upload/" + fileName;  	  
	                    File localFile = new File(path);  
	                    mFile.transferTo(localFile);  
	                    request.setAttribute("fileUrl", path);  
	                }  
	            }  
	        }  
	        return "fileUpload";  
	    }  
	
	 	/**  
	     * 文件下载功能  
	     * @param request  
	     * @param response  
	     * @throws Exception  
	     */  
	    @RequestMapping("/download")  
	    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{  	   
	    	//模拟文件，myfile.txt为需要下载的文件  
	        String fileName = request.getSession().getServletContext().getRealPath("upload")+"/省体校区8楼讲师刘广2019年2月第3周回访记录.xlsx";  
	        //获取输入流  
	        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));  
	        //假如以中文名下载的话  
	        String filename = "省体校区8楼讲师刘广2019年2月第3周回访记录.xlsx";  
	        //转码，免得文件名中文乱码 
	        filename = java.net.URLEncoder.encode(filename,"UTF-8");  
	        //设置文件下载头  
	        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
	        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
	        response.setContentType("multipart/form-data"); 
	        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
	        int len = 0;  
	        while((len = bis.read()) != -1){  
	            out.write(len);  
	            out.flush();  
	        }  
	        out.close();  
	        bis.close();
	    }  
		public static void main(String[] args) {
			/* String jsonStr = "{\"companyId\":\"111111111\",\"companyName\":\"Huuuu\",\"_uid\":10,\"_index\":0,\"_state\":\"modified\"},{\"companyId\":\"000000000000000000\",\"companyName\":\"cx01\",\"_uid\":11,\"_index\":1,\"_state\":\"modified\"},{\"companyId\":\"9999999999999\",\"companyName\":\"ttt\",\"_uid\":12,\"_index\":2,\"_state\":\"modified\"}";
			  JSONObject obj = new JSONObject().fromObject(jsonStr);//将json字符串转换为json对象
			 System.out.println(obj.get("companyId"));
			 Object bean = (Object)JSONObject.toBean(obj);//将建json对象转换为对象
			 System.out.println(bean);*/
			
			String str=null;
			String str1=new String("1234");
			str="123"+"4";
			
			//str1="123"+"4";
			System.out.println(str==str1);
			System.out.println(str.equals(str1));
			
			 
		}
}
