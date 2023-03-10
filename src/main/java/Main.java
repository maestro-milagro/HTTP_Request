
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    protected static final String REMOTE_SERVICE_URI = "https://api.nasa.gov/planetary/apod?api_key=AQwBFe0eQWyHr9MCaXaCCpIVneyo1NaVAp43VMx3";

    protected static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("Some test service")
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
        //Создание объекта запроса с произвольными заголовками
        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        //Отправка запроса
        CloseableHttpResponse response = httpClient.execute(request);

        //Вывод полученных заголовков
        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);

        NASA_materials nasa_materials = mapper.readValue(
                response.getEntity().getContent(),
                new TypeReference<>() {
                }
        );
        String url = nasa_materials.getUrl();
        File file = new File(".", "space.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            file.createNewFile();
            fileWriter.write(url);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        response.close();
        httpClient.close();
    }
}
