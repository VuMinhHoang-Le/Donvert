package com.donvert.upload_microservice;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MinIOContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mongodb.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

import java.io.File;

import static io.restassured.RestAssured.given;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UploadMicroserviceApplicationTests {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:7.0.5"));

    @Container
    static MinIOContainer minIOContainer = new MinIOContainer(DockerImageName.parse("minio/minio"))
            .withEnv("MINIO_ROOT_USER", "minioadmin")
            .withEnv("MINIO_ROOT_PASSWORD", "minioadmin");;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);

        registry.add("minio.url", minIOContainer::getS3URL);
        registry.add("minio.access-key", () -> "minioadmin");
        registry.add("minio.secret-key", () -> "minioadmin");
    }

    @BeforeEach
    void initBucket() throws Exception {
        var client = MinioClient.builder()
                .endpoint(minIOContainer.getS3URL())
                .credentials("minioadmin", "minioadmin")
                .build();

        boolean exists = client.bucketExists(
                BucketExistsArgs.builder().bucket("pdf").build()
        );

        if (!exists) {
            client.makeBucket(
                    MakeBucketArgs.builder().bucket("pdf").build()
            );
        }
    }

//    static {
//        mongoDBContainer.start();
//    }

    @Test
    void shouldUploadFileToMongoMinio() {
        File fileToUpload = new File("./db/test-db/test-file.pdf");
        given()
                .multiPart("file", fileToUpload)
                .when()
                .post("/api/file-upload/uploader")
                .then()
                .statusCode(200)
        ;
    }
}
