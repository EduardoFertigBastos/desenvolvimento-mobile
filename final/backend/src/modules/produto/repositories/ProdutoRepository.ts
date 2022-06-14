import { Produto } from "../model/Produto";

interface ICreateProdutoDTO {
  nome: string;
  descricao: string;
  preco: number;
}

interface IUpdateProdutoDTO {
  nome: string;
  descricao: string;
  preco: number;
}

class ProdutoRepository {
  private produtos: Produto[];

  private static INSTANCE: ProdutoRepository;

  private constructor() {
    this.produtos = [];
  }

  public static getInstance(): ProdutoRepository {
    if (!ProdutoRepository.INSTANCE) {
      ProdutoRepository.INSTANCE = new ProdutoRepository();
    }
    return ProdutoRepository.INSTANCE;
  }

  list() {
    return this.produtos;
  }

  create({ nome, descricao, preco }: ICreateProdutoDTO) {
    const produto = new Produto();

    Object.assign(produto, {
      nome,
      descricao,
      preco,
      created_at: new Date(),
    });

    this.produtos.push(produto);
  }

  update(id: string, { nome, descricao, preco }: IUpdateProdutoDTO) {
    const produto = this.findById(id);

    if (produto) {
      const indice = this.produtos.findIndex((p) => p.id === id);

      const produtoUpdated: Produto = {
        ...produto,
        nome,
        descricao,
        preco,
      };

      this.produtos[indice] = produtoUpdated;
    }
  }

  delete(id: string) {
    const newList = this.produtos.filter((p) => p.id !== id);

    this.produtos = newList;
  }

  findById(id: string): Produto | undefined {
    const user = this.produtos.find((u) => u.id === id);

    return user;
  }
}

export { ProdutoRepository };
