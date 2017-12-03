create table categoria
(
    id int not null auto_increment,
    nome varchar(80) not null,
    primary key (id)
);

create table fornecedor
(
    id int not null auto_increment,
    nome varchar(80) not null,
    primary key (id)
);

create table produto
(
    id int not null auto_increment,
    nome varchar(100) not null,
    valor double not null,
    categoriaId int not null,
    fornecedorId int not null,
    primary key (id),
    foreign key (categoriaId) references categoria(id),
    foreign key (fornecedorId) references fornecedor(id)
);



insert into categoria (nome) values ('Calçado'), ('Roupas'), ('Bolsas e Acessorios'), ('Perfomes e Beleza');


insert into fornecedor (nome) values 
         ('Timberland'), ('Colcci'), ('Dumond'), ('Vizzano'), ('Luma Ventura')
        ,('Angel Basic'), ('Acrobat'), ('Balboa'), ('Grifle Company')
        ,('Jorge Alex'), ('Santa Lolla'), ('Legaspi')
        ,('Carolina Herrera'), ('Lancôme'), ('Ralph Lauren'), ('Kenzo');


insert into produto (nome, valor, categoriaId, fornecedorId) values
        ('Bota Timberland 6in Premium Boot - W Caramelo', 449.99, 1, 1)
        ,('Tênis Dumond Tag Prata',59.90,1,3)
        ,('Bota Chelsea Colcci Tiras Preto',319.90,1,2)
        ,('Tênis Vizzano Bico Redondo Branco',79.99,1,4)
        ,('Tênis Feminino Luma Ventura Rebeca Branco',59.9,1,5)
        ,('Vestido Angel Basic Longo Estampado Verde',59.99,2,6)
        ,('Vestido Ciganinha Acrobat Longo Floral Bege',64.99,2,7)
        ,('Vestido Ciganinha Balboa Curto Estampado Preto',74.99,2,8)
        ,('Calça Jeans GRIFLE COMPANY Flare Azul',59.99,2,9)
        ,('Bolsa Baú Jorge Alex Tassel Preta',134.99,3,10)
        ,('Bolsa Shopping Santa Lolla Correntes Preta',199.90,3,11)
        ,('Bolsa Legaspi Malta Marrom',339.90,3,12)
        ,('Hidratante Carolina Herrera Good Girl 200ml Azul',449.0,4,13)
        ,('Base Teint Visionnaire 03',269.99,4,14)
        ,('Perfume Amour Kenzo Parfums 100ml',369.99,4,16)
        ,('Perfume Polo Blue Ralph Lauren 200ml',419.99,4,15);


create view select_produto
(
      produto_id
    , produto_nome
    , produto_valor
    , fornecedor_id
    , fornecedor_nome
    , categoria_id
    , categoria_nome
)
as
(
    select
          p.id as 'produto_id'
        , p.nome as 'produto_nome'
        , p.valor as 'produto_valor'
        , f.id as 'fornecedor_id'
        , f.nome as 'fornecedor_nome'
        , c.id as 'categoria_id'
        , c.nome as 'categoria_nome'
    from produto p
    join fornecedor f on p.fornecedorId = f.id
    join categoria c on p.categoriaId = c.id
);
