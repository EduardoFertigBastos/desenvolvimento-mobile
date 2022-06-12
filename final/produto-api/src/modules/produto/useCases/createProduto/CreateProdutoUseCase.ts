import { ProdutoRepository } from "../../repositories/ProdutoRepository";

interface IRequest {
  nome: string;
  descricao: string;
  preco: number;
}

class CreateProdutoUseCase {
  constructor(private produtosRepository: ProdutoRepository) {}
  execute({ nome, descricao, preco }: IRequest) {
    this.produtosRepository.create({ nome, descricao, preco });
  }
}

export { CreateProdutoUseCase };
