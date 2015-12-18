package org.sjac.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

/**
 * 실제 파일을 다운로드시키기 위한 View를 구현 
 * (View 를 만들기 위해서는 spring에서 제공하는 AbstractView를 상속받아 추상메서드를 구현 )
 */

public class DownloadView extends AbstractView {
	@Override
	public String getContentType() {
		// 8bit 단위의 일련의 데이터
		return "application/octet-stream";
	}

	@Override
	// 파일 다운로드
	protected void renderMergedOutputModel(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = (String) map.get("path");
		System.out.println(path);
		String filename = request.getParameter("filename");
		String fname = request.getParameter("fname");
		String extension = fname.substring(fname.lastIndexOf("."));
		filename += extension;
		// 업로드 파일 객체
		File file = new File(path + filename);
		response.setContentType(this.getContentType());
		response.setContentLength((int) file.length());// 파일 크기 설정
		// 다운로드 파일에 대한 설정
		response.setHeader("Content-Disposition", "attachment; fileName="
				+ new String(file.getName().getBytes("UTF-8"), "8859_1"));
		// 데이터 인코딩이 바이너리 파일임을 명시
		response.setHeader("Content-Transfer-encoding", "binary");
		// response에 연결된 OutputStream
		OutputStream os = response.getOutputStream();
		// 업로드된 파일을 입력받기 위한 입력스트림
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		System.out.println(fis);
		System.out.println(path);
	}
}




