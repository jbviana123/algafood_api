insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Mineira');
insert into cozinha (id, nome) values (4, 'Japonesa');
insert into cozinha (id, nome) values (5, 'Tailandesa');


insert into restaurante (id, nome, taxa_frete, cozinha_id) values (1, 'Thai Gourmet', 10, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2, 'Thai Delivery', 9.50, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (3, 'Tuk Tuk Comida Indiana', 15, 2);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (4, 'Fogao de lenha', 9.5, 3);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (5, 'Comida mineira', 9.5, 3);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (6, 'Togu sushi', 10.5, 4);


insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Rio grande do sul');
insert into estado (id, nome) values (4, 'ceara');
insert into estado (id, nome) values (5, 'rio grande do norte');
insert into estado (id, nome) values (6, 'Para');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'santa catariana', 3);
insert into cidade (id, nome, estado_id) values (6, 'campina grande', 4);
insert into cidade (id, nome, estado_id) values (7, 'indaiatuba', 2);
insert into cidade (id, nome, estado_id) values (8, 'Aracaju', 5);
insert into cidade (id, nome, estado_id) values (9, 'taiobeiras', 1);

insert into cidade (id, nome, estado_id) values (10, 'campos do jordao', 2);


insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (4, 'Boleto');
insert into permissao (id, nome, descricao) values (1, 'LIBERAR PEDIDOS', 'Permite liberar pedidos');
insert into permissao (id, nome, descricao) values (2, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (3, 'EDITAR_COZINHAS', 'Permite editar cozinhas');