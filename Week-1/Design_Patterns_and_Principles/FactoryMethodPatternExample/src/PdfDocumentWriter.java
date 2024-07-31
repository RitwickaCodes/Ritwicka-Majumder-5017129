
public class PdfDocumentWriter implements PdfDocument{
	@Override
	public void open() {
        System.out.println("Opening PDF document.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document");
    }
	

}
