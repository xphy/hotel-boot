package com.phy.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class UpLoad {
	public static String getString(MultipartFile file ,String path) {
		  //获得文件名
		  String name =file.getOriginalFilename();
		  //获得文件的扩展名
		  String exe =name.substring(name.lastIndexOf("."));
		  //获得当前的系统时间
		  int n = (int) (Math.random()*100+1);
		  long time = System.currentTimeMillis()+n;
		  //形成新的文件名
		  name =time+exe;
		  //构建目标文件，利用传过来的系统路径
		  path = path +"\\"+name;
		  File dest = new File(path);
		  try {
			file.transferTo(dest);
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;		
		} 
	}

}
