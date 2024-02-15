package com.example.bank;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base16InputStream;
import org.springframework.core.io.InputStreamSource;

import jakarta.activation.DataSource;

public class ByteArrayResourse implements DataSource, InputStreamSource {
	private ByteArrayInputStream attachment;
	

	public  ByteArrayResourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ByteArrayResourse(ByteArrayInputStream pdfReport) {
		super();
		this.attachment = pdfReport;
	}

	public ByteArrayInputStream getAttachment() {
		return attachment;
	}

	public void setAttachment(ByteArrayInputStream attachment) {
		this.attachment = attachment;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return null;
		
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
