package br.gov.mpdft.utils.file;

import org.apache.tika.Tika;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;

public class FileUtils {
	
	
	public static String getContentTypeDeArquivoAssinado(byte[] buffer) {
		return getContentType(buffer,"p7s");
	}
	
	public static String getContentType(byte[] buffer, String extensao) {
		Tika tika = new Tika();
		if(extensao.replace(".", "").equals("p7s") == Boolean.FALSE){
			return tika.detect("a." + extensao);
		}
		
		return tika.detect(getConteudoOriginalDeArquivoAssinado(buffer));
	}

	public static String getContentType(String extensao) {
		Tika tika = new Tika();
		return tika.detect("a." + extensao);
	}
	
	public static byte[] getConteudoOriginalDeArquivoAssinado(byte[] buffer){
		try {
			CMSSignedData sd = new CMSSignedData(buffer);
			CMSProcessableByteArray cpb = (CMSProcessableByteArray) sd.getSignedContent();
			return (byte[]) cpb.getContent();
		} catch (CMSException e) {
			throw new IllegalArgumentException(e);
		}
	}

}