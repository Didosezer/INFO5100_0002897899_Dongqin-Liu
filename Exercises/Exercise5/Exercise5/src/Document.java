public interface Document {
    void open();
    void save();
    void close();
}
class WordDocument implements Document {
    public void open() {System.out.println("Opening Word document.");}
    public void save() {System.out.println("Saving Word document.");}
    public void close() {System.out.println("Closing Word document.");}
}
class ExcelDocument implements Document {
    public void open() {System.out.println("Opening Excel document.");}
    public void save() {System.out.println("Saving Excel document.");}
    public void close() {System.out.println("Closing Excel document.");}
    class DocumentFactory {
        public static Document getDocument(String type) {
            if ("word".equalsIgnoreCase(type)) {
                return new WordDocument();
            } else if ("excel".equalsIgnoreCase(type)) {
                return new ExcelDocument();
            } else {
                throw new IllegalArgumentException("Unknown document type: " + type);
            }
        }
    }

    public static void main(String[] args) {
        Document wordDoc = DocumentFactory.getDocument("word");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        Document excelDoc = DocumentFactory.getDocument("excel");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}



