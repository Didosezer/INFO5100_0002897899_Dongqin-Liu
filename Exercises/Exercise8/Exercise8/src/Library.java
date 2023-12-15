import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Library{

    public static void main(String[] args) throws Exception {

        String xmlString = "<Library>" +
                "<Book><Title>1984</Title><PublishedYear>1949</PublishedYear><NumberOfPages>328</NumberOfPages><Author>George Orwell</Author></Book>" +
                "<Book><Title>To Kill a Mockingbird</Title><PublishedYear>1960</PublishedYear><NumberOfPages>281</NumberOfPages><Author>Harper Lee</Author></Book>" +
                "<Book><Title>Pride and Prejudice</Title><PublishedYear>1813</PublishedYear><NumberOfPages>432</NumberOfPages><Author>Jane Austen</Author></Book>" +
                "</Library>";

        // Parse and manipulate XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlString)));

        // Print original XML
        printXml(document);

        // Add new book to XML
        addNewBookToXml(document, "New Book", "2023", "300", "New Author");
        printXml(document); // Reprint XML

        // Books in JSON
        String jsonString = "{\"Library\":{\"Books\":[" +
                "{\"Title\":\"1984\",\"PublishedYear\":1949,\"NumberOfPages\":328,\"Author\":\"George Orwell\"}," +
                "{\"Title\":\"To Kill a Mockingbird\",\"PublishedYear\":1960,\"NumberOfPages\":281,\"Author\":\"Harper Lee\"}," +
                "{\"Title\":\"Pride and Prejudice\",\"PublishedYear\":1813,\"NumberOfPages\":432,\"Author\":\"Jane Austen\"}" +
                "]}}";

        // Parse and manipulate JSON
        JSONObject jsonObject = new JSONObject(jsonString);

        // Print original JSON
        System.out.println(jsonObject.toString(4));

        // Add new book to JSON
        addNewBookToJson(jsonObject, "New Book", 2023, 123, "New Author");
        System.out.println(jsonObject.toString(4)); // Reprint JSON
    }

    private static void printXml(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
        System.out.println(result.getWriter().toString());
    }

    private static void addNewBookToXml(Document doc, String title, String year, String pages, String author) {
        Node library = doc.getFirstChild();

        Element newBook = doc.createElement("Book");
        newBook.appendChild(createElement(doc, "Title", title));
        newBook.appendChild(createElement(doc, "PublishedYear", year));
        newBook.appendChild(createElement(doc, "NumberOfPages", pages));
        newBook.appendChild(createElement(doc, "Author", author));

        library.appendChild(newBook);
    }

    private static Element createElement(Document doc, String elementName, String text) {
        Element element = doc.createElement(elementName);
        element.appendChild(doc.createTextNode(text));
        return element;
    }

    private static void addNewBookToJson(JSONObject jsonObject, String title, int year, int pages, String author) {
        JSONArray books = jsonObject.getJSONObject("Library").getJSONArray("Books");
        JSONObject newBook = new JSONObject();
        newBook.put("Title", title);
        newBook.put("PublishedYear", year);
        newBook.put("NumberOfPages", pages);
        newBook.put("Author", author);
        books.put(newBook);
    }
}

