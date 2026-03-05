package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Config {
    private static Config config;
    private String pathFiles;
    private String nameCuentaTxt;
    private String nameCuentaCsv;
    private Properties properties;

    private Config(){
        this.properties = new Properties();
        try(FileInputStream entrada =
                    new FileInputStream("resources/config/appconfig.properties")){
            properties.load(entrada);
            this.pathFiles = properties.getProperty("path.files");
            this.nameCuentaTxt = properties.getProperty("file.name.ser");
            this.nameCuentaCsv = properties.getProperty("file.name.csv");

        }catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuracion: " + ex.getMessage());
        }
    }

    public static Config getInstance() {
        if (Objects.isNull(config)) {
            config = new Config();
        }
        return config;
    }

    public String getPathFiles() {
        return pathFiles;
    }

    public void setPathFiles(String pathFiles) {
        this.pathFiles = pathFiles;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}