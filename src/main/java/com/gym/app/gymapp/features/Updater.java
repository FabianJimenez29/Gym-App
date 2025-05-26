import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.*;

public class Updater {

    private static final String VERSION_LOCAL = "V1.0";
    private static final String VERSION_URL = "https://raw.githubusercontent.com/FabianJimenez29/Gym-App/main/version.txt";
    private static final String DOWNLOAD_URL =
        "https://github.com/FabianJimenez29/Gym-App/releases/download/V1.0/GymApp-1.0-SNAPSHOT.jar";
    private static final String LOCAL_JAR_PATH = "GymApp-1.0-SNAPSHOT.jar";

    public static void main(String[] args) {
        try {
            String versionRemota = readRemoteVersion(VERSION_URL);

            System.out.println("Versión local: " + VERSION_LOCAL);
            System.out.println("Versión remota: " + versionRemota);

            if (!VERSION_LOCAL.equals(versionRemota)) {
                System.out.println("Nueva versión detectada. Actualizando...");
                downloadFile(DOWNLOAD_URL, LOCAL_JAR_PATH);
                System.out.println("Actualización completada.");
            } else {
                System.out.println("No hay actualización disponible.");
            }

        } catch (Exception e) {
            System.err.println("Error durante la actualización: " + e.getMessage());
        }
    }

    private static String readRemoteVersion(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return in.readLine().trim();
        }
    }

    private static void downloadFile(String urlStr, String localPath) throws IOException {
        // Código igual que antes para descargar el archivo...
        URL url = new URL(urlStr);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (InputStream inputStream = httpConn.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(localPath)) {

                byte[] buffer = new byte[4096];
                int bytesRead;

                System.out.println("Descargando archivo...");

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            throw new IOException("No se pudo descargar el archivo. Código HTTP: " + responseCode);
        }
        httpConn.disconnect();
    }
}