package br.com.willyan.seplag.lotacao.service;

import br.com.willyan.seplag.lotacao.domain.FotoPessoa;
import br.com.willyan.seplag.lotacao.domain.Pessoa;
import br.com.willyan.seplag.lotacao.domain.ServidorEfetivo;
import br.com.willyan.seplag.lotacao.domain.Unidade;
import br.com.willyan.seplag.lotacao.dto.ServidorEfetivoConsultaDTO;
import br.com.willyan.seplag.lotacao.dto.ServidorEfetivoDTO;
import br.com.willyan.seplag.lotacao.repository.FotoPessoaRepository;
import br.com.willyan.seplag.lotacao.repository.LotacaoRepository;
import br.com.willyan.seplag.lotacao.repository.ServidorEfetivoRepository;
import br.com.willyan.seplag.lotacao.repository.UnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServidorEfetivoService {

    private final ServidorEfetivoRepository servidorEfetivoRepo;
    private final LotacaoRepository lotacaoRepo;
    private final UnidadeRepository unidadeRepo;
    private final FotoPessoaRepository fotoRepo;

    public List<ServidorEfetivoDTO> listarTodos() {
        return servidorEfetivoRepo.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ServidorEfetivoDTO salvar(ServidorEfetivoDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setPesId(dto.getPesId()); // ou crie nova Pessoa
        pessoa.setPesNome(dto.getPesNome());
        pessoa.setPesDataNascimento(dto.getPesDataNascimento());
        pessoa.setPesSexo(dto.getPesSexo());
        pessoa.setPesMae(dto.getPesMae());
        pessoa.setPesPai(dto.getPesPai());

        ServidorEfetivo servidor = new ServidorEfetivo();
        servidor.setPessoa(pessoa);
        servidor.setSeMatricula(dto.getSeMatricula());

        servidorEfetivoRepo.save(servidor);
        return toDTO(servidor);
    }

    public List<ServidorEfetivoConsultaDTO> buscarPorUnidade(Long unidId) {
        List<ServidorEfetivo> servidores = servidorEfetivoRepo.findByUnidadeId(unidId);

        return servidores.stream().map(se -> {
            String nome = se.getPessoa().getPesNome();
            int idade = Period.between(se.getPessoa().getPesDataNascimento(), LocalDate.now()).getYears();
            String unidade = unidadeRepo.findById(unidId).map(Unidade::getUnidNome).orElse("Desconhecida");
            String foto = fotoRepo.findByPessoaPesId(se.getPesId())
                    .stream().findFirst()
                    .map(f -> gerarLinkTemporario(f)) // TODO: MinIO
                    .orElse(null);
            return new ServidorEfetivoConsultaDTO(nome, idade, unidade, foto);
        }).toList();
    }

    private String gerarLinkTemporario(FotoPessoa f) {
        return "https://localhost:9000/" + f.getFpBucket() + "/" + f.getFpHash();
    }

    private ServidorEfetivoDTO toDTO(ServidorEfetivo se) {
        Pessoa p = se.getPessoa();
        return new ServidorEfetivoDTO(
                p.getPesId(), p.getPesNome(), p.getPesDataNascimento(),
                p.getPesSexo(), p.getPesMae(), p.getPesPai(),
                se.getSeMatricula()
        );
    }
}
