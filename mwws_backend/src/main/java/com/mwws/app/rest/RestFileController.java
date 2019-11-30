package com.mwws.app.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mwws.app.Service.ParameterService;
import com.mwws.app.entity.Files;
import com.mwws.app.entity.Parameter;

@RestController
@RequestMapping("file")
@CrossOrigin
public class RestFileController {
	
	
	@Autowired
	ParameterService parameterService;
			
	public String getFilePath() {
		List<Parameter> parameters = parameterService.getParameter();
		Parameter parameter = null;
		if (parameters!=null && !parameters.isEmpty()) {
			for (Parameter p : parameters) {
				if (p.getName().equalsIgnoreCase("disk")) {
					parameter = p;
					break;
				}
			}
		}
		return parameter.getValue();
	}
	
	@PostMapping(value = {"save" }, headers = ("content-type=multipart/*"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> save(@RequestParam("image") MultipartFile file, HttpServletRequest req) {
		Map<String, String> maps = new HashMap<String, String>();
		String disk = getFilePath();
		try {
			File fileD = new File(disk + "\\image\\customer");
			if (fileD.exists()) {
				fileD.mkdirs();
			}
			String nameFile = file.getOriginalFilename();
			if (nameFile != null && !nameFile.trim().equals("")) {
				File fileSave = new File(fileD.getAbsolutePath() + File.separator + nameFile);
				BufferedOutputStream bStream = new BufferedOutputStream(new FileOutputStream(fileSave));
				bStream.write(file.getBytes());
				bStream.close();
				maps.put("file","\\image\\customer\\" + nameFile);
				return  maps;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="delete",method = RequestMethod.POST,consumes = "application/json")
	public Map<String,String> deleteFile(@RequestBody Files file){
		Map<String,String> maps = new HashMap<String, String>();
		String disk = getFilePath();
		File fileDisk = new File(disk+file.getFileName());
		if(fileDisk.exists()) {
			fileDisk.delete();
			maps.put("ok", "success");
		}else {
			maps.put("ok", "notsucess");
		}
		return maps;
	}
}
