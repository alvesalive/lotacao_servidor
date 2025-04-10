package br.com.willyan.seplag.lotacao.service;

import br.com.willyan.seplag.lotacao.domain.Pessoa;
import br.com.willyan.seplag.lotacao.domain.ServidorTemporario;
import br.com.willyan.seplag.lotacao.dto.ServidorTemporarioDTO;
import br.com.willyan.seplag.lotacao.repository.PessoaRepository;
import br.com.willyan.seplag.lotacao.repository.ServidorTemporarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServidorTemporarioService {

    private final ServidorTemporarioRepository repository;
    private final PessoaRepository pessoaRepo;

    public List<ServidorTemporarioDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ServidorTemporarioDTO salvar(ServidorTemporarioDTO dto) {
        Pessoa pessoa = dto.getPesId() != null ?
                pessoaRepo.findById(dto.getPesId()).orElse(new Pessoa()) :
                new Pessoa();

        pessoa.setPesNome(dto.getPesNome());
        pessoa.setPesDataNascimento(dto.getPesDataNascimento());
        pessoa.setPesSexo(dto.getPesSexo());
        pessoa.setPesMae(dto.getPesMae());
        pessoa.setPesPai(dto.getPesPai());

        pessoa = pessoaRepo.save(pessoa);

        ServidorTemporario servidor = repository.findById(pessoa.getPesId()).orElse(new ServidorTemporario());
        servidor.setPessoa(pessoa);
        servidor.setStDataAdmissao(dto.getStDataAdmissao());
        servidor.setStDataDemissao(dto.getStDataDemissao());

        servidor = repository.save(servidor);

        return toDTO(servidor);
    }

    private ServidorTemporarioDTO toDTO(ServidorTemporario servidor) {
        Pessoa p = servidor.getPessoa();
        ServidorTemporarioDTO dto = new ServidorTemporarioDTO();
        dto.setPesId(p.getPesId());
        dto.setPesNome(p.getPesNome());
        dto.setPesDataNascimento(p.getPesDataNascimento());
        dto.setPesSexo(p.getPesSexo());
        dto.setPesMae(p.getPesMae());
        dto.setPesPai(p.getPesPai());
        dto.setStDataAdmissao(servidor.getStDataAdmissao());
        dto.setStDataDemissao(servidor.getStDataDemissao());
        return dto;
    }
}
