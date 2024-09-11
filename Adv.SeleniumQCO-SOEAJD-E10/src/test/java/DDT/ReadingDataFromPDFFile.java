package DDT;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingDataFromPDFFile {
	public static void main(String[] args) throws Throwable {

		File pdfFile = new File("./src/test/resources/Amazing JAVA - Learn JAVA Quickly (2017).pdf");
		PDDocument pdDoc = PDDocument.load(pdfFile);

		// To read no of pages in a PDF file
//		int pages = pdDoc.getNumberOfPages();
//		System.out.println(pages);

		// To read the text from PDF files from start to end
//		PDFTextStripper pdfts = new PDFTextStripper();
//		String data = pdfts.getText(pdDoc);
//		System.out.println(data);

		// To read the text from PDF files from any particular page
		PDFTextStripper pdfdata = new PDFTextStripper();
		pdfdata.setStartPage(3);
		pdfdata.setEndPage(3); // if end not specified then it will print till end by default (3-->lastpage)
		String dataAtPage3 = pdfdata.getText(pdDoc);
		System.out.println(dataAtPage3);
	}

}
