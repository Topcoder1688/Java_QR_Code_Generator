package com.codewage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGenerator {

	public static void main(String[] args) throws WriterException, IOException {
		
		//URL that will open when we scan the QR
		String URL = "https://www.github.com";

		//Output image file with QR
		String qrOutputPath = "qr.png";

		//String encoding
		String charsetEncoding = "UTF-8";

		Map<EncodeHintType, ErrorCorrectionLevel> qrMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  

		qrMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  

		generateQRcode(URL, qrOutputPath, charsetEncoding, qrMap, 200, 200);

		System.out.println("QR Image generated successfully."); 

	}

	public static void generateQRcode(String URL, String qrOutputPath, String charset, Map map, int height, int width) throws WriterException, IOException  
	{  
		BitMatrix matrix = new MultiFormatWriter().encode(new String(URL.getBytes(charset), charset), BarcodeFormat.QR_CODE, width, height);  

		MatrixToImageWriter.writeToFile(matrix, qrOutputPath.substring(qrOutputPath.lastIndexOf('.') + 1), new File(qrOutputPath));  
	}  



}
