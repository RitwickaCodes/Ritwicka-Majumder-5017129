
public class WordDocumentFactory extends DocumentFactory{
	public WordDocumentWriter createDocument() {
		return new WordDocumentWriter();
	}
}
