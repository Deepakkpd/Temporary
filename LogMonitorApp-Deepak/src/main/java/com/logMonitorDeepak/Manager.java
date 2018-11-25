package com.logMonitorDeepak;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Manager {

	public void processLogs(IndexForm indexForm) {
		System.out.println("Inside processLogs------");
		StringBuffer buffer = new StringBuffer();
		List<String> exceptionList = new ArrayList<String>();
		indexForm.setExceptionList(exceptionList);
		indexForm.setExceptionLog(buffer.toString());
		indexForm.setExceptionCount(null);
		
		try {
			File file = new File(indexForm.getLogUrl());
			if (file.exists()){
				System.out.println("Exists");
			}else {
				System.out.println("Not exist");
			}
			// input file
			FileInputStream fstream = new FileInputStream(indexForm.getLogUrl());

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;
			Boolean broken = false;
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains("Exception")){        // keyword
					broken = true;
					buffer.append("\n"+strLine+"\n");
					System.out.println("strLine:"+strLine);
					exceptionList.add(strLine);
				}

				boolean isPresent = strLine.indexOf("	at ") != -1 ? true : false;
				if (broken && isPresent) {
					buffer.append(" "+strLine+"\n");
				}
			}
	//		System.out.println("Exception \n"+buffer);
			in.close();
			indexForm.setExceptionLog(buffer.toString());
	//		System.out.println("exceptionList:"+exceptionList);
			indexForm.setExceptionList(exceptionList);
			System.out.println("Log processing Successfully");
			if(null!=exceptionList && !exceptionList.isEmpty()) {
				indexForm.setExceptionCount(exceptionList.size());
			}
		} catch (Exception e) {
			indexForm.setInvalidPath("true");
			System.err.println("Error: " + e.getMessage());
		}
		
	}
}
