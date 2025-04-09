INSERT INTO cidade (cid_nome, cid_uf) VALUES ('Cuiabá', 'MT');
INSERT INTO cidade (cid_nome, cid_uf) VALUES ('Várzea Grande', 'MT');

INSERT INTO endereco (end_tipo_logradouro, end_logradouro, end_numero, end_bairro, cid_id)
VALUES ('Rua', 'Av. Mato Grosso', 123, 'Centro', 1);

INSERT INTO unidade (unid_nome, unid_sigla) VALUES ('Secretaria de Saúde', 'SES');
INSERT INTO unidade (unid_nome, unid_sigla) VALUES ('Secretaria de Educação', 'SEDUC');

INSERT INTO unidade_endereco (unid_id, end_id) VALUES (1, 1);
INSERT INTO unidade_endereco (unid_id, end_id) VALUES (2, 1);

INSERT INTO pessoa (pes_nome, pes_data_nascimento, pes_sexo, pes_mae, pes_pai)
VALUES ('João da Silva', '1990-05-01', 'Masculino', 'Maria', 'José');

INSERT INTO servidor_efetivo (pes_id, se_matricula) VALUES (1, '123456');

INSERT INTO lotacao (pes_id, unid_id, lot_data_lotacao, lot_portaria)
VALUES (1, 1, CURRENT_DATE, 'PORT-001');

--(senha bcrypt para '123456')
INSERT INTO usuario (username, password)
VALUES ('admin', '$2a$10$CwTycUXWue0Thq9StjUM0uJ8y0nlPoBPwAckU4iR.XPFrgGIa2Nse');
