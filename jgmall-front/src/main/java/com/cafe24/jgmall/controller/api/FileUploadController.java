package com.cafe24.jgmall.controller.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.vo.FileVo;

@RestController("fileUploadController")
@RequestMapping("/api/file/upload")
public class FileUploadController {
	
	@PostMapping("/image")
	public ResponseEntity<JSONResult> uploadImageBase64(
			@RequestBody FileVo fileVo) {
		
		FileOutputStream fileOutputStream = null;
		
		try {
			
			byte[] imgBytes = Base64.decodeBase64(fileVo.getBase64EncodingData());
			String fileName = makeFileName(fileVo);
			
			fileOutputStream = new FileOutputStream("/jgmall-uploads/" + fileName);
			fileOutputStream.write(imgBytes);
			
			fileVo.setSaveUrl("http://localhost:8080/jgmall-front/images/" + fileName);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("파일 업로드 에러"));
		} finally {
			if(fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("fileOutputStream close error!!"));
				}
			}
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(fileVo));
	}

	private String makeFileName(FileVo fileVo) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		String year = Integer.toString(calendar.get(Calendar.YEAR));
		
		String mon = getTwoDigitsCalendar(calendar.get(Calendar.MONTH)+1);
		String day = getTwoDigitsCalendar(calendar.get(Calendar.DAY_OF_MONTH));
		
		String hour = getTwoDigitsCalendar(calendar.get(Calendar.HOUR_OF_DAY));
		String min = getTwoDigitsCalendar(calendar.get(Calendar.MINUTE));
		String sec = getTwoDigitsCalendar(calendar.get(Calendar.SECOND));
		String mill = getThreeDigitsCalendar(calendar.get(Calendar.MILLISECOND));
		
		
		String saveFileName = year + mon + day + hour + min + sec + mill;
		String ext = fileVo.getExtNm();
		
		return saveFileName + "." + ext;
	}
	
	private String getTwoDigitsCalendar(int value) {
		String result = "0" + Integer.toString(value);
		result = result.substring(result.length()-2);
		
		return result;
	}
	
	private String getThreeDigitsCalendar(int value) {
		String result = "00" + Integer.toString(value);
		result = result.substring(result.length()-2);
		
		return result;
	}
}
