package model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class PassDigest {
	public static String build(String pass)  {


	//ハッシュを生成したい元の文字列
	String source = pass;
	//ハッシュ生成前にバイト配列に置き換える際のCharset
	Charset charset = StandardCharsets.UTF_8;
	//ハッシュアルゴリズム
	String algorithm = "MD5";

	//ハッシュ生成処理
	byte[] bytes = null;
	try {
		bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
	} catch (NoSuchAlgorithmException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	String result = DatatypeConverter.printHexBinary(bytes);
	//標準出力
	System.out.println(result);
	return result;
	}
	
//	public static void main(String[]args) {
//		build("アイウエオ");
//		
//	}
	
}


