
public class ExcelDocumentFactory extends DocumentFactory{
	public ExcelDocumentWriter createDocument() {
		return new ExcelDocumentWriter();
	}
}