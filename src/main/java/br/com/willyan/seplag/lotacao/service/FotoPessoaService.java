package br.com.willyan.seplag.lotacao.service;

import br.com.willyan.seplag.lotacao.domain.FotoPessoa;
import br.com.willyan.seplag.lotacao.repository.FotoPessoaRepository;
import br.com.willyan.seplag.lotacao.repository.PessoaRepository;
import io.minio.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class FotoPessoaService {

    private final MinioClient minioClient;

    @Autowired
    private MinioProperties minioProperties;

    private final FotoPessoaRepository fotoRepo;
    private final PessoaRepository pessoaRepo;

    public String uploadFoto(MultipartFile file, Long pesId) throws Exception {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();

        InputStream is = file.getInputStream();
        String bucket = minioProperties.getBucket();


        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucket)
                        .object(fileName)
                        .stream(is, file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );

        FotoPessoa foto = new FotoPessoa();
        foto.setFpData(LocalDate.now());
        foto.setFpBucket(bucket);
        foto.setFpHash(fileName);
        foto.setPessoa(pessoaRepo.findById(pesId).orElseThrow());
        fotoRepo.save(foto);

        return "Foto salva com sucesso: " + fileName;
    }

    public String gerarLinkTemporario(FotoPessoa foto) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(foto.getFpBucket())
                        .object(foto.getFpHash())
                        .expiry(5, TimeUnit.MINUTES)
                        .build()
        );
    }
}
