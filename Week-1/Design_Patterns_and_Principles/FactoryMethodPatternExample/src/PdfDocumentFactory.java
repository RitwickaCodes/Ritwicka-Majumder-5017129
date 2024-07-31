
public class PdfDocumentFactory extends DocumentFactory{
	public PdfDocumentWriter createDocument() {
		return new PdfDocumentWriter();
	}
}
