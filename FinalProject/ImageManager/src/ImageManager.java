import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ImageManager extends Application {
    private final FlowPane thumbnailPane = new FlowPane();
    private final ChoiceBox<String> formatChoiceBox = new ChoiceBox<>();
    private List<File> uploadedFiles;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image Manager");

        Button uploadButton = new Button("Upload Images");
        Button downloadButton = new Button("Download Converted Images");

        uploadButton.setOnAction(e -> uploadImages());
        downloadButton.setOnAction(e -> convertImages());

        Label formatLabel = new Label("Change Image Format To:");
        formatChoiceBox.getItems().addAll("png", "jpg", "jpeg", "gif");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        thumbnailPane.setHgap(10);
        thumbnailPane.setAlignment(Pos.CENTER);

        grid.add(uploadButton, 0, 0);
        grid.add(thumbnailPane, 0, 1, 2, 1); // Span two columns for thumbnail pane
        grid.add(formatLabel, 0, 2);
        grid.add(formatChoiceBox, 1, 2);
        grid.add(downloadButton, 0, 3, 2, 1); // Span two columns for download button

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void uploadImages() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        uploadedFiles = fileChooser.showOpenMultipleDialog(null);

        thumbnailPane.getChildren().clear(); // Clear existing thumbnails

        if (uploadedFiles != null && !uploadedFiles.isEmpty()) {
            for (File file : uploadedFiles) {
                Image image = new Image(file.toURI().toString());
                ImageView thumbnailView = new ImageView(image);
                thumbnailView.setFitWidth(100);
                thumbnailView.setFitHeight(100);

                // Display image properties
                VBox imageInfoBox = new VBox(5); // Added spacing between elements
                imageInfoBox.setAlignment(Pos.CENTER);
                imageInfoBox.getChildren().addAll(thumbnailView, getImageInfoLabel(file));

                thumbnailPane.getChildren().add(imageInfoBox);
            }
        }
    }

    private Label getImageInfoLabel(File file) {
        Label imageInfoLabel = new Label();
        imageInfoLabel.setText("File Name: " + file.getName() + "\n" +
                "Width: " + getImageWidth(file) + "\n" +
                "Height: " + getImageHeight(file) + "\n" +
                "Camera: " + getCameraInfo(file) + "\n" +
                "Location: " + getLocationInfo(file));
        return imageInfoLabel;
    }

    private String getLocationInfo(File file) {
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);

            if (gpsDirectory != null && gpsDirectory.getGeoLocation() != null) {
                // Get the geolocation
                double latitude = gpsDirectory.getGeoLocation().getLatitude();
                double longitude = gpsDirectory.getGeoLocation().getLongitude();

                // Format the latitude and longitude
                String formattedLatitude = String.format("%.4f", latitude);
                String formattedLongitude = String.format("%.4f", longitude);

                return "Latitude: " + formattedLatitude + ", Longitude: " + formattedLongitude;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Location Not available";
    }

    private String getCameraInfo(File file) {
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            String make = null;
            String model = null;
            // Print all directories and tags (for debugging purposes)
            for (var directory : metadata.getDirectories()) {
                for (var tag : directory.getTags()) {
                    System.out.println(tag);
                    String tagName = tag.getTagName();
                    String desc = tag.getDescription();
                    if (tagName.equals("Make")) {
                        make = desc;
                    } else if (tagName.equals("Model")) {
                        model = desc;
                    }
                    if (Objects.nonNull(make) && Objects.nonNull(model)) {
                        return make + " " + model.trim();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading camera info: " + e.getMessage());
            e.printStackTrace();
        }

        return "Camera Info Not available";
    }


    private double getImageWidth(File file) {
        return new Image(file.toURI().toString()).getWidth();
    }

    private double getImageHeight(File file) {
        return new Image(file.toURI().toString()).getHeight();
    }

    private void convertImages() {
        if (uploadedFiles != null && !uploadedFiles.isEmpty()) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Images");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*." + formatChoiceBox.getValue()));

            for (File uploadedFile : uploadedFiles) {
                File convertedFile = fileChooser.showSaveDialog(null);

                if (convertedFile != null) {
                    try {
                        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(new Image(uploadedFile.toURI().toString()), null);
                        ImageIO.write(bufferedImage, formatChoiceBox.getValue(), convertedFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
