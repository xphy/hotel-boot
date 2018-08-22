package com.phy.control;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.phy.bizs.CompanyBiz;
import com.phy.model.Company;
import com.phy.util.UpLoad;

@RestController
@RequestMapping("/company/")
public class CompanyCtrl {
	
	@Resource
	private CompanyBiz biz;
	
	@RequestMapping("find")
    public Company find() {
		return this.biz.find();
    }
	@RequestMapping("save")
	public boolean saveBean(Company bean) {
		return this.biz.save(bean);
	}
	@RequestMapping("uploads")
	public boolean saveImg(@RequestParam("files[]") MultipartFile files[],HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/imgs/company");
		File dir = new File(path);
		if(!dir.exists()) dir.mkdirs();
		Company bean = new Company();
		bean.setId(1);
		System.out.println(files.length);
		for(int i=0;i < files.length;i++) {
			MultipartFile file = files[i];
			System.out.println(file);
			if(file!= null && file.getSize()>0) {
				String name = UpLoad.getString(file, path);
				if(name!=null){
					switch(i){
					case 0:
						bean.setPica(name);
						break;
					case 1:
						bean.setPicb(name);
						break;
					case 2:
						bean.setPicc(name);
						break;
					case 3:
						bean.setPicd(name);
						break;
					case 4:
						bean.setPice(name);
						break;
					case 5:
						bean.setPicf(name);
						break;
					}
				}
			}
		}
		return this.biz.saveImage(bean);
	}
}
