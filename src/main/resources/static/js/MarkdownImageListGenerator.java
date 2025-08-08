import java.io.File;

public class MarkdownImageListGenerator {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\KIIT\\OneDrive\\Desktop\\LEARNING\\Shopping_Cart\\src\\main\\resources\\static\\SCREENSHOTS"); // Folder name

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder does not exist or is not a directory.");
            return;
        }

        File[] files = folder.listFiles((dir, name) -> {
            String lowercase = name.toLowerCase();
            return lowercase.endsWith(".png") || lowercase.endsWith(".jpg")
                || lowercase.endsWith(".jpeg") || lowercase.endsWith(".gif");
        });

        if (files == null || files.length == 0) {
            System.out.println("No image files found in the folder.");
            return;
        }

        // Sort files alphabetically
        java.util.Arrays.sort(files);

        int count = 1;
        for (File file : files) {
            System.out.printf("![Screenshot %d](src/main/resources/static/SCREENSHOTS/%s)%n", count++, file.getName());
        }
    }
}
