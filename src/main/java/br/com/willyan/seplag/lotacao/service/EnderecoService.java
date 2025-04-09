package br.com.willyan.seplag.lotacao.service;

import br.com.willyan.seplag.lotacao.domain.Endereco;
import br.com.willyan.seplag.lotacao.domain.Lotacao;
import br.com.willyan.seplag.lotacao.domain.ServidorEfetivo;
import br.com.willyan.seplag.lotacao.domain.UnidadeEndereco;
import br.com.willyan.seplag.lotacao.dto.EnderecoFuncionalDTO;
import br.com.willyan.seplag.lotacao.repository.LotacaoRepository;
import br.com.willyan.seplag.lotacao.repository.ServidorEfetivoRepository;
import br.com.willyan.seplag.lotacao.repository.UnidadeEnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final ServidorEfetivoRepository servidorEfetivoRepo;
    private final LotacaoRepository lotacaoRepo;
    private final UnidadeEnderecoRepository unidadeEnderecoRepo;

    public List<EnderecoFuncionalDTO> buscarEnderecoPorParteDoNome(String nome) {
        List<ServidorEfetivo> servidores = servidorEfetivoRepo.findByPessoaPesNomeContainingIgnoreCase(nome);

        return servidores.stream().flatMap(se -> {
            List<Lotacao> lotacoes = lotacaoRepo.findByPessoaPesId(se.getPesId());

            return lotacoes.stream().flatMap(lot -> {
                List<UnidadeEndereco> ues = unidadeEnderecoRepo.findByUnidadeUnidId(lot.getUnidade().getUnidId());

                return ues.stream().map(ue -> {
                    Endereco e = ue.getEndereco();
                    return new EnderecoFuncionalDTO(
                            se.getPessoa().getPesNome(),
                            e.getEndLogradouro(),
                            String.valueOf(e.getEndNumero()),
                            e.getEndBairro(),
                            e.getCidade().getCidNome(),
                            e.getCidade().getCidUf()
                    );
                });
            });
        }).toList();
    }
}
