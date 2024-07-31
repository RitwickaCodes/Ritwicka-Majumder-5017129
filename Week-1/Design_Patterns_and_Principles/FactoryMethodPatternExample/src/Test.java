
public class Test {

	public static void main(String[] args) {
		//Creation of Word Document
		DocumentFactory wordFactory = new WordDocumentFactory();
		Document wordDoc = wordFactory.createDocument();
		wordDoc.open();
		wordDoc.close();
		//Creation of Pdf Document
		DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();
        //Creation of Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
	}
}
