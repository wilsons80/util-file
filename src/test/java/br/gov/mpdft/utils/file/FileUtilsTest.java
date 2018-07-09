package br.gov.mpdft.utils.file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class FileUtilsTest extends TestCase{
	
	String documentoPDF_P7S = null;
	String imagemJPG_P7S    = null;
	String audioMP3_P7S     = null;
	String videoMP4         = null;
	String videoMP4_P7S     = null;
	String arquivoOGG_P7S   = null;
	String audioOGG         = null;
	String videoMP3_P7S     = null;
	
			
	@Before
	public void setUp() throws Exception {
		videoMP4_P7S     = "src/test/resources/br/gov/mpdft/utils/arquivos/video_1280x720_5mb.mp4.p7s";
		documentoPDF_P7S = "src/test/resources/br/gov/mpdft/utils/arquivos/documento.pdf.p7s";
		imagemJPG_P7S    = "src/test/resources/br/gov/mpdft/utils/arquivos/cresc.JPG.p7s";
		audioMP3_P7S     = "src/test/resources/br/gov/mpdft/utils/arquivos/arquivo6.mp3.p7s";
		videoMP4         = "src/test/resources/br/gov/mpdft/utils/arquivos/video_1280x720_5mb.mp4";
		arquivoOGG_P7S   = "src/test/resources/br/gov/mpdft/utils/arquivos/file_example_OGG_640_2_7mg.ogg.p7s";
		audioOGG         = "src/test/resources/br/gov/mpdft/utils/arquivos/audio_example_OOG_2MG.ogg";
		videoMP3_P7S     = "src/test/resources/br/gov/mpdft/utils/arquivos/02.3_SAN.mp3.p7s";
	}

	@Test
	public void testVideoMP4_P7S() throws Exception {
		File arquivo = new File(videoMP4_P7S);
		byte[] buffer = new byte[(int) arquivo.length()];
		DataInputStream in = new DataInputStream(new FileInputStream(arquivo));
		in.readFully(buffer);
		in.close();
		
		String mimeType = FileUtils.getContentTypeDeArquivoAssinado(buffer);
		assertEquals("video/quicktime", mimeType);
	}

	@Test
	public void testDocumentoPDF_P7S() throws Exception {
		File arquivo = new File(documentoPDF_P7S);
		byte[] buffer = new byte[(int) arquivo.length()];
		DataInputStream in = new DataInputStream(new FileInputStream(arquivo));
		in.readFully(buffer);
		in.close();
		
		String mimeType = FileUtils.getContentTypeDeArquivoAssinado(buffer);
		assertEquals("application/pdf", mimeType);
	}
	
	@Test
	public void testImagemJPG_P7S() throws Exception {
		File arquivo = new File(imagemJPG_P7S);
		byte[] buffer = new byte[(int) arquivo.length()];
		DataInputStream in = new DataInputStream(new FileInputStream(arquivo));
		in.readFully(buffer);
		in.close();
		
		String mimeType = FileUtils.getContentTypeDeArquivoAssinado(buffer);
		assertEquals("image/jpeg", mimeType);
	}	
	
	@Test
	public void testAudioMP3_P7S() throws Exception {
		File arquivo = new File(audioMP3_P7S);
		byte[] buffer = new byte[(int) arquivo.length()];
		DataInputStream in = new DataInputStream(new FileInputStream(arquivo));
		in.readFully(buffer);
		in.close();
		
		String mimeType = FileUtils.getContentTypeDeArquivoAssinado(buffer);
		assertEquals("audio/mpeg", mimeType);
	}
	
	@Test
	public void testVideoMP4() throws Exception {
		String extensao = FilenameUtils.getExtension(videoMP4);
		String mimeType = FileUtils.getContentType(extensao);
		assertEquals("video/mp4", mimeType);
	}
	
	@Test
	public void testArquivoOGG_P7S() throws Exception {
		File arquivo = new File(arquivoOGG_P7S);
		byte[] buffer = new byte[(int) arquivo.length()];
		DataInputStream in = new DataInputStream(new FileInputStream(arquivo));
		in.readFully(buffer);
		in.close();
		
		String mimeType = FileUtils.getContentTypeDeArquivoAssinado(buffer);
		assertEquals("audio/ogg", mimeType);
	}
	
	@Test
	public void testAudioOGG() throws Exception {
		String extensao = FilenameUtils.getExtension(audioOGG);
		String mimeType = FileUtils.getContentType(extensao);
		assertEquals("audio/ogg", mimeType);
	}
	
	@Test
	public void testVideoMP3_P7S() throws Exception {
		File arquivo = new File(videoMP3_P7S);
		byte[] buffer = new byte[(int) arquivo.length()];
		DataInputStream in = new DataInputStream(new FileInputStream(arquivo));
		in.readFully(buffer);
		in.close();
		
		String mimeType = FileUtils.getContentTypeDeArquivoAssinado(buffer);
		assertEquals("video/mp4", mimeType);
	}
}
